package baseAndroidTest;

/*
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//放置Android的配置参数
public class baseAndroid {
    public static AndroidDriver driver;
    @BeforeClass//启动APP
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("app","C:\\Users\\ning\\Desktop\\pconline1524673394580.apk");//从指定位置安装apk
        //cap.setCapability("fullReset","True");//卸载应用
        //cap.setCapability("noReset","True");//是否从新安装APK
        //cap.setCapability("noSign","True");//跳过重签名

        cap.setCapability("automationName", "Appium");//安卓4.2以上，默认使用appium引擎，不写也可以
        //capabilities.setCapability("automationName", "selendroid");//安卓4.2以下

        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "127.0.0.1:62001");
        cap.setCapability("platformVersion", "4.4.2");



        //支持中文输入
        cap.setCapability("unicodeKeyboard","true");
        cap.setCapability("resetKeyboard","true");

        //网易严选
        cap.setCapability("appPackage","com.netease.yanxuan");
        cap.setCapability("appActivity","com.netease.yanxuan.module.splash.SplashActivity");

        //飞牛B2B
        //cap.setCapability("appPackage","com.feiniu.b2b.develop");
        //cap.setCapability("appActivity","com.fn.b2b.main.home.activity.HomeSplashActivity");

        // cap.setCapability("appWaitActivity", "com.netease.yanxuan/.module.mainpage.activity.MainPageActivity");
        //driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(1500,TimeUnit.SECONDS);
    }


    @AfterTest//退出APP
    public void tearDown(){
        driver.quit();
    }

}
*/

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;

public class baseAndroid {
    public static AndroidDriver driver;
    @org.testng.annotations.BeforeClass
    public static void beforeClass() throws Exception{
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "127.0.0.1:62001");
        cap.setCapability("platformVersion", "4.4.2");
        cap.setCapability("unicodeKeyboard",true);
        cap.setCapability("resetKeyboard",true);
        cap.setCapability("appPackage", "com.feiniu.bdtool");
        cap.setCapability("appActivity", "com.feiniu.bdtool.common.activity.LoginActivity");
        //cap.setCapability("noSign","True");//跳过重签名
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }

    @org.testng.annotations.AfterClass
    public static void afterClass() throws Exception{
        driver.quit();
    }
}

