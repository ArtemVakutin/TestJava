package threads;

public class Main1Increment {
    static class Inc {
        private int inc = 0; //volatile проблему не решает

        void inc() { //нужен synchronized
            inc++;
        }
    }

    static class Sequence extends Thread {
        private Inc seq;

        public Sequence(Inc seq) {
            this.seq = seq;
        }
        public void run(){
            for (int i = 0; i < 100_000; i++) {
                seq.inc();
            }

        }
    }
        public static void main(String[] args) throws InterruptedException {
            Inc inc = new Inc();
            Thread thread = new Sequence(inc);
            Thread thread1 = new Sequence(inc);
            thread.start();
            thread1.start();
            thread.join();
            thread1.join();
            System.out.println(" vsego " + inc.inc);

        }


}
