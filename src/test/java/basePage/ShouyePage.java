package basePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShouyePage extends BasePage {
    public ShouyePage(AndroidDriver driver) {
        super(driver);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '店管家']")
    public  AndroidElement 首页_标题;//首页标题

    @FindBy(id = "com.feiniu.bdtool:id/iv_main_tab")
    private AndroidElement 首页_我的;//首页底栏 我的按钮

    public void 点击首页_我的(){
        首页_我的.click();
    }

    public String 获取首页_标题(){
        return  首页_标题.getText();
    }






}
