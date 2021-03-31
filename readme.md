# **Lugo Test auto test app**

## **Install and Run**
First, make sure you have the latest chrome driver installed on your machine, and put the correct path to on the Utils class.

build the project using `mvn package`, and run it with `mvn spring-boot:run`.
the project will start and run  on port 8888 so that the lugo project could run on 8080.


## **Project Structure**
### **java/webpages**
in this package we have the classes with selenium methods to control the browser for each specific page (or part of a page for large complicated pages).
we have locators for each element on the page, and methods to click/input/getValue, basically using the page.

### **java/tests**
in this package we have classes that actually do the tests. each class has an testID but can actually have few tests related to the specific page.
we are using testNG for the tests, so we have the annotations: @BeforeTest, @Test, @AfterTest. we can have multiple @Tests, each will generate its own test and its own report.
In this package we also have the Utils class, currently with the chromeDriverSetUp method, if you want to support more browsers implement it there. 
**Important!** you must set the correct path for your chrome driver in the chromeDriverSetUp method.

## **Need To Be Done**
1. validate that the question that was added is as expected.
2. add all the pages
3. add tests for all the pages
4. update the client side for each test added
5. think about a way for automatically update all the project after adding a new test. maybe saving it to a db and then getting all the data from there on each run.

