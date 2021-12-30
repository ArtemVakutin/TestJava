package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Lambda {

    public static void main(String[] args) {


        List<Integer> aList = new ArrayList(Arrays.asList(1,8,9,10,11));

        System.out.println(aList + " =>" + filter(aList, integer -> (integer%2 == 0)));
        System.out.println(aList + " =>" + filter(aList, new Predicate<Integer>() {
            @Override
            public boolean filter(Integer integer) {
                return (integer%2 == 0);
            }
        }));

        System.out.println(aList + " =>" + reduce(aList, 0, new Reduce<Integer>() {
            @Override
            public Integer reduce(Integer integer, Integer summ) {
                return integer+summ;
            }
        }
        ));

        System.out.println(aList + " =>" + reduce(aList, 0, (integer, summ) -> {
       return integer + summ;})); //лямбда, если несколько выражений, то скобочки {}

        System.out.println(aList + " =>" + reduce(aList, 0, (integer, summ) -> integer + summ)); //если одно выражение, то можно без скобочек
    }



    private static <T> T reduce(List<T> aList, T m, Reduce<T> reduce) {

        for (T t : aList) {
            m = reduce.reduce(t, m);
        }
        return m;
    }

    private static <T> List<T> filter(List<T> alist2, Predicate<T> integerPredicate) {
        List<T> filt = new ArrayList<T>();
        for (T t : alist2) {
            if(integerPredicate.filter(t)) {
                filt.add(t);
            }
        }

        return filt;
    }
}
