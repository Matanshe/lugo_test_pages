package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PqManagerCodingQuestions {

    //Page URL
    private static final String companyKey = "aglub19hcHBfaWRyFAsSB0NvbXBhbnkYgICAgICAw";
    private static final String PAGE_URL = "http://localhost:8080/pqmanager.htm?orgId=" + companyKey + "&orgName=testCompany";
    WebDriver driver;
    //Locators
    By codingQuestion = By.id("addCodingQuestion");
    By manageTopics = By.id("createNewCodingTopic");
    By newTopicName = By.id("newTopicName");
    By saveNewTopic = By.id("addTopicAction");
    By topicToEdit = By.id("privateTopicsEdit");
    By topicEditNewName = By.id("newEditedTopicName");
    By saveEditedTopic = By.id("editTopicAction");
    By topicToDelete = By.id("privateTopicsDelete");
    By deleteTopic = By.id("deleteTopicAction");
    By selectDifficulty = By.id("difficultyCoding");
    By selectProgramingLang = By.id("multi-select");
    By functionName = By.id("questionFunctionName");
    By returnType = By.id("selectReturnType");
    By body = By.xpath("//*[@id=\"codingBody-container\"]/div[1]");
    By varName = By.id("addVarName");
    By varType = By.id("addVarType");
    By addVar = By.id("addVar");
    By testCaseVar1 = By.id("testCaseVar1");
    By testCaseVar2 = By.id("testCaseVar2");
    By testCaseVar3 = By.id("testCaseVar3");
    By testCaseVar4 = By.id("testCaseVar4");
    By testCaseVar5 = By.id("testCaseVar5");
    By testCaseRes = By.id("testCaseRes");
    By addTestCase = By.id("addTestCase");
    By testCaseInput = By.id("newArray"); // if the var is an array it will open a modal. this is the modal input
    By addTestCaseInput = By.id("addArrayAction");
    By advancedMode = By.id("advancedModeBtn");
    By editCandidateSource = By.id("addCandidateSource");
    By addTestCaseChecker = By.id("advancedAddTestCase");
    By saveCandidateSource = By.id("saveCandidateSource");
    By saveTestCaseChecker = By.id("saveTestCaseChecker");
    By candidateSourceEditor = By.id("candidateSourceEditor");
    By testCaseCheckerEditor = By.id("testCaseCheckerEditor");
    By normalMode = By.id("normalModeBtn");



    //Constructor
    public PqManagerCodingQuestions(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Selenium/Drivers/chromedriver2.exe");
        WebDriver driver = new ChromeDriver();
        PqManagerCodingQuestions pqManagerCodingQuestions = new PqManagerCodingQuestions(driver);
        driver.manage().window().maximize();


        pqManagerCodingQuestions.openCodingQuestionsModal();
        pqManagerCodingQuestions.questionBody("aaa");
    }

    void waitForModal(By by) {
        WebElement firstResult = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void changeToNormalMode(){
        driver.findElement(normalMode).click();
    }

    public void changeToAdvancedMode(){
        driver.findElement(advancedMode).click();
    }

    public void editCandidateSource(String text){
        driver.findElement(editCandidateSource).click();
        waitForModal(candidateSourceEditor);
        driver.findElement(candidateSourceEditor).sendKeys(text);
        driver.findElement(saveCandidateSource);
    }

    public void addTestCaseChecker(String text){
        driver.findElement(addTestCaseChecker).click();
        waitForModal(testCaseCheckerEditor);
        driver.findElement(testCaseCheckerEditor).sendKeys(text);
        driver.findElement(saveTestCaseChecker);
    }

    public void addTestCase(List<?> args) {
        int size = args.size(); // the size is the number of vars + the res
        driver.findElement(testCaseVar1).click();
        if (driver.findElement(testCaseInput).isDisplayed()) {
            driver.findElement(testCaseInput).sendKeys(args.get(0).toString());
            driver.findElement(addTestCaseInput).click();
        } else driver.findElement(testCaseVar1).sendKeys(args.get(0).toString());
        if (size > 2) {
            driver.findElement(testCaseVar2).click();
            if (driver.findElement(testCaseInput).isDisplayed()) {
                driver.findElement(testCaseInput).sendKeys(args.get(1).toString());
                driver.findElement(addTestCaseInput).click();
            } else driver.findElement(testCaseVar1).sendKeys(args.get(1).toString());
            if (size > 3) {
                driver.findElement(testCaseVar3).click();
                if (driver.findElement(testCaseInput).isDisplayed()) {
                    driver.findElement(testCaseInput).sendKeys(args.get(2).toString());
                    driver.findElement(addTestCaseInput).click();
                } else driver.findElement(testCaseVar1).sendKeys(args.get(2).toString());
                if (size > 4){
                    driver.findElement(testCaseVar4).click();
                    if (driver.findElement(testCaseInput).isDisplayed()) {
                        driver.findElement(testCaseInput).sendKeys(args.get(3).toString());
                        driver.findElement(addTestCaseInput).click();
                    } else driver.findElement(testCaseVar1).sendKeys(args.get(3).toString());
                    if (size > 5){
                        driver.findElement(testCaseVar5).click();
                        if (driver.findElement(testCaseInput).isDisplayed()) {
                            driver.findElement(testCaseInput).sendKeys(args.get(4).toString());
                            driver.findElement(addTestCaseInput).click();
                        } else driver.findElement(testCaseVar1).sendKeys(args.get(4).toString());
                    }
                }
            }
        }
        driver.findElement(testCaseRes).click();
        if (driver.findElement(testCaseInput).isDisplayed()) {
            driver.findElement(testCaseInput).sendKeys(args.get(size).toString());
            driver.findElement(addTestCaseInput).click();
        } else driver.findElement(testCaseVar1).sendKeys(args.get(size).toString());
        driver.findElement(addTestCase).click();

    }

    public void addVar(String name, String type) {
        driver.findElement(varName).sendKeys(name);
        new Select(driver.findElement(varType)).selectByVisibleText(type);
        driver.findElement(addVar).click();
    }

    public void questionBody(String text) {
        waitForModal(body);
        driver.findElement(body).click();
        driver.findElement(body).sendKeys(text);
    }

    public String getQuestionBody(){
        driver.findElement(body).click();
        return driver.findElement(body).getText();
    }

    public void selectReturnType(String type) {
        new Select(driver.findElement(returnType)).selectByVisibleText(type);
    }

    public void functionName(String name) {
        driver.findElement(functionName).sendKeys(name);
    }

    public void selectLang(String lang) {
        new Select(driver.findElement(selectProgramingLang)).selectByVisibleText(lang);
    }

    public void selectDifficulty(int index) {
        new Select(driver.findElement(selectDifficulty)).selectByIndex(index);
    }

    public void openCodingQuestionsModal() {
        driver.findElement(codingQuestion).click();
    }

    void addNewTopic(String topicName) {
        driver.findElement(manageTopics).click();
        driver.findElement(newTopicName).sendKeys(topicName);
        driver.findElement(saveNewTopic).click();
    }

    void editTopic(String oldTopic, String newTopic) {
        driver.findElement(manageTopics);
        new Select(driver.findElement(topicToEdit)).selectByVisibleText(oldTopic);
        driver.findElement(topicEditNewName).sendKeys(newTopic);
        driver.findElement(saveEditedTopic);
    }

    void deleteTopic(String topicName) {
        driver.findElement(manageTopics);
        new Select(driver.findElement(topicToDelete)).selectByVisibleText(topicName);
        driver.findElement(deleteTopic).click();
    }
}
