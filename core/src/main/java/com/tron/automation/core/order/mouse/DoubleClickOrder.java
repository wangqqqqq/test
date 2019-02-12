package com.tron.automation.core.order.mouse;

import com.tron.automation.core.Context;
import com.tron.automation.core.MouseOperationOrder;
import com.tron.automation.core.Param;
import com.tron.automation.core.Position;

/**
 * 双击操作命令
 */
public class DoubleClickOrder implements MouseOperationOrder {
    public static final DoubleClickOrder INSTANCE = new DoubleClickOrder();

    @Override
    public void execute(Position position, Param param, Context context) {

        context.actions.doubleClick(position.getElement(context.driver));
    }
}
