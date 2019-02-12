package com.tron.automation.core.order.key;

import com.tron.automation.core.Context;
import com.tron.automation.core.KeyboardOrder;
import com.tron.automation.core.Position;

/**
 * 默认的输入 键 命名
 */
public class DefaultSendKeysOrder implements KeyboardOrder {
    public static final DefaultSendKeysOrder INSTANCE = new DefaultSendKeysOrder();

    @Override
    public void execute(Position position, Context context) {

        position.element.sendKeys(position.param);
    }
}
