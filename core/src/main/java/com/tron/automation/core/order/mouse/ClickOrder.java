package com.tron.automation.core.order.mouse;

import com.tron.automation.core.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 单击操作命令
 */
public class ClickOrder implements MouseOperationOrder {
    public static final ClickOrder INSTANCE = new ClickOrder();

    @Override
    public void execute(Position position, Param param, Context context) {
        WebElement element = position.getElement(context.driver);
        if(element==null) {
            context.addOperateResult(OperateResult.buildElementNotExistResult());
        }

        context.actions.click(element);
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
