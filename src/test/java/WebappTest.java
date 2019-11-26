import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebappTest {
    public AndroidDriver driver;
    @BeforeClass
    public void setUp() throws Exception{
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "04157df41080541f");
        cap.setCapability("platformVersion", "4.4.2");
        cap.setCapability("browserName","Chrome");//与Android APP设置不同的地方
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void searchTest(){
        driver.get("https://www.m.baidu.com");
        driver.findElementById("word").sendKeys("夏天");
        driver.findElementById("index-bn").click();
    }




    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
