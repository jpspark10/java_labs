package FirstTask;

import java.util.*;

public class FirstTask {

    public static void showFirst(){
        System.out.println("\n---First task---\n");
        int n = 10;
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println("a) Массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("b) Список:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        Collections.sort(list);

        System.out.println("c) Список после сортировки (по возрастанию):");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        Collections.reverse(list);

        System.out.println("d) Список после сортировки (по убыванию):");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        Collections.shuffle(list);

        System.out.println("e) Список после перемешивания:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        Collections.rotate(list, 1);

        System.out.println("f) Список после циклического сдвига на 1 элемент:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

        System.out.println("g) Список с уникальными элементами:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();



        int[] array2 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array2[i] = list.get(i);
        }

        System.out.println("i) Массив, полученный из списка:");
        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
