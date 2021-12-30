package threads;

public class Main1Wait {
    static final Object KEY =new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    if (i==3) {

                        synchronized (KEY){
                            KEY.notifyAll();
                        }

                    }
                }
            }
        });
        System.out.println("Thread.start");
        thread.start();
        System.out.println("Thread running");
        synchronized (KEY){
            KEY.wait();
        }
        System.out.println("Thread notified");
    }
}
