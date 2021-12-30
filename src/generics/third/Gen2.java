package generics.third;

public class Gen2 <T extends Animal> {
    T object;

    public Gen2(T object) {
        this.object = object;
    }

    public void compare(Gen2<?> second){
               if (second.object instanceof Cat) {
            System.out.println("cat");
        }
        else if(second.object instanceof Dog){
            System.out.println("dog");
        }
    }

    public static void main(String[] args) {
        Gen2<Cat> gen2 = new Gen2<Cat>(new Cat());
        Gen2<Dog> gen2Dog = new Gen2<Dog>(new Dog());

        gen2.compare(gen2Dog);
        System.out.println(gen2.object instanceof Cat);
        System.out.println(gen2.object instanceof Animal);

    }

}
