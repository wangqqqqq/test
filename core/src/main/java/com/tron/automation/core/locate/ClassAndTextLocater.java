package com.tron.automation.core.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * classAndText定位器
 */
public class ClassAndTextLocater implements Locate {
    public static final Locate INSTANCE = new ClassAndTextLocater();

    private ClassAndTextLocater() {
    }

    @Override
    public WebElement goToLocate(String positionUrl, WebDriver driver) {
        String[] split = positionUrl.split("?");
        List<WebElement> elements = driver.findElements(By.className(split[0]));
        for (WebElement webElement : elements) {
            String text = webElement.getText();
            if (text.equals(split[1])) {
                return webElement;
            }
        }
        return null;
    }
}
