package FirstTask;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 7777)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Калькулятор запущен...");

            while (true) {
                System.out.print("Введите выражение (например, 2 + 3): ");
                String expression = scanner.nextLine();
                output.println(expression);

                String response = input.readLine();
                System.out.println("Результат: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

