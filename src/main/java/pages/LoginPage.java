package pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import models.LoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driverLn) {
        {
            this.driver = driverLn;
        }

    }

    @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
    private WebElement loginInButton;

    @FindBy(how = How.ID, using = "com.guzmanygomez.gyg.uat:id/rf_edit_text")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/TextInputLayout/android.widget.FrameLayout/android.widget.EditText")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "com.guzmanygomez.gyg.uat:id/f_start_but_login")
    private WebElement loginButton;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_tv_text")
    private WebElement loginError;

    @FindBy (how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    private WebElement welcomeMessage;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_tv_text")
    private WebElement wrongLoginDialog;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_but_left")
    private WebElement wrongLoginDialogOk;

    @FindBy (how = How.XPATH, using = "//*[@text='Forgot Password?']")
    private WebElement forgotPasswordLink;

    @FindBy (how = How.XPATH, using = "//*[@text='Reset password']")
    private WebElement resetPasswordScreen;

    @FindBy (how = How.XPATH, using = "//*[@class='UIATextField']")
    private WebElement forgotPasswordEmailField;

    @FindBy (how = How.XPATH, using = "//*[@text='SUBMIT']")
    private WebElement submitButton;

    @FindBy (how = How.XPATH, using = "//*[@text='Error' and @class='UIAStaticText']")
    private WebElement wrongEmailDialog;

    @FindBy (how = How.XPATH, using = "//*[@class='UIAView' and @height>0 and ./*[@text='GYG' and @class='UIAStaticText']]")
    private WebElement existingEmailDialog;

    @FindBy (how = How.XPATH, using = "//*[@text='OK']")
    private WebElement existingEmailDialogOk;

    @FindBy (how = How.XPATH, using = "//*[@text='OK']")
    private WebElement wrongEmailDialogOkButton;
    //-----------------------------------------------------------------------------------------------


    public void LoginFlow(LoginModel model) throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='E-mail address']")));
        driver.findElement(By.xpath("//*[@placeholder='E-mail address']")).sendKeys("adytestare+2202d@gmail.com");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
        driver.findElement(By.xpath("//*[@placeholder='Password']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@text='Log In']")).click();


    }

    public void ForgotPassword(LoginModel model) throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,50);

        wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));
        forgotPasswordLink.click();
        wait.until(ExpectedConditions.visibilityOf(resetPasswordScreen));
        forgotPasswordEmailField.sendKeys(model.getBadEmail());
        ((MobileDriver)driver).hideKeyboard();
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(wrongEmailDialog));
        wrongEmailDialogOkButton.click();
        forgotPasswordEmailField.clear();

        forgotPasswordEmailField.sendKeys(model.getWrongEmail());
        ((MobileDriver)driver).hideKeyboard();
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(existingEmailDialog));
        wrongEmailDialogOkButton.click();

        forgotPasswordEmailField.clear();
        forgotPasswordEmailField.sendKeys(model.getEmailAddress());
        ((MobileDriver)driver).hideKeyboard();
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));

    }


}