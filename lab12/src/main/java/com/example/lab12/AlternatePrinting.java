package com.example.lab12;
public class AlternatePrinting {
    private final Object lock = new Object();
    private boolean isFirstThreadTurn = true;

    class PrintThread extends Thread {
        private final String name;

        public PrintThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while ((isFirstThreadTurn && "Поток2".equals(name)) || (!isFirstThreadTurn && "Поток1".equals(name))) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(name);
                    isFirstThreadTurn = !isFirstThreadTurn;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        AlternatePrinting alternatePrinting = new AlternatePrinting();
        PrintThread thread1 = alternatePrinting.new PrintThread("Поток1");
        PrintThread thread2 = alternatePrinting.new PrintThread("Поток2");

        thread1.start();
        thread2.start();
    }
}
