package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        driver = new ChromeDriver();
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
    }

    @Test
    public void badTest(){
        Assert.assertEquals(1,2);
    }


    @AfterTest
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
