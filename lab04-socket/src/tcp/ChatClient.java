package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClient {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 5000;

        try (
            Socket socket = new Socket(host, port);
            BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8)
            );
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)
            );
            PrintWriter out = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true
            )
        ) {
            // Thread riêng để liên tục lắng nghe tin nhắn từ Server trả về
            Thread receiverThread = new Thread(() -> {
                try {
                    String serverMsg;
                    while ((serverMsg = in.readLine()) != null) {
                        System.out.println(serverMsg);
                    }
                } catch (IOException e) {
                    System.out.println("Da ngat ket noi voi Server.");
                }
            });
            receiverThread.start();

            // Thread chính xử lý nhập dữ liệu từ bàn phím để gửi lên Server
            String userInput;
            while ((userInput = console.readLine()) != null) {
                out.println(userInput);
                if (userInput.trim().equalsIgnoreCase("QUIT")) {
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Port phai la so nguyen.");
        } catch (IOException e) {
            System.err.println("Loi ket noi Server: " + e.getMessage());
        }
    }
}