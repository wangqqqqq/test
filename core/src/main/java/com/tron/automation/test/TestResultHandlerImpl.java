package com.tron.automation.test;

import com.tron.automation.core.OperateResult;
import com.tron.automation.core.Result;

import java.util.List;

public class TestResultHandlerImpl implements TestResultHandler {
    @Override
    public Result handler(List<OperateResult> operateResults, String expectedResult) {
        Result result = new Result();
        result.setSuccess(true);
        for (int i = 0; i < operateResults.size(); i++) {
            OperateResult operateResult = operateResults.get(i);
            Boolean success = operateResult.getSuccess();
            if (!success) {
                result.setSuccess(success);
                result.setCode(operateResult.getCode());
                result.setMessage(operateResult.getMessage());
            } else {
                // 待补充
            }
        }

        return result;
    }
}
