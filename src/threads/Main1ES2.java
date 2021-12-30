package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main1ES2 {
    private static final Runnable RUNNABLE = () -> {
        System.out.println(Thread.currentThread().getName() + " Start Thread");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Thread finished");
    };


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(); //Создает пул потоков
        for (int i = 0; i < 100; i++) {
            executorService.submit(RUNNABLE); //Создали 100 потоков, а потом грохнули
        }
        executorService.shutdown();
    }
}
