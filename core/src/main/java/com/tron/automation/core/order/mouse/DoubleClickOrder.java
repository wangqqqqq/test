package com.tron.automation.core.order.mouse;

import com.tron.automation.core.*;
import org.openqa.selenium.WebElement;

/**
 * 双击操作命令
 */
public class DoubleClickOrder implements MouseOperationOrder {
    public static final DoubleClickOrder INSTANCE = new DoubleClickOrder();

    @Override
    public void execute(Position position, Param param, Context context) {
        WebElement element = position.getElement(context.driver);
        if(element==null) {
            context.addOperateResult(OperateResult.buildElementNotExistResult());
        }

        context.actions.doubleClick(element);
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
