package helloworld;

public class Singletone {
    private static Singletone singletone;

    Singletone(String s){
        System.out.println(s);
    }

    public static Singletone getSingletone(String s){
        if (singletone==null){
            return new Singletone(s);
        }
        return singletone;


        }
    class Double{

    }
        }





class Single{

}