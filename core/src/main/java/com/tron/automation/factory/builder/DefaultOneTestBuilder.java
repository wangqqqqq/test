package com.tron.automation.factory.builder;

import com.tron.automation.core.Context;
import com.tron.automation.core.DefaultOneOperation;
import com.tron.automation.core.OneOperation;
import com.tron.automation.core.OperationGroup;
import com.tron.automation.dto.OneTestBuildParamDto;
import com.tron.automation.dto.OperateDescriptionDto;
import com.tron.automation.dto.TestCaseItemDto;
import com.tron.automation.test.OneTest;
import com.tron.automation.test.TestCase;
import com.tron.automation.test.TestResultHandlerImpl;

import java.util.ArrayList;
import java.util.List;

public class DefaultOneTestBuilder implements OneTestBuilder<OneTestBuildParamDto> {
    private OneTest oneTest = new OneTest();

    private OneTestBuildParamDto oneTestBuildParamDto;

    @Override
    public void setBuilderParam(OneTestBuildParamDto oneTestBuildParamDto) {
        this.oneTestBuildParamDto = oneTestBuildParamDto;
    }

    @Override
    public void buildOneOperation() {

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
            testCase.setTestResultHandler(new TestResultHandlerImpl());

            OperationGroup operationGroup = new OperationGroup();
            operationGroup.setContext(context);

            List<OperateDescriptionDto> operateDescriptionDtoList = testCaseItemDto.getOperateDescriptionDtoList();
            List<OneOperation> oneOperationList = new ArrayList<OneOperation>();
            for (OperateDescriptionDto operateDescriptionDto: operateDescriptionDtoList) {
                OneOperation oneOperation = new DefaultOneOperation();
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
