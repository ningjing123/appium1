package basePage;

import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class DingdanPage extends BasePage {

    public DingdanPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.TextView[@text = '待出货']")
    private AndroidElement 商户订单_待出货;//我的-->商户订单-->待出货按钮

    public void 点击商户订单_待出货(){
        商户订单_待出货.click();
    }
}
