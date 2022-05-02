package ru.kpfu.itis.ex3threadstop;

public class App {

    public static class MomentumRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread that's not continued. Just print this and nothing to do more.");
        }
    }

    public static class InterruptableRunnable implements Runnable {
        private boolean running = true;

        public void stop() {
            running = false;
        }

        @Override
        public void run() {
            while(running){
                System.out.println("Continued thread is till running.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Thread " + Thread.currentThread().getName() + " has been interrupted.");
                }
            }
        }
    };

    public static void main(String[] args) {
        MomentumRunnable r1 = new MomentumRunnable();
        Thread t1 = new Thread(r1);
        t1.start();

        InterruptableRunnable r2 = new InterruptableRunnable();
        Thread t2 = new Thread(r2);
        // Thread started
        t2.start();
        //Lets w8 for some time, do our business
        //As business we will sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread " + Thread.currentThread().getName() + " has been interrupted.");
        }
        System.out.println(t2.getState());
        //and stop t2
        r2.stop();

        //Let's check statuses out after some time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Thread " + Thread.currentThread().getName() + " has been interrupted.");
        }
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
