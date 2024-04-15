package SecondTask;

import java.util.Iterator;

public class PrimesGenerator implements Iterable<Integer> {
    private int count;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator(count);
    }

    private static class PrimesIterator implements Iterator<Integer> {
        private int generatedCount;
        private int currentPrime = 2;

        public PrimesIterator(int count) {
            this.generatedCount = count;
        }

        @Override
        public boolean hasNext() {
            return generatedCount > 0;
        }

        @Override
        public Integer next() {
            int nextPrime = currentPrime;
            generatedCount--;
            currentPrime = getNextPrime(currentPrime);
            return nextPrime;
        }

        private int getNextPrime(int current) {
            int next = current + 1;
            while (!isPrime(next)) {
                next++;
            }
            return next;
        }

        private boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}


