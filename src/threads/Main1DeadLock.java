package threads;

public class Main1DeadLock {
    final static Object KEY1 = new Object();
    final static Object KEY2 = new Object();
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (KEY1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (KEY2) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                synchronized (KEY2) { //ключи надо брать в том же порядке, что и в первом Runnable, иначе зависнет
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (KEY1) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable2).start();




    }
}
