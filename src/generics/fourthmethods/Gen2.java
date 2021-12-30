package generics.fourthmethods;

import generics.first.Sleepable;

public class Gen2 {


    public Gen2() {

    }
    static <T extends Animal & Sleepable> void killAnimal(T object) {
        System.out.println(object);
    }



    public static void main(String[] args) {

        killAnimal(new Cat());
    }

}
