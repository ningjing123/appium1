package baseCases;

import baseAndroidTest.baseAndroid;
import basePage.LoginPage;
import basePage.ShouyePage;
import com.google.common.collect.ImmutableMap;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.common;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.Matchers.*;

public class LoginTest extends baseAndroid {
    LoginPage loginPage;
    ShouyePage shouyepage;


    @Test
    public void test01() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login("ydzf01","zf12345");
        //System.out.println(driver.getContext());//获取正在运行的当前上下文
        //driver.closeApp();//关闭APP
        //Thread.sleep(300);
        //driver.lockDevice();//锁屏操作
        //driver.unlockDevice();
        //driver.removeApp("com.feiniu.bdtool");//删掉APP
        //driver.installApp("C:\\Users\\ning\\Desktop\\app-B2BStoreManager-release(7).apk");//安装app
        //System.out.println(driver.getOrientation());;
        //driver.rotate(ScreenOrientation.LANDSCAPE);
        //driver.switchTo().parentFrame();
        //driver.executeScript("mobile:batteryInfo");
        //byte[] fileBase64 = driver.pullFile("C:\\Users\\ning\\Desktop\\online账号.txt");
       // driver.switchTo().activeElement();
        Thread.sleep(2000);
        driver.openNotifications();//打开通知
        //driver.findElementByAccessibilityId("String");//对应的是contentDescription的属性值
        driver.longPressKeyCode(4);
        driver.executeScript("","");

    }

    @Test//隐私政策：不同意--->不同意--->退出应用  app退出
    public void test02() throws InterruptedException, IOException {
        driver.removeApp("com.feiniu.bdtool");
        driver.installApp("C:\\Users\\ning\\Desktop\\app-B2BStoreManager-release(7).apk");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        //driver.executeScript("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        loginPage = new LoginPage(driver);
        loginPage.点击隐私政策1_不同意();
        loginPage.点击隐私政策1_不同意();//点击页面2上的仍不同意按钮
        loginPage.点击隐私政策3_退出应用();//此处注意安卓appium的text定位方式的书写
        Assert.assertEquals( driver.currentActivity(),null);
    }

    @Test//隐私政策：不同意--->不同意--->再次查看  回到第一个弹框页面
    public void test03() throws InterruptedException, IOException {
        driver.removeApp("com.feiniu.bdtool");
        driver.installApp("C:\\Users\\ning\\Desktop\\app-B2BStoreManager-release(7).apk");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        //driver.executeScript("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        loginPage = new LoginPage(driver);
        loginPage.点击隐私政策1_不同意();
        loginPage.点击隐私政策1_不同意();//点击页面2上的仍不同意按钮
        loginPage.点击隐私政策3_再次查看();//此处注意安卓appium的text定位方式的书写
        Assert.assertEquals(loginPage.温馨提示标题(),"温馨提示");//回到了第一个弹框页面
    }

    @Test//隐私政策：不同意--->查看协议---->  回到第一个弹框页面
    public void test04() throws InterruptedException, IOException {
        driver.removeApp("com.feiniu.bdtool");
        driver.installApp("C:\\Users\\ning\\Desktop\\app-B2BStoreManager-release(7).apk");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        //driver.executeScript("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        loginPage = new LoginPage(driver);
        loginPage.点击隐私政策1_不同意();
        loginPage.点击隐私政策2_查看协议();//点击页面2上的仍不同意按钮
        Assert.assertEquals(loginPage.温馨提示标题(),"温馨提示");//回到了第一个弹框页面
    }

    @Test//隐私政策：同意-->首页，第二次开启不会弹框提示
    public void test05() throws InterruptedException, IOException {
        shouyepage = new ShouyePage(driver);
        driver.removeApp("com.feiniu.bdtool");
        driver.installApp("C:\\Users\\ning\\Desktop\\app-B2BStoreManager-release(7).apk");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        //driver.executeScript("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        loginPage = new LoginPage(driver);
        loginPage.点击隐私政策1_同意();
        common.denglu(driver,"ydzf01","zf12345");
        Thread.sleep(1000);
        Assert.assertEquals(shouyepage.获取首页_标题(),"店管家");//点击同意，进入首页

        driver.closeApp();
        Runtime.getRuntime().exec("adb shell am start -W -a –n  com.feiniu.bdtool/.EnterActivity");
        //Assert.assertEquals(shouyepage.获取首页_标题(),"店管家");//再次启动，直接进入首页
        MatcherAssert.assertThat(shouyepage.获取首页_标题(),equals("店管家"));
        MatcherAssert.assertThat("",equalToIgnoringCase("") );
        //MatcherAssert.assertThat("",containsString(""), endsWith(""), startsWith(""));
        //MatcherAssert.assertThat(2,closeTo("2"));
    }



}
