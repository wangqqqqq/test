package com.tron.automation.core.order.key;

import com.tron.automation.core.*;
import org.openqa.selenium.WebElement;

/**
 * 默认的输入 键 命名
 */
public class DefaultSendKeysOrder implements KeyboardOrder {
    public static final DefaultSendKeysOrder INSTANCE = new DefaultSendKeysOrder();

    @Override
    public void execute(Position position, Param param, Context context) {
        WebElement element = position.getElement(context.driver);
        if(element==null) {
            context.addOperateResult(OperateResult.buildElementNotExistResult());
        }

        element.sendKeys(param.data);
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
