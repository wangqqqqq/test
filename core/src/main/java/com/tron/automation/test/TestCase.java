package com.tron.automation.test;

import com.tron.automation.core.Context;
import com.tron.automation.core.OperateResult;
import com.tron.automation.core.OperationGroup;
import com.tron.automation.core.Result;

import java.util.List;

/**
 * 测试用例
 */
public class TestCase {
    /**
     * 操作组
     */
    private OperationGroup operationGroup;

    /**
     * 预期结果
     */
    private String expectedResult;

    /**
     *  操作结果与预期结果处理者
     */
    private TestResultHandler testResultHandler;

    public OperationGroup getOperationGroup() {
        return operationGroup;
    }

    public void setOperationGroup(OperationGroup operationGroup) {
        this.operationGroup = operationGroup;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public TestResultHandler getTestResultHandler() {
        return testResultHandler;
    }

    public void setTestResultHandler(TestResultHandler testResultHandler) {
        this.testResultHandler = testResultHandler;
    }

    /**
     * 生成测试结果
     */
    private void generateTestReport() {
        List<OperateResult> operateResultList = operationGroup.getOperateResultList();

        Result handlerResult = testResultHandler.handler(operateResultList, expectedResult);
        //生成测试结果

    }

    /**
     * 开始测试
     */
    public void startTest() {
        operationGroup.executeNextOperate();

        generateTestReport();
    }

}
