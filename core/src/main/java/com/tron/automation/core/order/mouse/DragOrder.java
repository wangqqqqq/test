package com.tron.automation.core.order.mouse;

import com.tron.automation.core.*;
import org.openqa.selenium.WebElement;

/**
 * 拖拽操作命令
 */
public class DragOrder implements MouseOperationOrder {
    public static final DragOrder INSTANCE = new DragOrder();

    @Override
    public void execute(Position position, Param param, Context context) {
        WebElement element = position.getElement(context.driver);
        if(element==null) {
            context.addOperateResult(OperateResult.buildElementNotExistResult());
        }

        context.actions.dragAndDropBy(element, Integer.parseInt(param.data), 0).build().perform();
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
