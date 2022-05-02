package ru.kpfu.itis.ex4varaccess;

public class App {
    public static class Structure {
        //direct access
        public int counter = 0;
        // also try
        //public volatile int counter = 0;

        //or use sync method
        public synchronized void inc() {
            counter = counter + 1;
        }

        //or use bad not sync method
        public void incBad() {
            counter = counter + 1;
        }

        //or use not sync method but with synchronized block
        public void incOk() {
            synchronized (this) {
                counter = counter + 1;
            }
        }
    }

    public static class IncrementRunnable implements Runnable {
        private Structure structure;
        private boolean calculated = false;

        public IncrementRunnable(Structure structure) {
            this.structure = structure;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                structure.counter = structure.counter + 1;
            }
            calculated = true;
        }
    }

    public static class CleverIncrementRunnable implements Runnable {
        private Structure structure;
        private boolean calculated = false;

        public CleverIncrementRunnable(Structure structure) {
            this.structure = structure;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                structure.incOk();
            }
            calculated = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Structure structure1 = new Structure();

        IncrementRunnable ir1 = new IncrementRunnable(structure1);
        IncrementRunnable ir2 = new IncrementRunnable(structure1);
        Thread t1 = new Thread(ir1);
        Thread t2 = new Thread(ir2);

        t1.start();
        t2.start();
        while (!ir1.calculated && !ir2.calculated) {
            Thread.sleep(100);//Not the best approach to sync!
        }
        System.out.println(structure1.counter);

        Structure structure2 = new Structure();

        CleverIncrementRunnable ir3 = new CleverIncrementRunnable(structure2);
        CleverIncrementRunnable ir4 = new CleverIncrementRunnable(structure2);
        Thread t3 = new Thread(ir3);
        Thread t4 = new Thread(ir4);

        t3.start();
        t4.start();
        while (!ir3.calculated && !ir4.calculated) {
            Thread.sleep(100);//Not the best approach to sync!
        }
        System.out.println(structure2.counter);
    }
}
