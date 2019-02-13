package com.tron.automation.dto;

import org.openqa.selenium.WebDriver;

public class OneTestBuildParamDto {

    private TestCaseItemDto testCaseItemDto;

    private WebDriver webDriver;

    public OneTestBuildParamDto(TestCaseItemDto testCaseItemDto, WebDriver webDriver) {
        this.testCaseItemDto = testCaseItemDto;
        this.webDriver = webDriver;
    }

    public TestCaseItemDto getTestCaseItemDto() {
        return testCaseItemDto;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
