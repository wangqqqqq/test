package com.tron.automation.enums;

import com.tron.automation.core.Order;
import com.tron.automation.core.order.get.FindOrder;
import com.tron.automation.core.order.get.GetTextOrder;
import com.tron.automation.core.order.key.DefaultSendKeysOrder;
import com.tron.automation.core.order.key.DeleteContentOrder;
import com.tron.automation.core.order.key.PasteOrder;
import com.tron.automation.core.order.mouse.ClickOrder;
import com.tron.automation.core.order.mouse.DoubleClickOrder;
import com.tron.automation.core.order.mouse.DragOrder;
import com.tron.automation.core.order.mouse.MoveToElementOrder;

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
     * 拖拽
     */
    DRAG(DragOrder.INSTANCE),

    /**
     * 按键（数字、字母）
     */
    SEND_KEYS(DefaultSendKeysOrder.INSTANCE),

    /**
     * 清空内容
     */
    DELETE_CONTENT(DeleteContentOrder.INSTANCE),

    /**
     * 移动到某个元素
     */
    MOVE_TO_ELEMENT(MoveToElementOrder.INSTANCE),

    /**
     * 匹配到某个元素（特指图片）
     */
    FIND(FindOrder.INSTANCE),

    /**
     * 获得焦点后粘贴（特指通过图片选择输入框后粘贴）
     */
    PASTE(PasteOrder.INSTANCE),
    ;

    Order order;

    OrderTypeEnum(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
