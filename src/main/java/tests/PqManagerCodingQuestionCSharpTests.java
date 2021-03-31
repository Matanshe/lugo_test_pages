package tests;
/*
*
*
*
* THIS IS NOT A REAL TEST
* THIS TEST NEEDS TO BE IMPLEMENTED
*
*
*
*
*
*
*
*  */
import com.lugo.tests.demo.entities.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import webpages.PqManagerCodingQuestions;

public class PqManagerCodingQuestionCSharpTests extends Test {

    PqManagerCodingQuestions pqManagerCodingQuestions;
    WebDriver driver;
    int testId = 2;

    @BeforeTest
    public void setDriver() {
        Utils utils = new Utils();
        driver = utils.chromeDriverSetUp();
        pqManagerCodingQuestions = new PqManagerCodingQuestions(driver);

    }

    @org.testng.annotations.Test
    public void cSharpInt() {
        pqManagerCodingQuestions.openCodingQuestionsModal();
        pqManagerCodingQuestions.questionBody("aaa");
        String test = "aaa";
        String test1 = pqManagerCodingQuestions.getQuestionBody();
        Assert.assertEquals(test, test1);
        Reporter.log("this is not a real test a real test needs to be implemented");
    }

    @org.testng.annotations.Test
    public void badTest(){
        Reporter.log("failed test log");
        Assert.fail("this is example of a test that failed");
    }


    @AfterTest
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
