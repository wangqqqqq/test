package com.tron.automation.core.order.mouse;

import com.tron.automation.core.*;
import com.tron.automation.util.SleepUtil;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

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

        context.actions.dragAndDropBy(element, new BigDecimal(param.data).intValue(), 0).build().perform();
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
