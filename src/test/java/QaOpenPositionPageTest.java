import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.QAHomePage;
import pages.QaOpenPositionPage;
import utils.PageHelper;
import utils.TestBase;

import java.net.MalformedURLException;
import java.time.Duration;

public class QaOpenPositionPageTest extends TestBase {

    QAHomePage qh;
    QaOpenPositionPage qp;

    public QaOpenPositionPageTest(){
        super();
    }


    @BeforeMethod
    public void launchBrowser() {

        initialization();
        driver.get("https://useinsider.com/careers/quality-assurance/");
        qh = new QAHomePage();
        qp = qh.goQaOpenPositionPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PageHelper.IMPLICIT_WAIT));

    }

    @Test(priority = 1)
    public void QaOpenPositionPageControl(){

        Assert.assertEquals(driver.getTitle(),"Insider Open Positions | Insider");

    }

    //lokasyon ve Departman secimi kontrolleri,  pozisyon listesinin kontrolleri ve pozisyon listelerinde iş kurallarında verilen kelimelerin kontrolleri
    @Test(priority = 2)
    public void QaOpenPositionPageFilter() throws InterruptedException {

        qp.getSelectDepartment();
        qp.getSelectLocation();
        qp.jobListControl();
        qp.checkJobListKeywords();
    }



    @AfterMethod
    public void quitBrowser()   {
        driver.quit();
    }
}
