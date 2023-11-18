package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("./src/test/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--ignore-certifcate-errors");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--disable-cookies");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browserName.equals("FF")){

            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PageHelper.IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));

        //İlk açılışta cookies engellemek için try-cath kullanıldı
        try {
            driver.findElement(By.xpath("//*[@id='wt-cli-accept-btn']")).click();

        } catch (Exception e) {
            System.out.println("No cookie acceptance button found.");
        }

        //İlk açılışta popup engellemek için try-cath kullanıldı
        try {
            driver.findElement(By.xpath("//*[@class='ins-close-button']")).click();

        } catch (Exception e) {

        }



    }



}