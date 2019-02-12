package com.tron.automation.test;

import com.google.common.base.Enums;
import com.tron.automation.core.*;
import com.tron.automation.core.order.mouse.ClickOrder;
import com.tron.automation.enums.OrderTypeEnum;
import com.tron.automation.enums.ParamTypeEnum;
import com.tron.automation.enums.PositionTypeEnum;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.lang3.EnumUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestCaseFileParseImpl implements TestCaseFileParse {

    @Override
    public OneTest parse(String FilePath) {
        Config conf = conf = ConfigFactory.parseFile(new File("src/main/resources/trondice-testcase.conf"));
        OneTest oneTest = new OneTest();
        List<TestCase> testCaseList = new ArrayList<TestCase>();
        for (Config config : conf.getConfigList("testCase")) {
            TestCase testCase = new TestCase();
            // 一个测试用例包含多个操作，一个预期结果
            OperationGroup operationGroup = new OperationGroup();
            for (Config operation : conf.getConfigList("do")) {
                OneOperation oneOperation = new DefaultOneOperation();
                oneOperation.setOrder(OrderTypeEnum.valueOf(operation.getString("orderType")).getOrder());

                Param param = new Param();
                param.setData(operation.getString("param"));
                param.setType(ParamTypeEnum.valueOf(operation.getString("paramType")));
                oneOperation.setParam(param);

                Position position = new Position();
                position.setPositionType(PositionTypeEnum.valueOf(operation.getString("positionType")));
                position.setPositionUrl(operation.getString("positionUrl"));
                oneOperation.setPosition(position);
            }
            testCase.setOperationGroup(operationGroup);
            // 预期结果
            String expectedResult = conf.getString("expectedResult");
            testCase.setExpectedResult(expectedResult);
            testCaseList.add(testCase);
        }
        oneTest.setTestCaseList(testCaseList);
        return oneTest;
    }
}
