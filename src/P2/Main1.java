package P2;

import helloworld.Animal;

import java.sql.SQLOutput;
import java.util.*;

public class Main1 {

    public static void main(String[] args) {


        List<Person> list= new ArrayList<>();
      list.add(new Person("One", 1));
        list.add(new Person("Two", 2));
        list.add(new Person("Three", 3));
        list.add(new Person("Four", 4));
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(list);


        List<Person> persons = new ArrayList<>(list);
        System.out.println(persons);
        for (Person person : persons) {
            person.name = person.name + "2";
        }
        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) {
            Person next =  iterator.next();
            System.out.println(next);
        }
        System.out.println(persons.size());
        for (int i = persons.size(); i > 0 ; i--) {
        persons.remove(i-1);
        }
        if (persons.size() == 0) {
            System.out.println("Коллекция пустая");
        }


        Iterator<Person> iterat = persons.iterator();
        while (iterat.hasNext()) {
            Person next =  iterat.next();
            iterat.remove();
        }
        System.out.println(persons);


    }




    private static void method(SomeClass animal) {
        int i = 1+1;
        animal.fly();

    }

}
