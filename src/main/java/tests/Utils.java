package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*IF CAN ADD HERE MORE DRIVERS FOR DIFFERENT BROWSERS */

public class Utils {

    public WebDriver chromeDriverSetUp(){
        /* PUT THE CORRECT CHROME DRIVER PATH HERE */
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/Drivers/chromedriver2.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        return driver;
    }

}
