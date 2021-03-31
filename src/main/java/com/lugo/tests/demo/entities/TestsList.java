package com.lugo.tests.demo.entities;

import java.util.List;

public class TestsList {

    int numOfTests;
    List<Test> testsList;

    public TestsList() {
    }

    public int getNumOfTests() {
        return numOfTests;
    }

    public void setNumOfTests(int numOfTests) {
        this.numOfTests = numOfTests;
    }

    public List<Test> getTestsList() {
        return testsList;
    }

    public void setTestsList(List<Test> testsList) {
        this.testsList = testsList;
    }
}
