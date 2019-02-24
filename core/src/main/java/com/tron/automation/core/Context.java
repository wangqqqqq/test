package com.tron.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Screen;

import java.util.ArrayList;
import java.util.List;

/**
 * 上下文环境
 */
public class Context {
    /**
     * 鼠标
     */
    public Actions actions;

    /**
     * 浏览器驱动
     */
    public WebDriver driver;

    public Screen screen;

    /**
     * 操作结果
     */
    public List<OperateResult> operateResultList = new ArrayList<OperateResult>();

    public Context(WebDriver driver, Screen screen) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.screen = screen;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<OperateResult> getOperateResultList() {
        return operateResultList;
    }

    public void setOperateResultList(List<OperateResult> operateResultList) {
        this.operateResultList = operateResultList;
    }

    /**
     * 添加操作结果
     *
     * @param operateResult
     */
    public void addOperateResult(OperateResult operateResult) {
        operateResultList.add(operateResult);
    }
}
