package com.lugo.tests.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import tests.PqManagerCodingQuestionTests;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@RestController
public class TestsController {

    @PostMapping("/RunTests")
    public String runTests(HttpServletRequest request, HttpServletResponse response, @RequestParam String test){

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{PqManagerCodingQuestionTests.class});
        testng.addListener(tla);
        testng.run();

        
        String data = "failed: " + tla.getFailedTests().toString() + "<br><br>";
        data += "passed: "+ tla.getPassedTests().toString()+ "<br><br>";
        data += "details on: C:\\Users\\user\\Desktop\\codershub\\lugo_test_pages\\test-output\\index.html";

        return data;
    }

}
