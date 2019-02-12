package com.tron.automation.core;

import com.tron.automation.enums.ParamTypeEnum;
import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebElement;

/**
 * 位置，具体指Element
 */
public class Position {
    /**
     * 位置
     */
    public WebElement element;

    /**
     * 定位方式
     */
    public PositionTypeEnum positionType;

    /**
     * 元素路径
     */
    public String positionUrl;
}
