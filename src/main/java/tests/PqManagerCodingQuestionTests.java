package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webpages.PqManagerCodingQuestions;


public class PqManagerCodingQuestionTests {

    PqManagerCodingQuestions pqManagerCodingQuestions;
    WebDriver driver;

    @BeforeTest
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/Drivers/chromedriver2.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        pqManagerCodingQuestions = new PqManagerCodingQuestions(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void checkQuestionBody() {
        pqManagerCodingQuestions.openCodingQuestionsModal();
        pqManagerCodingQuestions.questionBody("aaa");
        String test = "aaa";
        String test1 = pqManagerCodingQuestions.getQuestionBody();
        Assert.assertEquals(test, test1);
        Reporter.log("this is a good test re");

    }

    @Test
    public void badTest(){
        Reporter.log("this is a bad test example");
        Assert.assertEquals(2,1);
    }


    @AfterTest
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
