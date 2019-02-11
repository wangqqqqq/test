package com.tron.automation.test;

/**
 * 自动测试器
 */
public class AutomaticTester {

    private TestCaseFileParse testCaseFileParse;

    public AutomaticTester(TestCaseFileParse testCaseFileParse) {
        this.testCaseFileParse = testCaseFileParse;
    }

    /**
     * 初始化  一些配置信息
     */
    public void init() {

    }

    /**
     * 启动测试
     * @param filePath
     */
    public void startUp(String filePath) {
        OneTest oneTest = testCaseFileParse.parse(filePath);
        oneTest.start();
    }
}
