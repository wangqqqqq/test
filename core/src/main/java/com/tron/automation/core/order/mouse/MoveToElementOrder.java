package com.tron.automation.core.order.mouse;

import com.tron.automation.core.*;
import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

/**
 * 鼠标移动到某个元素上命令
 */
public class MoveToElementOrder implements MouseOperationOrder {
    public static final MoveToElementOrder INSTANCE = new MoveToElementOrder();

    @Override
    public void execute(Position position, Param param, Context context) throws Exception {
        if (position.getPositionType() == PositionTypeEnum.PICTURE) {
            if (context.screen.find(position.positionUrl) != null) {
                context.screen.hover(position.positionUrl);
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

            context.actions.moveToElement(element).build().perform();
        }
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
