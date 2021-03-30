package tests;

import com.lugo.tests.demo.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webpages.PqManagerCodingQuestions;


public class PqManagerCodingQuestionJavaTests extends Tests {

    PqManagerCodingQuestions pqManagerCodingQuestions;
    WebDriver driver;
    int testId = 1;

    @BeforeTest
    public void setDriver() {
        Utils utils = new Utils();
        driver = utils.setUpDriver();
        pqManagerCodingQuestions = new PqManagerCodingQuestions(driver);

    }

    @Test
    public void javaInt() {
        pqManagerCodingQuestions.openCodingQuestionsModal();
        pqManagerCodingQuestions.questionBody("aaa");
        String test = "aaa";
        String test1 = pqManagerCodingQuestions.getQuestionBody();
        Assert.assertEquals(test, test1);
        Reporter.log("this is a good test re");

    }


    @AfterTest
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
