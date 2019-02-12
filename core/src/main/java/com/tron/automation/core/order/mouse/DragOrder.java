package com.tron.automation.core.order.mouse;

import com.tron.automation.core.Context;
import com.tron.automation.core.MouseOperationOrder;
import com.tron.automation.core.Param;
import com.tron.automation.core.Position;

/**
 * 双击操作命令
 */
public class DragOrder implements MouseOperationOrder {
    public static final DragOrder INSTANCE = new DragOrder();

    @Override
    public void execute(Position position, Param param, Context context) {

        context.actions.dragAndDropBy(position.element, Integer.parseInt(param.data), 0).build().perform();
    }
}
