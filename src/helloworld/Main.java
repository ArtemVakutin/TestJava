package helloworld;

public class Main {


    private int priv = 1;

    public int getPriv() {
        return priv;
    }

    void setPriv(int priv) {
        this.priv = priv;
    }

    public void setPrivate (Main m) {
        m.priv = 2;
        System.out.println("priv " + m.priv);
    }


    public static void main(String[] args) {
        Main main1 = new Main();
        Main main2 = new Main();
        main2.setPrivate(main1);
        System.out.println(main1.getPriv());
    }


}
