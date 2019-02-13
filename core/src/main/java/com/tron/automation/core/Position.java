package com.tron.automation.core;

import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 位置，具体指Element
 */
public class Position {
    /**
     * 位置
     */
    private WebElement element;

    /**
     * 定位方式
     */
    public PositionTypeEnum positionType;

    /**
     * 元素路径
     */
    public String positionUrl;

    public Position(PositionTypeEnum positionType, String positionUrl) {
        this.positionType = positionType;
        this.positionUrl = positionUrl;
    }

    public WebElement getElement(WebDriver driver) {
        if (element != null) {
            return element;
        }

        WebElement webElement = Radar.accurateLocate(positionType, positionUrl, null);
        this.element = webElement;
        return element;
    }



    public void setElement(WebElement element) {
        this.element = element;
    }

    public PositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    public String getPositionUrl() {
        return positionUrl;
    }

    public void setPositionUrl(String positionUrl) {
        this.positionUrl = positionUrl;
    }
}
