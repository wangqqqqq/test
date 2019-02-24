package com.tron.automation.core;

/**
 * 操作结果
 */
public class OperateResult extends Result{

    /**
     * 操作所产生的数据
     */
    public String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static OperateResult buildSuccessResult(){
        OperateResult operateResult = new OperateResult();
        operateResult.setSuccess(true);
        return operateResult;
    }

    public static OperateResult buildSuccessResult(String data){
        OperateResult operateResult = new OperateResult();
        operateResult.setSuccess(true);
        operateResult.setData(data);
        return operateResult;
    }

    public static OperateResult buildFailResult(){
        OperateResult operateResult = new OperateResult();
        operateResult.setSuccess(false);
        return operateResult;
    }

    public static OperateResult buildFailResult(String message){
        OperateResult operateResult = new OperateResult();
        operateResult.setSuccess(false);
        operateResult.setMessage(message);
        return operateResult;
    }

    public static OperateResult buildElementNotExistResult(){
        OperateResult operateResult = new OperateResult();
        operateResult.setSuccess(false);
        operateResult.setCode(2);// 2代表元素不存在
        operateResult.setMessage("获取元素失败");
        return operateResult;
    }
}
