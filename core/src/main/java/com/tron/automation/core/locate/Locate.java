package com.tron.automation.core.locate;

import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 定位接口
 */
public interface Locate {
    /**
     *  去定位
     */
    WebElement goToLocate(String positionUrl, WebDriver driver);
}
