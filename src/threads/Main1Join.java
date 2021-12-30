package threads;

public class Main1Join {

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

                }

            }
        });
        System.out.println("Thread.start");
        thread.start();
        Thread.sleep(120);
        System.out.println("Thread running");
        thread.join();
        System.out.println("Thread joined");
    }
}
