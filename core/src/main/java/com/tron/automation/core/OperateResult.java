package com.tron.automation.core;

/**
 * 操作结果
 */
public class OperateResult extends Result{
    /**
     * 操作所产生的数据
     */
    public String data;

    public static OperateResult buildSuccessResult(String data){
        OperateResult operateResult = new OperateResult();
        operateResult.success = true;
        operateResult.data = data;
        return operateResult;
    }
}
