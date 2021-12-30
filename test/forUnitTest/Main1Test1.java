package forUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Main1Test1 {
    Main1 main1;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = Exception.class)
    public void getCats() {
        main1 = null;
        main1.getCats();
    }

    @Test
    public void killCat() {
    }
}