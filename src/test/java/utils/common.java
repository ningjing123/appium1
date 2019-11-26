package utils;

import basePage.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class common {
    //判断元素是否存在
    public static boolean isExist(AndroidDriver driver, By selector){
        try{
        driver.findElement(selector);
        return true;
        }catch(Exception e){
            return false;
        }
    }

    //元素的点击
    public static void toClick(AndroidElement element){
        element.click();
    }

    //输入文字
    public  static  void toInput(AndroidElement element, String input){
        element.sendKeys(input);
    }

    //隐式等待
    public static void implicitWait(AndroidElement element,AndroidDriver driver){
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
    }

    //登陆
    public static void denglu(AndroidDriver driver,String name,String pw){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(name,pw);
    }

    /**
     * 断言页面包含某个的元素
     */
    public void assertContain(String text,AndroidDriver driver) throws InterruptedException {
        String pagesource = driver.getPageSource();
        if (pagesource.contains(text)){
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(true);
        }
    }

    /**
     * 断言页面包含element
     * by:元素
     */
    public void assertContainBy(By by,AndroidDriver driver){
        if (driver.findElements(by).size() > 0){
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(true);
        }
    }


}
