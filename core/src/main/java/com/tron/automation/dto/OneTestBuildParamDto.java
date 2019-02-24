package com.tron.automation.dto;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import java.util.List;

public class OneTestBuildParamDto {

    private List<TestCaseItemDto> testCaseItemDtoList;

    private WebDriver webDriver;

    private Screen screen;

    /**
     * 测试结果文件路径
     */
    private String testResultFilePath;

    public OneTestBuildParamDto(List<TestCaseItemDto> testCaseItemDtoList, WebDriver webDriver, Screen screen, String testResultFilePath) {
        this.testCaseItemDtoList = testCaseItemDtoList;
        this.webDriver = webDriver;
        this.screen = screen;
        this.testResultFilePath = testResultFilePath;
    }

    public List<TestCaseItemDto> getTestCaseItemDtoList() {
        return testCaseItemDtoList;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String getTestResultFilePath() {
        return testResultFilePath;
    }

    public void setTestResultFilePath(String testResultFilePath) {
        this.testResultFilePath = testResultFilePath;
    }
}
