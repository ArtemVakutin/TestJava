package helloworld;

public class BlackCat extends Cat{

    BlackCat(){
        System.out.println("BlackCat");
    }

    void sleep() {
        System.out.println("sLEEP");

    }

    public static void main(String[] args) {
        BlackCat blackCat = new BlackCat();
    }
}
