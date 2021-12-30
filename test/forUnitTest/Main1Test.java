package forUnitTest;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Main1Test {
    Main1 main1;

    @BeforeEach
    void setUp() {
        main1 = new Main1(10, 4, 3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCats() {
        main1 = new Main1(10, 4, 3);
        assertEquals(10, main1.getCats());
        main1 = new Main1(9, 4, 3);
        assertEquals(9, main1.getCats());
        main1 = new Main1(8, 4, 3);
        assertEquals(9, main1.getCats());

    }

    @Test
    void killCat() {

    }

    @Test
    void feedCat() {
    }
}