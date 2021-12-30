package forUnitTest;

public class Main1 {
    int cats;
    int food;
    int birds;

    public Main1(int cats, int food, int birds) {
        this.cats = cats;
        this.food = food;
        this.birds = birds;
    }

    public int getCats() {
        return cats;
    }

    public void setCats(int cats) {
        this.cats = cats;
    }

    public void killCat(int killedCat) {
        cats -= killedCat;
    }

    public int feedCat() {
        return cats - food - birds;
    }

    public static void main(String[] args) {
        Main1 main1 = new Main1(10, 4, 3);
        System.out.println("Cats feeded " + main1.feedCat());
        main1.killCat(1);
        System.out.println("Cat alive " + main1.getCats());
    }
}
