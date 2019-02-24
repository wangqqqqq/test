package com.tron.automation.test;

import com.tron.automation.core.OperateResult;
import com.tron.automation.core.OperationGroup;
import com.tron.automation.core.Result;
import com.tron.automation.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试用例
 */
public class TestCase {
    private static final Logger log = LoggerFactory.getLogger(OperationGroup.class);
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

    /**
     * 测试结果文件路径
     */
    private String testResultFilePath;

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

    public String getTestResultFilePath() {
        return testResultFilePath;
    }

    public void setTestResultFilePath(String testResultFilePath) {
        this.testResultFilePath = testResultFilePath;
    }

    /**
     * 生成测试结果
     */
    private Result generateTestReport() {
        List<OperateResult> operateResultList = operationGroup.getOperateResultList();

        Result handlerResult = testResultHandler.handler(operateResultList, expectedResult);

        // 往excel中输出测试结果
        log.info("开始输出测试结果");
        List<Map> mapList = new ArrayList<Map>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("isSuccess", handlerResult.getSuccess().equals(true) ? "SUCCESS" : "FAIL");
        map.put("code", handlerResult.getCode() == null ? "" : handlerResult.getCode().toString());
        map.put("message", handlerResult.getMessage() == null ? "" : handlerResult.getMessage());
        mapList.add(map);
        ExcelUtil.writeExcel(mapList, 3, testResultFilePath);

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
