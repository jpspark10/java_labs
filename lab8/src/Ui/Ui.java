package Ui;

import Tasks.EighthTask.Student;
import Tasks.EighthTask.StudentTest;
import Tasks.FifthTask.RandomNumberGenerator;
import Tasks.FirstTask.StringUtilsTest;
import Tasks.FourthTask.NumberChecker;
import Tasks.SecondTask.StringChecker;
import Tasks.SeventhTask.ClientCheck;
import Tasks.SixthTask.StreamUtilsCheck;
import Tasks.ThirdTask.HeavyBox;

import java.time.LocalDate;
import java.util.Scanner;

public class Ui {
    static public void startUi(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.println("----choose task from 1 to 8, any other to exit----");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    StringUtilsTest.stringUtilsCheck();
                    break;
                case 2:
                    Scanner wordScan = new Scanner(System.in);
                    System.out.print("enter ur word: ");
                    String word = wordScan.nextLine();
                    System.out.println(StringChecker.checkString(word));
                    break;
                case 3:
                    HeavyBox box = new HeavyBox(10);
                    box.shipWithMessage();
                    break;
                case 4:
                    System.out.print("enter ur number: ");
                    int number = scanner.nextInt();
                    System.out.println(NumberChecker.checkNumber(number));
                    break;
                case 5:
                    int randNumb = RandomNumberGenerator.generateRandomNumber();
                    System.out.println("ur random number: " + randNumb);
                    break;
                case 6:
                    StreamUtilsCheck.streamUtilsTest();
                    break;
                case 7:
                    ClientCheck.clientTest();
                    break;
                case 8:
                    StudentTest.studentCheck();
                    break;
                default:
                    return;
            }

        }

    }
}
