package com.tron.automation.test;

import java.io.File;

/**
 * 解析测试用例文件
 */
public interface TestCaseFileParse {

    /**
     * 进行解析
     * @param FilePath
     * @return
     */
    OneTest parse(String FilePath);
}
