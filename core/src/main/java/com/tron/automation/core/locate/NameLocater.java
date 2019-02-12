package com.tron.automation.core.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * name定位器
 */
public class NameLocater implements Locate{
    public static final Locate INSTANCE = new NameLocater();

    private NameLocater() {
    }

    @Override
    public WebElement goToLocate(String positionUrl, WebDriver driver) {

        return driver.findElement(By.name(positionUrl));
    }
}
