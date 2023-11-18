package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageHelper;
import utils.TestBase;

import java.time.Duration;

public class HomePage extends TestBase {

    @FindBy(xpath = "//b[contains(text(),'Insider named a Leader in the 2023 Gartner® Magic ')]")
    WebElement homeControl;

    @FindBy(xpath = "//a[normalize-space()='Company']")
    WebElement company;

    @FindBy(xpath = "//a[normalize-space()='Careers']")
    WebElement careers;


    public HomePage() {

        PageFactory.initElements(driver, this);

    }


    public void homePageControl() {

        PageHelper.explicitWait(homeControl);
       homeControl.isDisplayed();

    }



    //Career sayfasına git
    public CareersPage goCareersPage() {

        company.click();
        PageHelper.explicitWait(careers);
        careers.click();
        return new CareersPage();

    }



}
