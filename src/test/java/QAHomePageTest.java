import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.QAHomePage;
import utils.PageHelper;
import utils.TestBase;

import java.net.MalformedURLException;
import java.time.Duration;

public class QAHomePageTest extends TestBase {

    QAHomePage qp;

    public QAHomePageTest(){
        super();
    }

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {

        initialization();
        driver.get("https://useinsider.com/careers/quality-assurance/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PageHelper.IMPLICIT_WAIT));
        qp = new QAHomePage();
    }

    @Test
    public void QAHomePageControl() throws InterruptedException {

      qp.QAHomePageControl();
    }


    @AfterMethod
    public void quitBrowser()   {
        driver.quit();
    }
}
