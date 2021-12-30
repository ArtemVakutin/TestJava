package generics.six;

public class Main2 {
    int count = 1;
    public Integer next() {
        return fib(count++);

    }

    private Integer fib(int i) {
        if(i<2) {
            return 1;
        }

        return fib(i-2)+ fib(i-1);
    }


    public static void main(String[] args) {
        Main2 gen = new Main2();
        for(int i = 0; i < 18; i++) {
            System.out.print(gen.next()+" ");
        }

    }



}
