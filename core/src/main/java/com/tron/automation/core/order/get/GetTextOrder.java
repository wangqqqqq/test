package com.tron.automation.core.order.get;

import com.tron.automation.core.Context;
import com.tron.automation.core.GetOrder;
import com.tron.automation.core.Position;

/**
 * 获得标签文本命令
 */
public class GetTextOrder implements GetOrder {
    @Override
    public void execute(Position position, Context context) {

        position.element.getText();
    }
}
