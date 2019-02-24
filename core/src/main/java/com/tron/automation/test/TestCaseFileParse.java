package com.tron.automation.test;

import com.tron.automation.core.OneOperation;
import com.tron.automation.factory.builder.OneTestBuilder;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import java.io.File;

/**
 * 解析测试用例文件
 */
public interface TestCaseFileParse {

    /**
     * 进行解析
     * @param filePath
     * @return
     */
    OneTest parse(String filePath, WebDriver webDriver, Screen screen, OneTestBuilder oneTestBuilder);
}
