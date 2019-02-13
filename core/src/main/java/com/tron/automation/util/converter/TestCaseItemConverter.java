package com.tron.automation.util.converter;

import com.alibaba.fastjson.JSON;
import com.tron.automation.dto.OperateDescriptionDto;
import com.tron.automation.dto.TestCaseItemDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器
 */
public class TestCaseItemConverter {

    public static List<TestCaseItemDto> convert(List<List> list) {
        List<TestCaseItemDto> testCaseItemDtoList = new ArrayList<TestCaseItemDto>();

        for (List<String> values : list) {
            TestCaseItemDto testCaseItemDto = new TestCaseItemDto();
//            JSON.
            List<OperateDescriptionDto> operateDescriptionDtos = JSON.parseArray(values.get(0), OperateDescriptionDto.class);
            testCaseItemDto.setOperateDescriptionDtoList(operateDescriptionDtos);
            testCaseItemDto.setExpectedResultValue(values.get(1));

            testCaseItemDtoList.add(testCaseItemDto);
        }
        return testCaseItemDtoList;
    }
}
