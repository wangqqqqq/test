package com.tron.automation.test;

import com.tron.automation.factory.builder.DefaultOneTestBuilder;

public class Test1 {
    public static void main(String[] args) {
        AutomaticTester automaticTester = new AutomaticTester();
        automaticTester.setUserDataDir("--user-data-dir=/Users/wqq/Library/Application Support/Google/Chrome/");
        automaticTester.setUrl("http://47.90.249.61:8080/");
        automaticTester.setChromeDriverServiceUrl("/Users/wqq/Downloads/chromedriver");
        automaticTester.setTestCaseFilePath("/Users/wqq/Documents/trondice-testcase.xlsx");
        automaticTester.setOneTestBuilder(new DefaultOneTestBuilder(new TestResultHandlerImpl()));
        automaticTester.setTestCaseFileParse(new TronDiceTestCaseFileParseImpl());

        automaticTester.startUp();
    }
}
