package com.tron.automation.core.order.mouse;

import com.tron.automation.core.Context;
import com.tron.automation.core.MouseOperationOrder;
import com.tron.automation.core.Param;
import com.tron.automation.core.Position;
import org.openqa.selenium.interactions.Actions;

/**
 * 单击操作命令
 */
public class ClickOrder implements MouseOperationOrder {
    public static final ClickOrder INSTANCE = new ClickOrder();

    @Override
    public void execute(Position position, Param param, Context context) {

        context.actions.click(position.getElement(context.driver));
    }
}
