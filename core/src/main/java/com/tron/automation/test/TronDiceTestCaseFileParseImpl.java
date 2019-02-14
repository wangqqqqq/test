package com.tron.automation.test;

import com.tron.automation.dto.OneTestBuildParamDto;
import com.tron.automation.dto.TestCaseItemDto;
import com.tron.automation.factory.builder.DefaultOneTestBuilder;
import com.tron.automation.factory.builder.OneTestDirector;
import com.tron.automation.util.ExcelUtil;
import com.tron.automation.util.converter.TestCaseItemConverter;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;

public class TronDiceTestCaseFileParseImpl implements TestCaseFileParse {

    @Override
    public OneTest parse(String filePath, WebDriver webDriver) {
        List<List> list = ExcelUtil.readExcel(new File(filePath));
        list.remove(0);

        List<TestCaseItemDto> testCaseItemDtoList = TestCaseItemConverter.convert(list);
        String testResultFilePath = filePath.replace("testcase", "testResult");
        OneTestBuildParamDto oneTestBuildParamDto = new OneTestBuildParamDto(testCaseItemDtoList, webDriver, testResultFilePath);

        OneTest oneTest = OneTestDirector.createOneTest(new DefaultOneTestBuilder(), oneTestBuildParamDto);

        return oneTest;
    }

        /*Config conf = conf = ConfigFactory.parseFile(new File("src/main/resources/trondice-testcase.conf"));
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
    return oneTest;*/

}
