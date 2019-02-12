package com.tron.automation.test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
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

    public AutomaticTester(TestCaseFileParse testCaseFileParse) {

        this.testCaseFileParse = testCaseFileParse;
    }

    private static String language = "english";
    private WebDriver driver;
//    WebDriverWait wait;
    private Actions action;
    Config conf;

    /**
     * 初始化  一些配置信息
     */
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        conf = ConfigFactory.parseFile(new File("src/main/resources/trondice-init.conf"));
        chromeOptions.addArguments(conf.getString("userDataDir"));
        System.setProperty("webdriver.chrome.driver", conf.getString("chromedriverServiceUrl"));//chromedriver服务地址
        driver = new ChromeDriver(chromeOptions); //新建一个WebDriver 的对象
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        action = new Actions(driver);
        driver.get(conf.getString("url"));//打开指定的网站
//        wait = new WebDriverWait(driver, 10); // 最多等10秒
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        try {
            Thread.sleep(7000);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
