package com.tron.automation.core.operation;

import com.tron.automation.core.Context;
import com.tron.automation.core.OneOperation;
import com.tron.automation.core.OperateResult;
import com.tron.automation.core.OperationGroup;
import com.tron.automation.util.SleepUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 投注操作
 */
public class OneBetOperation extends OneOperation {
    private static final Logger log = LoggerFactory.getLogger(OneBetOperation.class);

    @Override
    public void begin() {

    }

    @Override
    public void end() {
        SleepUtil.sleep(45000);
    }

    @Override
    public void doOperate(Context context) {
        try {
            order.execute(position, param, context);
        } catch (Exception e) {
            context.addOperateResult(OperateResult.buildFailResult());
            log.error("执行命令时出现异常", e);
        }
    }

    @Override
    public void executeOperate(OperationGroup operationGroup) {
        executeDefaultOperate(operationGroup.context);

        operationGroup.executeNextOperate();
    }
}
