package Tasks.FifthTask;

import java.util.function.Supplier;
import java.util.Random;

public class RandomNumberGenerator {

    private static final Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(11); // 0 (включительно) до 11 (исключительно)

    public static int generateRandomNumber() {
        return randomNumberSupplier.get();
    }

}
