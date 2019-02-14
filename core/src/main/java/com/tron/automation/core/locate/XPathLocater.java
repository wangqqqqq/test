package com.tron.automation.core.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * xpath定位器
 */
public class XPathLocater implements Locate{
    public static final Locate INSTANCE = new XPathLocater();

    private XPathLocater() {
    }

    @Override
    public WebElement goToLocate(String positionUrl, WebDriver driver) {

        return driver.findElement(By.xpath(positionUrl));
    }
}
