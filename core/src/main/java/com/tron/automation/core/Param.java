package com.tron.automation.core;

import com.tron.automation.enums.ParamTypeEnum;

/**
 * 入参类
 */
public class Param {

    /**
     * 入参
     */
    public String data;

    /**
     * 入参类型
     */
    public ParamTypeEnum type;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ParamTypeEnum getType() {
        return type;
    }

    public void setType(ParamTypeEnum type) {
        this.type = type;
    }
}