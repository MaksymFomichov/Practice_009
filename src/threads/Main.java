package threads;

import java.util.concurrent.Semaphore;

public class Main {
    final static long ID = Thread.currentThread().getId();
    public static Semaphore semaphore = new Semaphore(1);
    private static MyRunnable myRunnable = new MyRunnable();

    public static void main(String[] args) {
//        System.out.println("ЗАДАНИЕ 1");
//        myRunnable.run();
//        for (int i = 0; i < 5; i++) {
//            runThread();
//        }

        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("ЗАДАНИЕ 2");

        Task_2.load("files/10 000 000 Numbers.txt");


    }

    private static void runThread() {
        new Thread(myRunnable).start();
    }


}
