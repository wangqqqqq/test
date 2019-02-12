package com.tron.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 自动测试器
 */
public class AutomaticTester {

    private TestCaseFileParse testCaseFileParse;

    /**
     * 用户数据路径
     */
    private String userDataDir;

    /**
     *
     */
    private String url;

    /**
     *
     */
    private String chromeDriverServiceUrl;

    /**
     * 测试用例文件路径
     */
    private String testCaseFilePath;

    /**
     * 浏览器驱动
     */
    private WebDriver driver;

    /**
     * 初始化  一些配置信息
     */
    private void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(userDataDir);
        System.setProperty("webdriver.chrome.driver", chromeDriverServiceUrl);//chromedriver服务地址
        driver = new ChromeDriver(chromeOptions); //新建一个WebDriver 的对象
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    /**
     * 启动测试
     */
    public void startUp() {
        init();

        OneTest oneTest = testCaseFileParse.parse(testCaseFilePath, driver);
        oneTest.start();

        driver.close();
    }
}
