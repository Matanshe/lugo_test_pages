package tests;

import com.lugo.tests.demo.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webpages.PqManagerCodingQuestions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

        try {
            pqManagerCodingQuestions.openCodingQuestionsModal();
            pqManagerCodingQuestions.addNewTopic("javaInt"+ new Date().toString());
            pqManagerCodingQuestions.selectLang("Java");
            pqManagerCodingQuestions.functionName("foo");
            pqManagerCodingQuestions.questionBody("questionBody");
            pqManagerCodingQuestions.addVar("var1", "int");
            for (int i = 0; i < 3; i++) {
                List <Integer> testCaseList = new ArrayList<>();
                testCaseList.add(i);
                testCaseList.add(i);
                pqManagerCodingQuestions.addTestCase(testCaseList);
            }
            pqManagerCodingQuestions.addQuestion();

            pqManagerCodingQuestions.checkIfMainPage();
            Reporter.log("this question was added");
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log(e.getMessage());
            Assert.fail();
        }


    }


    @AfterTest
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
