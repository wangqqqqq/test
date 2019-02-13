package com.tron.automation.factory.builder;

import com.tron.automation.dto.OneTestBuildParamDto;
import com.tron.automation.dto.TestCaseItemDto;
import com.tron.automation.test.OneTest;

public class DefaultOneTestBuilder implements OneTestBuilder<OneTestBuildParamDto> {
    private OneTest oneTest = new OneTest();

    @Override
    public void setBuilderParam(OneTestBuildParamDto testCaseItemDto) {

    }

    @Override
    public void buildOneOperation() {

    }

    @Override
    public void buildOperationGroup() {

    }

    @Override
    public void buildTestCase() {

    }

    @Override
    public OneTest build() {

        return oneTest;
    }
}
