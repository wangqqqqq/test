package com.tron.automation.core;

import com.tron.automation.enums.ParamTypeEnum;

import java.math.BigDecimal;
import java.util.ArrayList;

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

    public Param(String data, ParamTypeEnum type) {
        this.data = data;
        this.type = type;
    }

    public Object getParam(){
        if (type==ParamTypeEnum.BIGDECIMAL) {
            return  new BigDecimal(data);
        } else if (type==ParamTypeEnum.INT){
            return Integer.parseInt(data);
        }

        return data;
    }

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
