package com.tron.automation.enums;

import com.tron.automation.core.locate.IdLocater;
import com.tron.automation.core.locate.Locate;



/**
 * 定位方式枚举
 */
public enum  PositionTypeEnum {

    XPATH(null),

    CLASS(null),

    ID(IdLocater.INSTANCE),

    NAME(null),

    /**
     * 先根据class获取元素列表再通过元素text来定位
     */
    CLASS_AND_TEXT(null),
    ;

    Locate locate;

    PositionTypeEnum(Locate locate) {
        this.locate = locate;
    }

    public Locate getLocate() {
        return locate;
    }
}
