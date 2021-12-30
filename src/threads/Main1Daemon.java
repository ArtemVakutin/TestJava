package threads;

import java.util.concurrent.TimeUnit;

public class Main1Daemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("ThreadDaemon Starts");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    System.out.println("ThreadDaemon Finally");
                }
                System.out.println("ThreadDaemonStop");
            }
        });
        thread.setDaemon(true); //Daemon closing then mainThread closing
        thread.start();


        System.out.println("MainThread Stop");

    }
}
