package com.tron.automation.factory.builder;

import com.tron.automation.core.*;
import com.tron.automation.core.operation.DefaultOneOperation;
import com.tron.automation.dto.OneTestBuildParamDto;
import com.tron.automation.dto.OperateDescriptionDto;
import com.tron.automation.dto.TestCaseItemDto;
import com.tron.automation.enums.OrderTypeEnum;
import com.tron.automation.enums.ParamTypeEnum;
import com.tron.automation.enums.PositionTypeEnum;
import com.tron.automation.factory.OneOperationFactory;
import com.tron.automation.test.OneTest;
import com.tron.automation.test.TestCase;
import com.tron.automation.test.TestResultHandler;
import com.tron.automation.test.TestResultHandlerImpl;

import java.util.ArrayList;
import java.util.List;

public class DefaultOneTestBuilder implements OneTestBuilder<OneTestBuildParamDto> {
    private OneTest oneTest = new OneTest();

    private OneTestBuildParamDto oneTestBuildParamDto;

    private TestResultHandler testResultHandler;

    public DefaultOneTestBuilder(TestResultHandler testResultHandler) {
        this.testResultHandler = testResultHandler;
    }

    public DefaultOneTestBuilder() {
    }

    @Override
    public void setBuilderParam(OneTestBuildParamDto oneTestBuildParamDto) {
        this.oneTestBuildParamDto = oneTestBuildParamDto;
    }

    @Override
    public void buildOneOperation() {
        List<TestCase> testCaseList = oneTest.getTestCaseList();
        List<TestCaseItemDto> testCaseItemDtoList = oneTestBuildParamDto.getTestCaseItemDtoList();

        for (int i = 0; i < testCaseList.size(); i++) {
            TestCase testCase = testCaseList.get(i);
            OperationGroup operationGroup = testCase.getOperationGroup();
            List<OneOperation> oneOperationList = operationGroup.getOneOperationList();

            TestCaseItemDto testCaseItemDto = testCaseItemDtoList.get(i);
            List<OperateDescriptionDto> operateDescriptionDtoList = testCaseItemDto.getOperateDescriptionDtoList();

            for (int j = 0; j < oneOperationList.size(); j++) {
                OneOperation oneOperation = oneOperationList.get(j);
                OperateDescriptionDto operateDescriptionDto = operateDescriptionDtoList.get(j);

                oneOperation.setOrder(OrderTypeEnum.valueOf(operateDescriptionDto.getOrderType()).getOrder());
                if ((!operateDescriptionDto.getParam().equals(""))&&(!operateDescriptionDto.getParamType().equals(""))) {
                    oneOperation.setParam(new Param(operateDescriptionDto.getParam(), ParamTypeEnum.valueOf(operateDescriptionDto.getParamType())));
                }
                oneOperation.setPosition(new Position(PositionTypeEnum.valueOf(operateDescriptionDto.getPositionType()),operateDescriptionDto.getPositionUrl()));
            }
        }
    }

    @Override
    public void buildOperationGroup() {
        Context context = new Context(oneTestBuildParamDto.getWebDriver());

        List<TestCase> testCaseList = oneTest.getTestCaseList();
        List<TestCaseItemDto> testCaseItemDtoList = oneTestBuildParamDto.getTestCaseItemDtoList();
        for (int i = 0; i < testCaseList.size(); i++) {
            TestCase testCase = testCaseList.get(i);
            TestCaseItemDto testCaseItemDto = testCaseItemDtoList.get(i);

            testCase.setExpectedResult(testCaseItemDto.getExpectedResultValue());
            if (testResultHandler == null) {
                testCase.setTestResultHandler(new TestResultHandlerImpl());
            } else {
                testCase.setTestResultHandler(testResultHandler);
            }

            OperationGroup operationGroup = new OperationGroup();
            operationGroup.setContext(context);

            List<OperateDescriptionDto> operateDescriptionDtoList = testCaseItemDto.getOperateDescriptionDtoList();
            List<OneOperation> oneOperationList = new ArrayList<OneOperation>();
            for (OperateDescriptionDto operateDescriptionDto: operateDescriptionDtoList) {
                OneOperation oneOperation = OneOperationFactory.create(operateDescriptionDto.getOperationType());
                oneOperationList.add(oneOperation);
            }
            operationGroup.setOneOperationList(oneOperationList);
            testCase.setOperationGroup(operationGroup);
        }
    }

    @Override
    public void buildTestCase() {
        List<TestCase> testCases = new ArrayList<TestCase>();
        List<TestCaseItemDto> testCaseItemDtoList = oneTestBuildParamDto.getTestCaseItemDtoList();
        for (TestCaseItemDto testCaseItemDto: testCaseItemDtoList) {
            TestCase testCase = new TestCase();
            testCases.add(testCase);
        }

        oneTest.setTestCaseList(testCases);
    }

    @Override
    public OneTest build() {

        return oneTest;
    }
}
