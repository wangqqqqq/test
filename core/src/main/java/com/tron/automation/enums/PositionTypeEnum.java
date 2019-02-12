package com.tron.automation.enums;

/**
 * 定位方式枚举
 */
public enum  PositionTypeEnum {

    XPATH,

    CLASS,

    ID,

    NAME,

    /**
     * 先根据class获取元素列表再通过元素text来定位
     */
    CLASS_AND_TEXT,
}
