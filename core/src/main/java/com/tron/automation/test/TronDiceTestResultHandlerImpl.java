package com.tron.automation.test;

import com.alibaba.fastjson.JSON;
import com.tron.automation.core.OperateResult;
import com.tron.automation.core.Result;
import com.tron.automation.core.operation.DefaultOneOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TronDiceTestResultHandlerImpl implements TestResultHandler {
    private static final Logger log = LoggerFactory.getLogger(TronDiceTestResultHandlerImpl.class);

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
                return result;
            }
        }

        System.out.println("expectedResult:"+expectedResult);
        if(!expectedResult.equals("")) {
            Map<String, String> maps = (Map) JSON.parse(expectedResult);
            // 判断该测试用例是否是投注
            System.out.println("maps.containsKey(isRoll):" + maps.containsKey("isRoll"));
            System.out.println("maps.get(isRoll).equals(true):" + maps.get("isRoll").equals(true));
            if ((maps.containsKey("isRoll")) && (maps.get("isRoll").equals("true"))) {
                try {
                    OperateResult beforeRollTotalWagerResult = operateResults.get(1);
                    int beforeRollTotalWager = new DecimalFormat().parse(beforeRollTotalWagerResult.getData().split(" ")[0]).intValue();
                    OperateResult afterRollTotalWagerResult = operateResults.get(9);
                    int afterRollTotalWager = new DecimalFormat().parse(afterRollTotalWagerResult.getData().split(" ")[0]).intValue();
                    int betAmount = Integer.parseInt((String) maps.get("betAmount"));
                    System.out.println("beforeRollTotalWager:" + beforeRollTotalWager + "afterRollTotalWager:" + afterRollTotalWager);
                    if ((beforeRollTotalWager + betAmount) != afterRollTotalWager) {
                        result.setSuccess(Boolean.FALSE);
                        result.setMessage("Daily Rankings---Total Wager---> error");
                        return result;
                    }
                } catch (Exception e) {
                    log.error("TronDice测试结果处理失败", e);
                    result.setSuccess(Boolean.FALSE);
                    result.setMessage("TronDice测试结果处理失败");
                    return result;
                }
            }
        }
        return result;
    }
}
