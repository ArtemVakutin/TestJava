package threads;

public class Main1Interrupted {
    static final Object KEY =new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000000; i++) {
                    System.out.println(i);
                    if (Thread.currentThread().isInterrupted()){ //Если вылезет interrupted exeption во время исполнения блока try catch, то флаг сбросится
                        break; // Есть еще Thread.interrupted() - тож самое, только флаг сбрасывает в false
                    }
                    }

                System.out.println("Thread interrupted = "+ Thread.currentThread().isInterrupted());
            }
        });
        System.out.println("Thread.start");
        thread.start();
        System.out.println("Thread running");
        Thread.sleep(10);
        thread.interrupt();
        System.out.println("Finish");
    }
}
