package com.tron.automation.factory.builder;

import com.tron.automation.dto.OneTestBuildParamDto;
import com.tron.automation.dto.TestCaseItemDto;
import com.tron.automation.test.OneTest;

/**
 * 建造指挥者
 */
public class OneTestDirector {

    public static OneTest createOneTest(OneTestBuilder<OneTestBuildParamDto> oneTestBuilder, OneTestBuildParamDto oneTestBuildParamDto) {
        oneTestBuilder.setBuilderParam(oneTestBuildParamDto);

        oneTestBuilder.buildTestCase();

        oneTestBuilder.buildOperationGroup();

        oneTestBuilder.buildOneOperation();

        return oneTestBuilder.build();
    }
}
