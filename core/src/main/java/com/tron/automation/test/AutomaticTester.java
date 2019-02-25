package com.tron.automation.test;

import com.tron.automation.factory.builder.DefaultOneTestBuilder;
import com.tron.automation.factory.builder.OneTestBuilder;
import com.tron.automation.util.SleepUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.Screen;

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
     * 屏幕
     */
    private Screen screen;

    private OneTestBuilder oneTestBuilder;

    /**
     * 启动测试
     */
    public void startUp() {
        init();

        if (oneTestBuilder == null) {
            oneTestBuilder = new DefaultOneTestBuilder();
        }
        OneTest oneTest = testCaseFileParse.parse(testCaseFilePath, driver, screen,oneTestBuilder);
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
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        SleepUtil.sleep(3000);

        screen = new Screen();
        String path1 = "/Users/wqq/Desktop/pictures/点击tronLink.png";
        String path2 = "/Users/wqq/Desktop/pictures/输入登录密码.png";
        String path3 = "/Users/wqq/Desktop/pictures/输入登录密码后确认登录.png";
        String path4 = "/Users/wqq/Desktop/pictures/刷新页面.png";
        try {
            // 登录
            if (screen.find(path1) != null) {
                screen.click(path1);
            }
            Thread.sleep(100);
            if (screen.find(path2) != null) {
                screen.type(path2,"wangqian417812");
            }
            Thread.sleep(100);
            if (screen.find(path3) != null) {
                screen.click(path3);
            }
            Thread.sleep(100);
            // 刷新
            if(screen.find(path4) != null) {
                screen.click(path4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        driver.navigate().refresh();
        SleepUtil.sleep(6000);
        //将页面滚动条拖到底部
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(1425,150);");
    }

    public OneTestBuilder getOneTestBuilder() {
        return oneTestBuilder;
    }

    public void setOneTestBuilder(OneTestBuilder oneTestBuilder) {
        this.oneTestBuilder = oneTestBuilder;
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

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
