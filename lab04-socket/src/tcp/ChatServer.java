package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static final int PORT = 5000;
    private static final int MAX_CLIENTS = 20;

    // Cấu trúc Thread-safe để quản lý danh sách Client: Nickname -> PrintWriter
    private static final Map<String, PrintWriter> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(MAX_CLIENTS);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Chat Server dang lang nghe tren port " + PORT);

            while (true) {
                Socket socket = server.accept();
                pool.submit(new ClientHandler(socket));
            }
        } catch (IOException e) {
            System.err.println("Loi Server: " + e.getMessage());
        } finally {
            pool.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private String nickname;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String clientAddr = socket.getRemoteSocketAddress().toString();
            try (
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)
                );
                PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true
                )
            ) {
                this.out = writer;

                // 1. Xử lý đăng ký Nickname
                out.println("NHAP_NICKNAME: Nhap biet danh cua ban:");
                while (true) {
                    String input = in.readLine();
                    if (input == null) return;
                    
                    String name = input.trim();
                    if (name.isEmpty()) {
                        out.println("ERR Nickname khong duoc de rong. Nhap lai:");
                        continue;
                    }

                    synchronized (clients) {
                        if (clients.containsKey(name)) {
                            out.println("ERR Nickname da ton tai. Nhap lai:");
                        } else {
                            this.nickname = name;
                            clients.put(nickname, out);
                            out.println("OK CHAT_READY Chao mung " + nickname + "! Dung MSG <noi_dung>, USERS, hoac QUIT.");
                            broadcast("[HETHONG] " + nickname + " da tham gia phong chat.", nickname);
                            break;
                        }
                    }
                }

                // 2. Vòng lặp nhận và xử lý lệnh
                String request;
                while ((request = in.readLine()) != null) {
                    String trimmed = request.trim();
                    if (trimmed.equalsIgnoreCase("QUIT")) {
                        out.println("OK BYE");
                        break;
                    } else if (trimmed.equalsIgnoreCase("USERS")) {
                        out.println("OK USERS: " + String.join(", ", clients.keySet()));
                    } else if (trimmed.regionMatches(true, 0, "MSG ", 0, 4)) {
                        String msgContent = trimmed.substring(4).trim();
                        if (!msgContent.isEmpty()) {
                            broadcast("[" + nickname + "]: " + msgContent, nickname);
                            out.println("OK DA_GUI");
                        } else {
                            out.println("ERR NO_CONTENT Noi dung tin nhan rong.");
                        }
                    } else {
                        out.println("ERR UNKNOWN_COMMAND Lenh khong hop le. Dung MSG <noi_dung>, USERS, QUIT.");
                    }
                }
            } catch (IOException e) {
                System.err.println("Loi ket noi client " + clientAddr + ": " + e.getMessage());
            } finally {
                // 3. Dọn dẹp và thông báo khi client ngắt kết nối
                if (nickname != null) {
                    clients.remove(nickname);
                    broadcast("[HETHONG] " + nickname + " da roi phong chat.", null);
                    System.out.println("Client ngat ket noi: " + nickname);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    // Ignored
                }
            }
        }

        // Gửi tin nhắn Broadcast đến tất cả các client
        private void broadcast(String message, String excludeUser) {
            for (Map.Entry<String, PrintWriter> entry : clients.entrySet()) {
                if (excludeUser == null || !entry.getKey().equalsIgnoreCase(excludeUser)) {
                    entry.getValue().println(message);
                }
            }
        }
    }
}