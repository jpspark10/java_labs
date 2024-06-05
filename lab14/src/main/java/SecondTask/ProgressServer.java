package SecondTask;

import java.io.*;
import java.net.*;

public class ProgressServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер запущен...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключение от клиента: " + socket);

                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                new Thread(() -> {
                    try {
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(100); // имитация длительной операции
                            output.println(i);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

