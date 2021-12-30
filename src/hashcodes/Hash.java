package hashcodes;

public class Hash {
    private int a;
    private int b;

    public Hash(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Hash hash1 = new Hash(1,1);
        Hash hash11= hash1;
        Hash hash2 = new Hash(2,1);
        Hash hash3 = new Hash(1,1);
        System.out.println(hash1.hashCode());
        System.out.println(hash3.hashCode());
        System.out.println(hash11.hashCode());
        System.out.println(hash2.hashCode());

    }
}
