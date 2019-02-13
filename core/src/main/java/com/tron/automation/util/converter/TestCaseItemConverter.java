package com.tron.automation.util.converter;

import com.tron.automation.dto.TestCaseItemDto;

import java.util.List;

/**
 * 转换器
 */
public class TestCaseItemConverter {

    public static TestCaseItemDto convert(List<List> list) {
        for (List a : list) {
            for (Object o: a) {
                System.out.println(o);
            }
        }
        return null;
    }
}
