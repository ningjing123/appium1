package basePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import utils.common;

//店管家的登陆页面

public class LoginPage extends BasePage{
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }


    @FindBy(id = "com.feiniu.bdtool:id/et_login_account_input")
    private AndroidElement username;//用户名输入框

    @FindBy(id = "com.feiniu.bdtool:id/et_login_password_input")
    private AndroidElement password;//密码输入框

    @FindBy(id = "com.feiniu.bdtool:id/tv_login_btn")
    private AndroidElement loginButton;//登陆按钮

    @FindBy(id = "com.feiniu.bdtool:id/tv_refuse")
    private AndroidElement 隐私政策1_不同意;//隐私政策第一个弹框的不同意按钮

    @FindBy(xpath = "//android.widget.TextView[@text ='退出应用']")
    private AndroidElement 隐私政策3_退出应用;//隐私政策第三个弹框上的退出应用按钮

    @FindBy(xpath = "//android.widget.TextView[@text ='再次查看']")
    private AndroidElement 隐私政策3_再次查看;//隐私政策第三个弹框上的再次查看按钮

    @FindBy(xpath = "//android.widget.TextView[@text = '温馨提示']")
    private AndroidElement 隐私政策1_温馨提示标题;//银色政策弹框1上的标题

    @FindBy(id = "com.feiniu.bdtool:id/tv_browse")
    private AndroidElement 隐私政策2_查看协议;

    @FindBy(id = "com.feiniu.bdtool:id/tv_agree")
    private AndroidElement 隐私政策1_同意;

    public void 点击隐私政策1_同意(){
        隐私政策1_同意.click();
    }

    public void 点击隐私政策2_查看协议(){
        隐私政策2_查看协议.click();
    }

    public String 温馨提示标题(){
        return 隐私政策1_温馨提示标题.getText();
    }

    public void 点击隐私政策3_再次查看(){
        隐私政策3_再次查看.click();
    }

    public void 点击隐私政策3_退出应用(){
        隐私政策3_退出应用.click();
    }

    public void 点击隐私政策1_不同意(){
        隐私政策1_不同意.click();
    }

    public void login(String name,String pw){
        username.sendKeys(name);
        password.sendKeys(pw);
        loginButton.click();
    }


}
