package FirstTask;

import java.io.*;
import java.net.*;

public class CalculatorServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер запущен...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключение от клиента: " + socket);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String request;
                while ((request = input.readLine()) != null) {
                    String[] tokens = request.split(" ");
                    double result;

                    try {
                        double operand1 = Double.parseDouble(tokens[0]);
                        double operand2 = Double.parseDouble(tokens[2]);

                        switch (tokens[1]) {
                            case "+":
                                result = operand1 + operand2;
                                break;
                            case "-":
                                result = operand1 - operand2;
                                break;
                            case "*":
                                result = operand1 * operand2;
                                break;
                            case "/":
                                if (operand2 == 0) {
                                    output.println("Ошибка: деление на ноль");
                                    continue;
                                }
                                result = operand1 / operand2;
                                break;
                            default:
                                output.println("Ошибка: неверная операция");
                                continue;
                        }

                        output.println(result);
                    } catch (NumberFormatException e) {
                        output.println("Ошибка: неверный формат чисел");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

