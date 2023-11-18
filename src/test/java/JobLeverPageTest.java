import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JobLeverPage;
import pages.QAHomePage;
import pages.QaOpenPositionPage;
import utils.PageHelper;
import utils.TestBase;

import java.time.Duration;

public class JobLeverPageTest extends TestBase {

    QAHomePage qh;
    JobLeverPage jp;
    QaOpenPositionPage qp;


    public JobLeverPageTest(){
        super();
    }



    @BeforeMethod
    public void launchBrowser() throws InterruptedException {

        initialization();
        driver.get("https://useinsider.com/careers/quality-assurance/");
        qh = new QAHomePage();
        qp = qh.goQaOpenPositionPage();
        jp = qp.goJobLeverPage();

    }

    //jobs.lever sayfasına gidildiğinin kontrolleri
    @Test
    public void jobLeverPageControl() throws InterruptedException {

        Assert.assertTrue(driver.getCurrentUrl().contains("jobs.lever.co"));
        jp.jobLeverPageControl();


    }


    @AfterMethod
    public void quitBrowser()   {
        driver.quit();
    }

}
