package com.tron.automation.core.order.mouse;

import com.tron.automation.core.*;
import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebElement;

/**
 * 双击操作命令
 */
public class DoubleClickOrder implements MouseOperationOrder {
    public static final DoubleClickOrder INSTANCE = new DoubleClickOrder();

    @Override
    public void execute(Position position, Param param, Context context) throws Exception {
        if (position.getPositionType() == PositionTypeEnum.PICTURE) {
            if (context.screen.find(position.positionUrl) != null) {
                context.screen.doubleClick(position.positionUrl);
            } else {
                context.addOperateResult(OperateResult.buildElementNotExistResult());
                return;
            }
        } else {
            WebElement element = position.getElement(context.driver);
            if (element == null) {
                context.addOperateResult(OperateResult.buildElementNotExistResult());
                return;
            }

            context.actions.doubleClick(element);
        }
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
