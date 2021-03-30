package com.lugo.tests.demo;

import tests.Tests;

import java.util.List;

public class TestList {

    int numOfTests;
    List<Tests> testsList;

    public TestList() {
    }

    public int getNumOfTests() {
        return numOfTests;
    }

    public void setNumOfTests(int numOfTests) {
        this.numOfTests = numOfTests;
    }

    public List<Tests> getTestsList() {
        return testsList;
    }

    public void setTestsList(List<Tests> testsList) {
        this.testsList = testsList;
    }
}
