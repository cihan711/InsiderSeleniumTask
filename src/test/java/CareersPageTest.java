import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import utils.TestBase;

import java.net.MalformedURLException;

public class CareersPageTest extends TestBase {

    CareersPage cp;
    HomePage hm;


    public CareersPageTest(){
        super();
    }

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {

        initialization();
        hm = new HomePage();
        cp = hm.goCareersPage();

    }

    //Locations,Teams,Life at Insider bölümlerin kontrolleri
    @Test
    public void CareersPageControl() throws InterruptedException {

        cp.teamsControl();
        cp.locationsControl();
        cp.lifeAtInsiderControl();
    }

    @AfterMethod
    public void quitBrowser()   {
        driver.quit();
    }
}
