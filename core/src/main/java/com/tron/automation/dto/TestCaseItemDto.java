package com.tron.automation.dto;

/**
 * 测试用例项
 */
public class TestCaseItemDto {
    /**
     * 操作组
     */
    private String operateGroupValue;

    /**
     * 期望结果
     */
    private String expectedResultValue;

    public String getOperateGroupValue() {
        return operateGroupValue;
    }

    public void setOperateGroupValue(String operateGroupValue) {
        this.operateGroupValue = operateGroupValue;
    }

    public String getExpectedResultValue() {
        return expectedResultValue;
    }

    public void setExpectedResultValue(String expectedResultValue) {
        this.expectedResultValue = expectedResultValue;
    }
}
