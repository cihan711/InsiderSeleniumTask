package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageHelper;
import utils.TestBase;

public class CareersPage extends TestBase {

    @FindBy(xpath = "//a[normalize-space()='See all teams']")
    WebElement teams;

    @FindBy(id = "career-our-location")
    WebElement locations;

    @FindBy(xpath = "//section[@data-id='a8e7b90']")
    WebElement lifeAtInsider;

    public CareersPage() {

        PageFactory.initElements(driver, this);

    }


    public void teamsControl() throws InterruptedException {
        PageHelper.explicitWait(teams);
        PageHelper.scroll(teams);
        teams.isDisplayed();
        Thread.sleep(3000);

    }

    public void locationsControl() throws InterruptedException {
        PageHelper.explicitWait(locations);
        PageHelper.scroll(locations);
        locations.isDisplayed();
        Thread.sleep(3000);

    }

    public void lifeAtInsiderControl() throws InterruptedException {
        PageHelper.explicitWait(lifeAtInsider);
        PageHelper.scroll(lifeAtInsider);
        lifeAtInsider.isDisplayed();
        Thread.sleep(3000);

    }
}
