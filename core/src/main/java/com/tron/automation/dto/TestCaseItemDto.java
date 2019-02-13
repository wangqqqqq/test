package com.tron.automation.dto;

import java.util.List;

/**
 * 测试用例项
 */
public class TestCaseItemDto {
    /**
     * 操作组
     */
    private List<OperateDescriptionDto> operateDescriptionDtoList;

    /**
     * 期望结果
     */
    private String expectedResultValue;

    public List<OperateDescriptionDto> getOperateDescriptionDtoList() {
        return operateDescriptionDtoList;
    }

    public void setOperateDescriptionDtoList(List<OperateDescriptionDto> operateDescriptionDtoList) {
        this.operateDescriptionDtoList = operateDescriptionDtoList;
    }

    public String getExpectedResultValue() {
        return expectedResultValue;
    }

    public void setExpectedResultValue(String expectedResultValue) {
        this.expectedResultValue = expectedResultValue;
    }
}
