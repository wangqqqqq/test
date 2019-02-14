package com.tron.automation.test;

import com.tron.automation.core.OperateResult;
import com.tron.automation.core.OperationGroup;
import com.tron.automation.core.Result;
import com.tron.automation.util.ExcelUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 操作结果与预期结果处理者
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
    private Result generateTestReport() {
        List<OperateResult> operateResultList = operationGroup.getOperateResultList();

        Result handlerResult = testResultHandler.handler(operateResultList, expectedResult);

        // 往excel中输出测试结果
        List<Map> mapList = new ArrayList<Map>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("isSuccess", handlerResult.getSuccess().equals(true) ? "SUCCESS" : "FAIL");
        map.put("code", handlerResult.getCode().toString());
        map.put("message",handlerResult.getMessage());
        ExcelUtil.writeExcel(mapList, 3, "");

        return handlerResult;

    }

    /**
     * 开始测试
     */
    public Result startTest() {
        operationGroup.executeNextOperate();

        return generateTestReport();
    }

}
