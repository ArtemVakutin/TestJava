package Exceptions;

public class Test {

    Main main;
    void exc1() {
        exc2();
        System.out.println("Test exc2");
    }

    void exc2(){


            main.makeException();




    }

    int test1() {
return -1;
    }

    boolean test2(){
        return false;
    }
}
