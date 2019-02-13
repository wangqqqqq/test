package com.tron.automation.test;

import com.tron.automation.core.OperateResult;
import com.tron.automation.core.Result;

import java.util.List;

public class TestResultHandlerImpl implements TestResultHandler {
    @Override
    public Result handler(List<OperateResult> operateResults, String expectedResult) {
        for (int i = 0; i < operateResults.size(); i++) {
            
        }
        
        return null;
    }
}
