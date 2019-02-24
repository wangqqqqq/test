package com.tron.automation.core.order.get;

import com.tron.automation.core.*;
import org.openqa.selenium.WebElement;

/**
 * 获得标签文本命令
 */
public class GetTextOrder implements GetOrder {
    public static final GetTextOrder INSTANCE = new GetTextOrder();

    @Override
    public void execute(Position position, Param param, Context context) {
        WebElement element = position.getElement(context.driver);
        if(element==null) {
            context.addOperateResult(OperateResult.buildElementNotExistResult());
            return;
        }

        String text = element.getText();
        context.addOperateResult(OperateResult.buildSuccessResult(text));
    }
}
