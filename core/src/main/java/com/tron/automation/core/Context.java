package com.tron.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
     *  浏览器驱动
     */
    public WebDriver driver;

    /**
     * 操作结果
     */
    public List<OperateResult> operateResultList;

    public Context(WebDriver driver) {
        this.driver = driver;
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

    public List<OperateResult> getOperateResultList() {
        return operateResultList;
    }

    public void setOperateResultList(List<OperateResult> operateResultList) {
        this.operateResultList = operateResultList;
    }

    /**
     * 添加操作结果
     * @param operateResult
     */
    public void addOperateResult(OperateResult operateResult) {
        operateResultList.add(operateResult);
    }
}
