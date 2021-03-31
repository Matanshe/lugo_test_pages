package com.lugo.tests.demo.entities;

public class TestRes {

    private String status;
    private String log;
    private String name;
    private String method;

    public TestRes(String status, String log, String name, String method) {
        this.status = status;
        this.log = log;
        this.name = name;
        this.method = method;
    }

    public TestRes() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


}
