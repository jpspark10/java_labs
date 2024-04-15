package SecondTask;

import java.util.Iterator;

public class PrimesGeneratorTest {
    public static void primeGenTest() {
        System.out.println("\n---Second Task---\n");
        int N = 10;

        System.out.println("Прямой порядок:");
        PrimesGenerator primesForward = new PrimesGenerator(N);
        for (int prime : primesForward) {
            System.out.print(prime + " ");
        }

        System.out.println("\n\nОбратный порядок:");
        PrimesGenerator primesReverse = new PrimesGenerator(N);
        Iterator<Integer> reverseIterator = primesReverse.iterator();
        Integer[] primesReverseArray = new Integer[N];
        int index = N - 1;
        while (((Iterator<?>) reverseIterator).hasNext()) {
            primesReverseArray[index--] = reverseIterator.next();
        }

        for (int prime : primesReverseArray) {
            System.out.print(prime + " ");
        }
    }
}
