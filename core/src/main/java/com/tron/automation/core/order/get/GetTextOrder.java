package com.tron.automation.core.order.get;

import com.tron.automation.core.*;

/**
 * 获得标签文本命令
 */
public class GetTextOrder implements GetOrder {
    public static final GetTextOrder INSTANCE = new GetTextOrder();

    @Override
    public void execute(Position position, Param param, Context context) {

        String text = position.element.getText();

        context.addOperateResult(OperateResult.buildSuccessResult(text));
    }
}
