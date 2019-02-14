package com.tron.automation.dto;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class OneTestBuildParamDto {

    private List<TestCaseItemDto> testCaseItemDtoList;

    private WebDriver webDriver;

    /**
     * 测试结果文件路径
     */
    private String testResultFilePath;

    public OneTestBuildParamDto(List<TestCaseItemDto> testCaseItemDtoList, WebDriver webDriver, String testResultFilePath) {
        this.testCaseItemDtoList = testCaseItemDtoList;
        this.webDriver = webDriver;
        this.testResultFilePath = testResultFilePath;
    }

    public List<TestCaseItemDto> getTestCaseItemDtoList() {
        return testCaseItemDtoList;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTestResultFilePath() {
        return testResultFilePath;
    }

    public void setTestResultFilePath(String testResultFilePath) {
        this.testResultFilePath = testResultFilePath;
    }
}
