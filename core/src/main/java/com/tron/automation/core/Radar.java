package com.tron.automation.core;

import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 雷达类，去定位WebElement
 */
public class Radar {


    /**
     * 精确定位
     * @return
     */
    public static WebElement accurateLocate(PositionTypeEnum positionTypeEnum, String positionUrl, WebDriver driver) {

        return positionTypeEnum.getLocate().goToLocate(positionUrl, driver);
    }
}
