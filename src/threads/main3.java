package threads;

import P2.SomeClass;

public class main3 {

    public static volatile boolean i = true;
    static class CheckNew {
        void run(){
            System.out.println("Ран бэби");
        }
    }
    static class CheckBoolean2 extends Thread {

        @Override
        public void run() {
            while (i) {
                System.out.println("CheckBoolean2 is running");
            }
            System.out.println("CheckBoolean2 end");
        }
        }
    static class TurnOffi2 extends Thread {

        @Override
        public void run() {
            i= false;

        }
    }



    static class CheckBoolean implements Runnable {
        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public void run() {
            while (i) {
                System.out.println("CheckBoolean is running");
            }
            System.out.println("CheckBoolean end");
        }


    }
    static class TurnOffi implements Runnable {

        @Override
        public void run() {
            i= false;

        }
    }


    public static void main(String[] args) {
//        new Thread(new CheckBoolean()).start();
//        new Thread(new TurnOffi()).start();

        new CheckBoolean2().start();
        new TurnOffi2().start();
    }
}
