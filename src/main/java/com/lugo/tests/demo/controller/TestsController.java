package com.lugo.tests.demo.controller;

import com.lugo.tests.demo.TestList;
import com.lugo.tests.demo.TestRes;
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

        List<TestRes> data = new ArrayList<TestRes>();
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

        System.out.printf(tla.getFailedTests().toString());


        return data;
    }

    @GetMapping("/NumOfTests")
    public int getNumOfTests(){

        TestList list = new TestList();
        list.setNumOfTests(2); // this is just a mock

        return list.getNumOfTests();
    }

    public String getLog(String str){
        int startIndex = str.indexOf("output=")+7;
        str = str.substring(startIndex,str.length()-1);
        return str;
    }

}
