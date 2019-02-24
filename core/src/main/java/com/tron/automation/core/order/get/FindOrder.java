package com.tron.automation.core.order.get;

import com.tron.automation.core.*;
import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebElement;

/**
 * 匹配到元素命令
 */
public class FindOrder implements GetOrder {
    public static final FindOrder INSTANCE = new FindOrder();

    @Override
    public void execute(Position position, Param param, Context context) throws Exception{
        if (position.getPositionType() == PositionTypeEnum.PICTURE) {
            if (context.screen.find(position.positionUrl) != null) {
                context.addOperateResult(OperateResult.buildSuccessResult());
            } else {
                context.addOperateResult(OperateResult.buildElementNotExistResult());
            }
        }else {
            context.addOperateResult(OperateResult.buildFailResult("操作有误，FIND命令的元素定位方式必须为图片"));
        }

    }
}
