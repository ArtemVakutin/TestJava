package helloworld;

public class Main2 {
private int i1;
    private int i = 1;
    void Start(){

        final int[] i1 = {1};
        new Interfacable(){

            @Override
            public void start() {
                i = 2;
                i1[0] =2;
            }
        };

    }

    public static void main(String[] args) {

    }


}
