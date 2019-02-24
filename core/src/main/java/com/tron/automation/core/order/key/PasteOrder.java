package com.tron.automation.core.order.key;

import com.tron.automation.core.*;
import com.tron.automation.enums.PositionTypeEnum;
import org.openqa.selenium.WebElement;

/**
 * 获得焦点后粘贴（特指通过图片选择输入框后粘贴）
 */
public class PasteOrder implements KeyboardOrder {
    public static final PasteOrder INSTANCE = new PasteOrder();

    @Override
    public void execute(Position position, Param param, Context context) throws Exception {
        if (position.getPositionType() == PositionTypeEnum.PICTURE) {
            if (context.screen.find(position.positionUrl) != null) {
                context.screen.paste(position.positionUrl, param.data);
                context.addOperateResult(OperateResult.buildSuccessResult());
            } else {
                context.addOperateResult(OperateResult.buildElementNotExistResult());
            }
        } else {
            context.addOperateResult(OperateResult.buildFailResult("操作有误，PASTE命令的元素定位方式必须为图片"));
        }
    }
}
