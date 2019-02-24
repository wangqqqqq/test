package com.tron.automation.enums;

import com.tron.automation.core.locate.*;


/**
 * 定位方式枚举
 */
public enum PositionTypeEnum {

    XPATH(XPathLocater.INSTANCE),

    CLASS(ClassLocater.INSTANCE),

    ID(IdLocater.INSTANCE),

    NAME(NameLocater.INSTANCE),

    /**
     * 先根据class获取元素列表再通过元素text来定位
     */
    CLASS_AND_TEXT(ClassAndTextLocater.INSTANCE),

    /**
     * 通过sikuli的图片对比方式定位
     */
    PICTURE(null),
    ;

    Locate locate;

    PositionTypeEnum(Locate locate) {
        this.locate = locate;
    }

    public Locate getLocate() {
        return locate;
    }
}
