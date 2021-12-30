package threads;

public class Main2 {

    static class Cat extends Thread{
        @Override
        public void run() {
            System.out.println(getName());
            System.out.println("Thread Cat starts");

        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Анонимный Thread");
            }
        }).start();
    }
}
