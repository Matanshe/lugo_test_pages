package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PqManager {

    //Page URL
    private static final String companyKey = "aglub19hcHBfaWRyFAsSB0NvbXBhbnkYgICAgICAw";
    private static final String PAGE_URL = "http://localhost:8080/pqmanager.htm?orgId=" + companyKey + "&orgName=testCompany";
    WebDriver driver;

    //Locators
    By privateTopics = By.id("privateTopics");
    By questionsTable = By.id("questionsTable");
    By questionBody = By.id("questionContent");
    By aceAnswersHolder = By.xpath("//*[@id=\"editor\"]/div[2]/div");
    By closeQuestionsModal = By.id("topicManagementCloseBTN");
    By removeQuestion = By.id("removeQuestion");
    By editQuestion = By.id("editQuestion");
    By previousQuestion = By.id("previous");
    By nextQuestion = By.id("next");

    public PqManager(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public PqManager() {
    }

    public void selectTopic(String topic){
        Select select = new Select(driver.findElement(privateTopics));
        select.selectByVisibleText(topic);
        driver.findElement(privateTopics).click();
    }

    public void clickQuestion(int qNumber){
        String xpath = "//*[@id=\"questionsTable\"]/tr";
        if (qNumber != 0)
            xpath = xpath+"["+qNumber+"]";
        WebElement question = driver.findElement(By.xpath(xpath));
        question.click();
    }


}
