package com.tron.automation.core.operation;

import com.tron.automation.core.Context;
import com.tron.automation.core.OneOperation;
import com.tron.automation.core.OperationGroup;

/**
 * 投注操作
 */
public class OneBetOperation extends OneOperation {
    @Override
    public void begin() {

    }

    @Override
    public void end() {

    }

    @Override
    public void doOperate(Context context) {
        order.execute(position, param, context);
    }

    @Override
    public void executeOperate(OperationGroup operationGroup) {
        executeDefaultOperate(operationGroup.context);

        operationGroup.executeNextOperate();
    }
}
