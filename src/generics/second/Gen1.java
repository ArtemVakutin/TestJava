package generics.second;

import P2.InternalClass;
import generics.first.Sleepable;

import javax.sound.midi.Soundbank;

public class Gen1<T extends Number> {
    T tobject;

    public Gen1(T tobject) {
        this.tobject = tobject;
    }





    public static void main(String[] args) {
        Gen1<Integer> gen1 = new Gen1<Integer>(8);
        Gen1<Double> gen2 = new Gen1<Double>(29.0);
//        gen1.compare(gen2);
        gen1.test();
    }


    public void compare (Gen1 o) {
        System.out.println((tobject.doubleValue() - o.tobject.doubleValue()));
        int i = 1;
           if ((Integer)i instanceof Integer) {
               System.out.println("i true");
           }

        }

        public void test(){
        Animal cat = new Cat();

        if(cat instanceof Cat) {
            System.out.println("cat true");
            }
        Animal animal = cat;
            System.out.println((Animal)cat instanceof Cat);

    }
}
