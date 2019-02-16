package com.tron.test;

import com.tron.automation.test.AutomaticTester;
import com.tron.automation.test.TronDiceTestCaseFileParseImpl;

public class Test {
    public static void main(String[] args) {
        AutomaticTester automaticTester = new AutomaticTester();
        automaticTester.setUserDataDir("--user-data-dir=/Users/wqq/Library/Application Support/Google/Chrome/");
        automaticTester.setUrl("https://www.baidu.com/");
        automaticTester.setChromeDriverServiceUrl("/Users/wqq/Downloads/chromedriver");
        automaticTester.setTestCaseFilePath("/Users/wqq/Documents/trondice-testcase2.xlsx");
        automaticTester.setTestCaseFileParse(new TronDiceTestCaseFileParseImpl());

        automaticTester.startUp();
    }
}
