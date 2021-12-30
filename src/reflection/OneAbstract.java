package reflection;

public abstract class OneAbstract extends Object implements Cloneable, Able{
    private int anInt=2;
    private static int anIntStatic=1;
    private String string = "DD";
    private String[] strings;
    private boolean aBoolean;
    public char aChar = 'C';

    public OneAbstract(int anInt, String string) {
        this.anInt = anInt;
        this.string = string;
    }

    public OneAbstract(int anInt) {
        this.anInt = anInt;
    }

    public int getTen(Integer i){
        return 10;
    }

    public abstract int absMet();

    public <T> T getT(T t){
        return t;
    }
    @Override
    public void start() {
        System.out.println("One.start()");
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }
    public static int getAnIntStatic() {
        return anIntStatic;
    }

    public static void setAnIntStatic(int anIntStatic) {
        OneAbstract.anIntStatic = anIntStatic;
    }



}
