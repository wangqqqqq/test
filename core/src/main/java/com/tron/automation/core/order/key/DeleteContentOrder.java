package com.tron.automation.core.order.key;

import com.tron.automation.core.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * 清空内容
 */
public class DeleteContentOrder implements KeyboardOrder {
    public static final DeleteContentOrder INSTANCE = new DeleteContentOrder();

    @Override
    public void execute(Position position, Param param, Context context) {
        WebElement element = position.getElement(context.driver);
        if(element==null) {
            context.addOperateResult(OperateResult.buildElementNotExistResult());
            return;
        }

        element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.DELETE);
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
