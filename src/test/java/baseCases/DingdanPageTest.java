package baseCases;

import baseAndroidTest.baseAndroid;
import basePage.ShouyePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.common;

public class DingdanPageTest extends baseAndroid {
    //@BeforeMethod
    public void login(){
        common.denglu(driver,"ydzf01","zf12345");
    }

    @Test
    public void test1(){
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"请输入账号\")").sendKeys("ydzf01");
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.feiniu.bdtool:id/et_login_password_input\")").sendKeys("zf12345");
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"登\")").click();
        ShouyePage shoyepage = new ShouyePage(driver);
        shoyepage.点击首页_我的();

    }
}
