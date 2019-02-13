package com.tron.automation.test;

import com.tron.automation.util.SleepUtil;
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
     * 测试网址
     */
    private String url;

    /**
     * chromedriver服务地址
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
     * 启动测试
     */
    public void startUp() {
        init();

        OneTest oneTest = testCaseFileParse.parse(testCaseFilePath, driver);
        oneTest.start();

        driver.quit();
    }

    /**
     * 初始化  一些配置信息
     */
    private void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(userDataDir);
        System.setProperty("webdriver.chrome.driver", chromeDriverServiceUrl);//chromedriver服务地址
        driver = new ChromeDriver(chromeOptions); //新建一个WebDriver 的对象
        driver.get("http://47.90.249.61:8080/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        SleepUtil.sleep(7000);
        driver.navigate().refresh();
        SleepUtil.sleep(7000);
    }

    public TestCaseFileParse getTestCaseFileParse() {
        return testCaseFileParse;
    }

    public void setTestCaseFileParse(TestCaseFileParse testCaseFileParse) {
        this.testCaseFileParse = testCaseFileParse;
    }

    public String getUserDataDir() {
        return userDataDir;
    }

    public void setUserDataDir(String userDataDir) {
        this.userDataDir = userDataDir;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChromeDriverServiceUrl() {
        return chromeDriverServiceUrl;
    }

    public void setChromeDriverServiceUrl(String chromeDriverServiceUrl) {
        this.chromeDriverServiceUrl = chromeDriverServiceUrl;
    }

    public String getTestCaseFilePath() {
        return testCaseFilePath;
    }

    public void setTestCaseFilePath(String testCaseFilePath) {
        this.testCaseFilePath = testCaseFilePath;
    }

}
