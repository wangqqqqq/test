package com.tron.automation.test;

import com.tron.automation.core.OneOperation;
import com.tron.automation.dto.OneTestBuildParamDto;
import com.tron.automation.dto.TestCaseItemDto;
import com.tron.automation.factory.builder.DefaultOneTestBuilder;
import com.tron.automation.factory.builder.OneTestBuilder;
import com.tron.automation.factory.builder.OneTestDirector;
import com.tron.automation.util.ExcelUtil;
import com.tron.automation.util.converter.TestCaseItemConverter;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TronDiceTestCaseFileParseImpl implements TestCaseFileParse {

    @Override
    public OneTest parse(String filePath, WebDriver webDriver, Screen screen, OneTestBuilder oneTestBuilder) {
        List<List> list = ExcelUtil.readExcel(new File(filePath));
        list.remove(0);

        List<TestCaseItemDto> testCaseItemDtoList = TestCaseItemConverter.convert(list);
        SimpleDateFormat df = new SimpleDateFormat("[yyyy-MM-dd-HH:mm]");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        String testResultFilePath = filePath.replace("testcase", "testResult" + date);
        OneTestBuildParamDto oneTestBuildParamDto = new OneTestBuildParamDto(testCaseItemDtoList, webDriver, screen, testResultFilePath);

        OneTest oneTest = OneTestDirector.createOneTest(oneTestBuilder, oneTestBuildParamDto);

        return oneTest;
    }

}
