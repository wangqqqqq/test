package com.tron.automation.core;

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
     * 入参
     */
    public String param;

    /**
     * 操作结果
     */
    public List<OperateResult> operateResultList;

    /**
     * 添加操作结果
     * @param operateResult
     */
    public void addOperateResult(OperateResult operateResult) {
        operateResultList.add(operateResult);
    }
}
