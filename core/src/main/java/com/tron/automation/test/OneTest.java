package com.tron.automation.test;

import java.util.List;

/**
 * 一次测试
 */
public class OneTest {

    public List<TestCase> testCaseList;

    public void start() {
        for (TestCase testCase: testCaseList) {

            testCase.startTest();
        }

    }

    public List<TestCase> getTestCaseList() {
        return testCaseList;
    }

    public void setTestCaseList(List<TestCase> testCaseList) {
        this.testCaseList = testCaseList;
    }
}
