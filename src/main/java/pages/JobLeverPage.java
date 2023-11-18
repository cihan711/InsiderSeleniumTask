package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageHelper;
import utils.TestBase;

public class JobLeverPage extends TestBase {

    @FindBy(xpath = "//div[@class='postings-btn-wrapper']")
    WebElement applyJob;

    public JobLeverPage() {

        PageFactory.initElements(driver, this);

    }

    public  void  jobLeverPageControl(){

        PageHelper.explicitWait(applyJob);
        applyJob.isDisplayed();
    }
}
