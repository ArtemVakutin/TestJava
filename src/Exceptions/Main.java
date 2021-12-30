package Exceptions;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println(makeException());

    }
    static int makeException(){
        int i = 4;

        if (i==3) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                return i;
            }
        }

        return -i;


    }
}
