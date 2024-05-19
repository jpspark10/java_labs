package com.example.lab122.FirstTask;

import java.util.concurrent.TimeUnit;

public class SynchronizedThreads {

    private static final Object monitor = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    System.out.println("Поток1");
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    System.out.println("Поток2");
                    monitor.notify();
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}