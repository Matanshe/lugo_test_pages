package com.lugo.tests.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import webpages.PqManagerCodingQuestions;

public class Utils {

    public WebDriver setUpDriver(){
        /* PUT THE CORRECT CHROME DRIVER PATH HERE */
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/Drivers/chromedriver2.exe");

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        return driver;
    }

}
