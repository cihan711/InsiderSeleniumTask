import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestBase;

import java.net.MalformedURLException;

public class HomePageTest extends TestBase {

    HomePage hm;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {

        initialization();
        hm = new HomePage();

    }

//Insider home page title ve baslık  kontrolu
    @Test
    public void homePageControl(){

        Assert.assertEquals(driver.getTitle(),"#1 Leader in Individualized, Cross-Channel CX — Insider");
        hm.homePageControl();

    }


    @AfterMethod
    public void quitBrowser()   {
        driver.quit();
    }
}



