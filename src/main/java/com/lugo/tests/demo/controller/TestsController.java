package com.lugo.tests.demo.controller;

import com.lugo.tests.demo.entities.TestsList;
import com.lugo.tests.demo.entities.TestRes;
import org.springframework.web.bind.annotation.*;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import tests.PqManagerCodingQuestionCSharpTests;
import tests.PqManagerCodingQuestionJavaTests;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestsController {

    @PostMapping("/RunTests")
    public List<TestRes> runTests(HttpServletRequest request, HttpServletResponse response, @RequestBody String testId){

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        /*
        *  IMPORTANT - YOU NEED TO ADD A CASE HERE FOR EACH TEST THAT YOU HAVE
        * */
        switch (testId) {
            case "1":
                testng.setTestClasses(new Class[]{PqManagerCodingQuestionJavaTests.class});
                break;
            case "2":
                testng.setTestClasses(new Class[]{PqManagerCodingQuestionCSharpTests.class});
                break;
        }

        testng.addListener(tla);
        testng.run();


        // makes a list of all the tests and their results
        List<TestRes> data = new ArrayList<>();
        List<ITestResult> passedTests = tla.getPassedTests();
        for (ITestResult result: passedTests) {
            TestRes testRes = new TestRes();
            testRes.setName(result.getName());
            testRes.setStatus("passed");
            testRes.setMethod(result.getMethod().toString());
            testRes.setLog(getLog(result.toString()));
            data.add(testRes);
        }
        List<ITestResult> failedTests = tla.getFailedTests();
        for (ITestResult result: failedTests) {
            TestRes testRes = new TestRes();
            testRes.setName(result.getName());
            testRes.setStatus("failed");
            testRes.setMethod(result.getMethod().toString());
            testRes.setLog(getLog(result.toString()));

            data.add(testRes);
        }

        System.out.print(tla.getFailedTests().toString());


        return data;
    }

    @GetMapping("/NumOfTests")
    public int getNumOfTests(){

        TestsList list = new TestsList();
        /*
        * IMPORTANT THIS IS JUST A MOCK, YOU SHOULD CONNECT TO A DB THAT WILL SAVE ALL THE TESTS
        *  */
        list.setNumOfTests(2); // this is just a mock

        return list.getNumOfTests();
    }

    public String getLog(String str){
        int startIndex = str.indexOf("output=")+7;
        str = str.substring(startIndex,str.length()-1);
        return str;
    }

}
