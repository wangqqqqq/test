package com.tron.automation.core.order.mouse;

import com.tron.automation.core.Context;
import com.tron.automation.core.MouseOperationOrder;
import com.tron.automation.core.Position;
import org.openqa.selenium.interactions.Actions;

/**
 * 单击操作命令
 */
public class ClickOrder implements MouseOperationOrder {

    @Override
    public void execute(Position position, Context context) {

        context.actions.click(position.element);
    }
}
