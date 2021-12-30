package threads;

public class Main {

    static class SecondThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                System.out.println("ThreadSecond");
            }




        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new SecondThread());
        thread.start();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("ThreadMain");
        }

        new Thread(new SecondThread()).start();
       
    }
}
