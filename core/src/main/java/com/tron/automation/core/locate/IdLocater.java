package com.tron.automation.core.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Id定位器
 */
public class IdLocater implements Locate{
    public static final Locate INSTANCE = new IdLocater();

    private IdLocater() {
    }

    @Override
    public WebElement goToLocate(String positionUrl, WebDriver driver) {

        return driver.findElement(By.id("positionUrl"));
    }
}
