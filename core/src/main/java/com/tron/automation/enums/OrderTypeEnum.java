package com.tron.automation.enums;

import com.tron.automation.core.Order;
import com.tron.automation.core.order.mouse.ClickOrder;

/**
 * 命令类型枚举
 */
public enum OrderTypeEnum {
    /**
     * 单击
     */
    CLICK(ClickOrder.INSTANCE),
    ;

    Order order;

    OrderTypeEnum(Order order) {
        this.order = order;
    }
}
