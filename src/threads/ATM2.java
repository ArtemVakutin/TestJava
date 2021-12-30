package threads;

public class ATM2 {
    static int money = 200;
    static Object obj = new Object();
//synchronized - может выполняться в одно время только одним методом
        static void getMoney(int amount) {

                synchronized (obj) {
                    if (amount <= money) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        money -= amount;

                        System.out.println("new money amount " + money);
                    } else {
                        System.out.println("not enough money");
                    }
                }
            System.out.println("Done");
        }

        public static void main(String[] args) throws InterruptedException {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("Bob: ");
                    getMoney(100);

                }
            }).start();
            Thread.sleep(100);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("Alice: ");
                    getMoney(100);

                }
            }).start();
            Thread.sleep(100);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("John: ");
                    getMoney(100);

                }
            }).start();
            Thread.sleep(100);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("Jakob: ");
                    getMoney(100);

                }
            }).start();
            Thread.sleep(100);
        }

  }
