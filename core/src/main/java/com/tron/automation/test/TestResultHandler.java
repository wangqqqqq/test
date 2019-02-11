package com.tron.automation.test;

import com.tron.automation.core.OperateResult;
import com.tron.automation.core.Result;

import java.util.List;

public interface TestResultHandler {

    Result handler(List<OperateResult> operateResults, String expectedResult);
}
