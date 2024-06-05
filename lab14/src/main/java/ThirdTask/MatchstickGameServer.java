package ThirdTask;

import java.io.*;
import java.net.*;

public class MatchstickGameServer {
    private static final int TOTAL_MATCHSTICKS = 37;
    private static final int MAX_MATCHSTICKS_TO_TAKE = 5;

    private int matchsticksLeft;
    private boolean player1Turn;

    public MatchstickGameServer() {
        matchsticksLeft = TOTAL_MATCHSTICKS;
        player1Turn = true;
    }

    public synchronized String processMove(int matchsticksTaken) {
        // Проверяем правильность хода
        if (matchsticksTaken < 1 || matchsticksTaken > MAX_MATCHSTICKS_TO_TAKE || matchsticksTaken > matchsticksLeft) {
            return "Неверное количество спичек";
        }

        // Отнимаем количество взятых спичек от общего числа
        matchsticksLeft -= matchsticksTaken;

        // Проверяем, если спичек не осталось, завершаем игру
        if (matchsticksLeft <= 0) {
            return player1Turn ? "Игрок 1 победил!" : "Игрок 2 победил!";
        }

        // Переключаем ход на другого игрока
        player1Turn = !player1Turn;

        // Возвращаем текущее состояние игры
        return "Осталось спичек: " + matchsticksLeft + ". Ходит " + (player1Turn ? "Игрок 1" : "Игрок 2");
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер запущен...");

            MatchstickGameServer gameServer = new MatchstickGameServer();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключение от клиента: " + socket);

                new Thread(() -> {
                    try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                        while (true) {
                            String move = input.readLine();
                            if (move == null) break;

                            int matchsticksTaken = Integer.parseInt(move);
                            String result = gameServer.processMove(matchsticksTaken);
                            output.println(result);

                            if (result.contains("победил")) break; // игра завершена
                        }

                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

