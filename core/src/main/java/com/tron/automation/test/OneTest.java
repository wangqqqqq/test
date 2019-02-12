package com.tron.automation.test;

import com.tron.automation.core.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 一次测试
 */
public class OneTest {

    public List<TestCase> testCaseList;

    public void start() {
        List<Result> results = new ArrayList<Result>();
        for (TestCase testCase: testCaseList) {

            Result result = testCase.startTest();
            results.add(result);
        }

        //生成结果文件
    }

    public List<TestCase> getTestCaseList() {
        return testCaseList;
    }

    public void setTestCaseList(List<TestCase> testCaseList) {
        this.testCaseList = testCaseList;
    }
}
