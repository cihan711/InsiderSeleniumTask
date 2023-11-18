package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageHelper;
import utils.TestBase;

import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static utils.PageHelper.EXPLICIT_WAIT;

public class QaOpenPositionPage extends TestBase {

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    WebElement selectLocation;

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    WebElement selectDepartment;

    @FindBy(xpath = "//li[contains(@data-select2-id,'Istanbul')]")
    WebElement locationIstanbul;

    @FindBy(xpath = "//li[contains(@data-select2-id,'Quality Assurance')]")
    WebElement qualityAssuranceDepartment;

    @FindBy(xpath = "//div[contains(@class,'position-list-item-wrapper')]")
    List<WebElement> jobsList;

    @FindBy(xpath = "//p[@class='position-title font-weight-bold']")
    List<WebElement> jobTitleList;

    @FindBy(xpath = "//*[contains(@class,'position-department text-large')]")
    List<WebElement> jobDepartmentList;

    @FindBy(xpath = "//*[contains(@class,'position-location')]")
    List<WebElement> jobLocationList;

    @FindBy(xpath = "(//p[@class='position-title font-weight-bold'])[1]")
    WebElement firstJobTitle;

    @FindBy(xpath = "(//*[contains(@class,'position-location')])[1]")
    WebElement firstJobLocation;
    @FindBy(xpath = "(//a[contains(@class,'btn-navy') and text()='View Role'])[1]")
    WebElement viewRole;


    public QaOpenPositionPage() {

        PageFactory.initElements(driver, this);

    }

    public void getSelectLocation()  {

        try {
            PageHelper.explicitWait(selectLocation);
            selectLocation.click();
            PageHelper.explicitWait(locationIstanbul);
            locationIstanbul.click();
        } catch (Exception e) {
            System.out.println("Lokasyon filtreleme duzgun calismiyor.");
        }


    }

    public void getSelectDepartment()  {

        try {
            PageHelper.explicitWait(selectDepartment);
            selectDepartment.click();
            PageHelper.explicitWait(qualityAssuranceDepartment);
            qualityAssuranceDepartment.click();
        } catch (Exception e) {
            System.out.println("Departman filtreleme duzgun calismiyor.");
        }


    }

    public void jobListControl() throws InterruptedException {

        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        PageHelper.explicitWait(jobsList.get(0));
        for (int i = 0; i < jobsList.size(); i++) {
           jobsList.get(i).isDisplayed();
        }
    }

    public void checkJobListKeywords(){

        PageHelper.explicitWait(jobTitleList.get(0));
        PageHelper.explicitWait(jobDepartmentList.get(0));
        PageHelper.explicitWait(jobLocationList.get(0));
        for (int i = 0; i < jobTitleList.size(); i++) {

            jobTitleList.get(i).getText().contains("Quality Assurance");

        }
        for (int i = 0; i < jobDepartmentList.size(); i++) {

            jobDepartmentList.get(i).getText().contains("Quality Assurance");

        }
        for (int i = 0; i < jobLocationList.size(); i++) {


            jobLocationList.get(i).getText().contains("Istanbul, Turkey");

        }
    }

    //Bu methodda View Role butonuna tıklayarak jobs lever sayfasına geçiş işlemi yapılır
    public JobLeverPage goJobLeverPage() throws InterruptedException {

        getSelectDepartment();
        getSelectLocation();
        jobListControl();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.body.style.zoom='67%'");
        Thread.sleep(3000);
        PageHelper.explicitWait(firstJobTitle);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("(//a[contains(@class,'btn-navy') and text()='View Role'])[1]"))));
      //  PageHelper.elementClickable(viewRole);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", viewRole);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();

        while (it.hasNext()) {

            String child_window = it.next();

            if (!parentId.equals(child_window)) {

                driver.switchTo().window(child_window);

            }
        }
        return new JobLeverPage();


    }

}
