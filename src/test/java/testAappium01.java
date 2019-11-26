import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testAappium01 {
public AppiumDriver driver;
@BeforeClass//启动APP
    public void setUp() throws Exception {
    DesiredCapabilities cap = new DesiredCapabilities();
    //cap.setCapability("app","C:\\Users\\ning\\Desktop\\pconline1524673394580.apk");//从指定位置安装apk
    //cap.setCapability("fullReset","True");//卸载应用
    //cap.setCapability("noReset","True");//是否从新安装APK
   //cap.setCapability("noSign","True");//跳过重签名

    cap.setCapability("automationName", "Appium");//安卓4.2以上，默认使用appium引擎，不写也可以
    //capabilities.setCapability("automationName", "selendroid");//安卓4.2以下

    cap.setCapability("platformName","Android");
    cap.setCapability("deviceName","127.0.0.1:62001");
    cap.setCapability("platformVersion","4.4.2");

    //支持中文输入
    cap.setCapability("unicodeKeyboard","true");
    cap.setCapability("resetKeyboard","true");

    //严选
    //cap.setCapability("appPackage","com.netease.yanxuan");
    //cap.setCapability("appActivity","com.netease.yanxuan.module.splash.SplashActivity");

    //飞牛B2B
    cap.setCapability("appPackage","com.feiniu.b2b.develop");
    cap.setCapability("appActivity","com.fn.b2b.main.home.activity.HomeSplashActivity");


    // cap.setCapability("appWaitActivity", "com.netease.yanxuan/.module.mainpage.activity.MainPageActivity");
    //driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    driver.manage().timeouts().implicitlyWait(1500,TimeUnit.SECONDS);
}


    @Test
    public void fenlei() throws InterruptedException {

    driver.findElementById("com.netease.yanxuan:id/ll_home_search_view_container").click();
    driver.findElementById("com.netease.yanxuan:id/tv_home_search").sendKeys("苹果");
    Thread.sleep(3000);
       // driver.findElementByName("分类").isEnabled();
        //driver.swipe(360,1000,360,300,5000);//不能直接做滑动操作 要在前面做一些操作
       // driver.swipe(360,300,360,1000,5000);
        //左滑  右滑

        //获取屏幕的分辨率
//        int height = driver.manage().window().getSize().height;
//        int width = driver.manage().window().getSize().width;

        //driver.findElementById("com.netease.yanxuan:id/txt_mainpage_tab_title").click();
    //driver.findElementById("com.netease.yanxuan:id/img_goods").click();
//        driver.findElementByName("分类").click();
//        Thread.sleep(30000);
//        //driver.findElementByName("特色区").click();
//        Thread.sleep(3000);

        //driver.findElementById("com.netease.yanxuan.module.splash.SplashActivity").isEnabled();//是否可用
        /*driver.findElementById("com.netease.yanxuan.module.splash.SplashActivity").click();
        Thread.sleep(30000);
        driver.findElementById("com.netease.yanxuan:id/search_input").sendKeys("12345");
        Thread.sleep(1000);*/

        //driver.findElementByName("android.widget.ImageView").click();
       // List<> list = driver.findElementsByName("android.widget.ImageView");
       /* List<WebElement> imageView=driver.findElementsByClassName("android.widget.ImageView");
        imageView.get(1).click();
        System.out.println(driver.findElementByName("推荐").isSelected());
        Thread.sleep(10000);*/


       /*List<WebElement> ele = driver.findElementsByClassName("android.widget.TextView");
       for(int i = 0; i<ele.size();i++){
           System.out.println(ele.get(i).getText()+i);
          // System.out.println(ele.get(i).getSize().getHeight());
           //System.out.println(ele.get(i).getSize().getWidth());
       }
       Assert.assertEquals(ele.get(0).getText(),"扫一扫");*/
      // System.out.println( ele.get(0).getTagName());//获取的是className
       // System.out.println( ele.get(0).getAttribute("resourceId"));
       // System.out.println( ele.get(0).getAttribute("name"));
        //System.out.println( ele.get(0).getAttribute("text"));
       // System.out.println( ele.get(0).getAttribute("ClassName"));
        /*int x = ele.get(0).getLocation().getX();
        int y = ele.get(0).getLocation().getY();
        driver.tap(1,x,y,1);*/
        /*if((common.isExist((AndroidDriver) driver, By.name("扫一扫")))){

            System.out.println("元素存在");
        }else{
            System.out.println("元素不存在");
        };*/
       //System.out.println(ele.get(0).getText());
       // driver.findElementById("com.netease.yanxuan:id/txt_mainpage_tab_title").getText().


//              driver.findElementById("com.netease.yanxuan:id/ll_home_search_view_container").click();
//        driver.findElementById("com.netease.yanxuan:id/search_input").sendKeys("erwerw");
//        driver.findElementById("com.netease.yanxuan:id/search_input").clear();
//        Thread.sleep(5000);


    }



    @AfterTest//退出APP
    public void tearDown(){
    driver.quit();
    }



}
