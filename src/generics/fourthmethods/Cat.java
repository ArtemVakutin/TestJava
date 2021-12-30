package generics.fourthmethods;

import generics.first.Sleepable;

public class Cat extends Animal implements Sleepable {
    @Override
    public void sleep() {
        System.out.println("Cat sleeping");
        Integer i = new Integer(8);
        System.out.println(i.doubleValue());
    }
}
