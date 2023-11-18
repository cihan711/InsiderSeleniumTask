package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageHelper;
import utils.TestBase;

public class QAHomePage extends TestBase {

    @FindBy(xpath = "//h1[normalize-space()='Quality Assurance']")
    WebElement title;

    @FindBy(xpath = "//a[contains(@class,'btn-outline-secondary')]")
    WebElement allQAJobs;

    public QAHomePage() {

        PageFactory.initElements(driver, this);

    }

    public void QAHomePageControl() {

        PageHelper.explicitWait(title);
        title.isDisplayed();

    }


    public QaOpenPositionPage goQaOpenPositionPage() {
        PageHelper.explicitWait(allQAJobs);
        allQAJobs.click();
        return new QaOpenPositionPage();

    }
}
