package threads;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;


public class Main1ES3 {
        static ArrayList<Future<String>> futures = new ArrayList<>();

        static Random random = new Random();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5); //Создает пул потоков максимум 5 шт, остальные будут созданы как только эти отработают
        for (int i = 0; i < 10; i++) {
                final int i1 = i;
                Future future = executorService.submit(new Callable<String>() {
                    @Override
                public String call() throws Exception {
                    Thread.sleep(random.nextInt(1000)+500);
                    return (Thread.currentThread().getName() +" " + i1);
                }
            }); //Создали 100 потоков, а потом грохнули
            futures.add(future);
        }
        for (Future<String> future1: futures) {
            Thread.sleep(100);
            System.err.println(future1.isDone()); //Future - возвращает выполнено ли
        }
        for (Future<String> future1: futures) {
            System.out.println(future1.get()); //Future - возвращает результат выполнения потока
        }
        executorService.shutdown();
    }
}
