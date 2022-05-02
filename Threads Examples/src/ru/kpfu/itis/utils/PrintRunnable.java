package ru.kpfu.itis.utils;

public class PrintRunnable implements Runnable{

    private final int sleepPeriod;

    public PrintRunnable(int sleepPeriod) {
        this.sleepPeriod = sleepPeriod;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Hello world from " + Thread.currentThread().getName());
            try {
                // Just wait for some time so PC won't be overloaded.
                Thread.sleep(sleepPeriod);
            } catch (InterruptedException e) {
                System.err.println("Thread has been interrupted.");
            }
        }
    }
}
