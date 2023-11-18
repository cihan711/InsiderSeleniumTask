package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageHelper extends TestBase {

    public static long IMPLICIT_WAIT = 10;
    public static long EXPLICIT_WAIT = 10;


    public static void explicitWait(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void elementClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }




public  static  void scroll(WebElement element){

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
}

}
