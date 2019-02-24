package com.tron.automation.core.order.mouse;

import com.tron.automation.core.*;
import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;

/**
 * 单击操作命令
 */
public class ClickOrder implements MouseOperationOrder {
    public static final ClickOrder INSTANCE = new ClickOrder();

    @Override
    public void execute(Position position, Param param, Context context) throws Exception {
        if (position.getPositionType() == PositionTypeEnum.PICTURE) {
//            context.screen.wait(position.positionUrl,800);
            if (context.screen.find(position.positionUrl) != null) {
                context.screen.click(position.positionUrl);
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

            context.actions.moveToElement(element).click().perform();// element.click();
        }
        context.addOperateResult(OperateResult.buildSuccessResult());
    }
}
