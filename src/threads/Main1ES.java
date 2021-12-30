package threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main1ES {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(); //Создает пул потоков
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Start Thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Thread finished");
            }
        });
        executorService.shutdown();
    }
}
