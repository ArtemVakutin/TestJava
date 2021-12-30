package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main1 {
    static int log1 = 1;
    static String log2 = "Log";
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
        Logger logger = LoggerFactory.getLogger(Main1.class);
        logger.info("Int log1 = {}, String log2 = {}", log1, log2);
        logger.error("test");
        Main1 main1 = new Main1(10,3,3);
        logger.info("Cats left = {}", main1.getCats());
        logger.warn("Кошки сдохли");

    }
}
