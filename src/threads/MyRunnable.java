package threads;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Main.semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread mainThread = Thread.currentThread();
        System.out.println("name " + mainThread.getName());
        System.out.println("id " + mainThread.getId());
        if (mainThread.getId() == Main.ID) {
            System.out.println("главный");
        } else {
            System.out.println("не главный");
        }
        System.out.println("--------------------------");
        Main.semaphore.release();
    }
}
