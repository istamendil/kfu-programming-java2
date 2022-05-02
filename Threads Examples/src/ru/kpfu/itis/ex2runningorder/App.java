package ru.kpfu.itis.ex2runningorder;

import ru.kpfu.itis.utils.PrintRunnable;

public class App {

    public static void main(String[] args) {
        PrintRunnable pr1 = new PrintRunnable(10);
        PrintRunnable pr2 = new PrintRunnable(10);

        Thread t1 = new Thread(pr1);
        Thread t2 = new Thread(pr2);

        t1.start();
        t2.start();

        /*
        Results will not be homogeneous:
            Hello world from Thread-0
            Hello world from Thread-0
            Hello world from Thread-1
            Hello world from Thread-0
            Hello world from Thread-1
            Hello world from Thread-0
            Hello world from Thread-1
            Hello world from Thread-1
         System can't treat threads equally. Programmer can't predict order of calling threads' instructions.
         */
    }
}
