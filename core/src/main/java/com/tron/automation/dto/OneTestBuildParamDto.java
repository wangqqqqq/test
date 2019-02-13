package com.tron.automation.dto;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class OneTestBuildParamDto {

    private List<TestCaseItemDto> testCaseItemDtoList;

    private WebDriver webDriver;

    public OneTestBuildParamDto(List<TestCaseItemDto> testCaseItemDtoList, WebDriver webDriver) {
        this.testCaseItemDtoList = testCaseItemDtoList;
        this.webDriver = webDriver;
    }

    public List<TestCaseItemDto> getTestCaseItemDtoList() {
        return testCaseItemDtoList;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
