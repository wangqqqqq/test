package com.tron.automation.test;

public class Test1 {
    public static void main(String[] args) {
        AutomaticTester automaticTester = new AutomaticTester();
        automaticTester.setUserDataDir("--user-data-dir=/Users/wqq/Library/Application Support/Google/Chrome/");
        automaticTester.setUrl("http://47.90.249.61:8080/");
        automaticTester.setChromeDriverServiceUrl("/Users/wqq/Downloads/chromedriver");
        automaticTester.setTestCaseFilePath("/Users/wqq/Documents/trondice-testcase2.xlsx");
        automaticTester.setTestCaseFileParse(new TronDiceTestCaseFileParseImpl());

        automaticTester.startUp();
    }
}
