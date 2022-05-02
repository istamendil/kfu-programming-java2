package ru.kpfu.itis.ex1running;

import ru.kpfu.itis.utils.PrintRunnable;

public class App {
    public static void main(String[] args) {
        // Simple example
        PrintRunnable pr = new PrintRunnable(1000);
        Thread t1 = new Thread(pr);
        t1.start();

        // Approaches

        // Implement Runnable interface
        // Thread t1 = new Thread(new PrintRunnable());

        // Implement Runnable interface as anonymous class
        // Thread t1 = new Thread(new Runnable(){public void run(){...}});

        // Implement Runnable interface as anonymous class with lambda syntax
        // Thread t1 = new Thread(() -> {...});

        // Extend Thread (as class or anonymous). Single responsibility?!
        // Thread t1 = new Thread(){public void run(){...}}
    }
}
