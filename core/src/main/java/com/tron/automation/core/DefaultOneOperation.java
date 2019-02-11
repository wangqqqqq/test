package com.tron.automation.core;

/**
 * 默认的操作
 */
public class DefaultOneOperation extends OneOperation {
    @Override
    public void begin() {

    }

    @Override
    public void end() {

    }

    @Override
    public void doOperate(Context context) {
        order.execute(position, context);
    }

    @Override
    public void executeOperate(OperationGroup operationGroup) {
        executeDefaultOperate(operationGroup.context);

        operationGroup.executeNextOperate();
    }
}
