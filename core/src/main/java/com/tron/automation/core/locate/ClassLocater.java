package com.tron.automation.core.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * class定位器
 */
public class ClassLocater implements Locate{
    public static final Locate INSTANCE = new ClassLocater();

    private ClassLocater() {
    }

    @Override
    public WebElement goToLocate(String positionUrl, WebDriver driver) {

        return driver.findElement(By.className(positionUrl));
    }
}
