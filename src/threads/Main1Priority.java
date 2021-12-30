package threads;

public class Main1Priority {
    static final Object KEY =new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                synchronized (KEY) {
                    try {
                        KEY.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(toString()+"   " +i);
                    }
                synchronized (KEY){
                    KEY.notifyAll();
                }
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        System.out.println("Threads.start");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread1.start();
        thread2.start();


        System.out.println("Thread running");
        Thread.sleep(1000);
        synchronized (KEY){
            KEY.notify();
        }
        System.out.println("Thread notified");
    }
}
