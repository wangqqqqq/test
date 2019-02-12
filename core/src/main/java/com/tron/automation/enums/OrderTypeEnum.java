package com.tron.automation.enums;

import com.tron.automation.core.Order;
import com.tron.automation.core.order.get.GetTextOrder;
import com.tron.automation.core.order.key.DefaultSendKeysOrder;
import com.tron.automation.core.order.mouse.ClickOrder;
import com.tron.automation.core.order.mouse.DoubleClickOrder;

/**
 * 命令类型枚举
 */
public enum OrderTypeEnum {

    /**
     * 查看内容
     */
    VIEW_CONTENT(GetTextOrder.INSTANCE),

    /**
     * 单击
     */
    CLICK(ClickOrder.INSTANCE),

    /**
     * 双击
     */
    DOUBLE_CLICK(DoubleClickOrder.INSTANCE),

    /**
     * 按键（数字、字母、特殊）
     */
    SEND_KEYS(DefaultSendKeysOrder.INSTANCE);

    Order order;

    OrderTypeEnum(Order order) {
        this.order = order;
    }
}
