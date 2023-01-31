package test;

import org.example.mainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class DemoTest extends mainPage {
    public DemoTest() {

    }

    @Before
    public void setUp() {
        SetUp();
    }

    @Test
    public void demoTest(){

        login()
                .clickThreeDots()
                .navigateToBrandFinance()
                .NavigateToBrandFinanceSettings()
                .navigateToBrandDocumentSettings();

        Assertions.assertTrue(true);



    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
