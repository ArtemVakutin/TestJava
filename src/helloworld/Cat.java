package helloworld;

public class Cat extends Animal {
    int b;

    Cat() {
        super();
    }

    void setAnimal(){
        System.out.println("Cat setAnimal");
        System.out.println(b);
        System.out.println(super.b);
    }


}
