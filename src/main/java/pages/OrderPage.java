package pages;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import models.LoginModel;
import org.apache.tools.ant.taskdefs.Touch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;

import static org.testng.Assert.*;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driverLn) {
        {
            this.driver = driverLn;
        }

    }



    @FindBy (how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    private WebElement welcomeMessage;

    @FindBy (how = How.ID, using = "ORDER")
    private WebElement homeScreenOrderButton;

    @FindBy (how = How.ID, using = "Choose a Guzman y Gomez")
    private WebElement chooseGygScreen;

    @FindBy (how = How.ID, using = "Search by name")
    private WebElement searchGygField;

    @FindBy (how = How.XPATH, using = "//*[@class='UIAStaticText' and (./preceding-sibling::* | ./following-sibling::*)[@accessibilityLabel='GyG-logo-faces']]")
    private WebElement searchGygFieldFirstResult;

    @FindBy (how = How.ID, using = "Order a Meal")
    private WebElement orderMealScreen;

    @FindBy (how = How.ID, using = "Burrito Bowls")
    private WebElement burritoBowls;

    @FindBy (how = How.ID, using = "Grilled Chicken")
    private WebElement grilledChicken;

    @FindBy (how = How.ID, using = "NEXT")
    private WebElement nextButton1;

    @FindBy (how = How.ID, using = "Guacamole")
    private WebElement guacamole;

    @FindBy (how = How.ID, using = "Large + $5.5")
    private WebElement largeButton;

    @FindBy (how = How.ID, using = "+")
    private WebElement guacamolePlus;

    @FindBy (how = How.ID, using = "SAVE")
    private WebElement saveButton;

    @FindBy (how = How.ID, using = "NEXT")
    private WebElement nextButton2;

    @FindBy (how = How.ID, using = "GO TO CART")
    private WebElement goToCartButton;

    @FindBy (how = How.ID, using = "ADD & PAY")
    private WebElement addPay;

    @FindBy (how = How.XPATH, using = "//*[@class='UIAButton' and (./preceding-sibling::* | ./following-sibling::*)[@accessibilityLabel='BG'] and ./parent::*[@class='UIAView']]")
    private WebElement payment;

    @FindBy (how = How.ID, using = "PayPal")
    private WebElement payPall;

    @FindBy (how = How.ID, using = "Success")
    private WebElement successScreen;
    //-----------------------------------------------------------------------------------------------



    public void AddProductToCart(String storeName) throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOf(homeScreenOrderButton));
        homeScreenOrderButton.click();
        wait.until(ExpectedConditions.visibilityOf(chooseGygScreen));
        searchGygField.sendKeys(storeName);
        //wait.until(ExpectedConditions.visibilityOf(searchGygFieldFirstResult));
        //searchGygFieldFirstResult.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='"+storeName+"' and @class='UIAStaticText']"))));
        driver.findElement(By.xpath("//*[@text='"+storeName+"' and @class='UIAStaticText']")).click();
        wait.until(ExpectedConditions.visibilityOf(orderMealScreen));
        burritoBowls.click();
        wait.until(ExpectedConditions.visibilityOf(grilledChicken));
        grilledChicken.click();
        nextButton1.click();
        wait.until(ExpectedConditions.visibilityOf(guacamole));
        guacamole.click();
        wait.until(ExpectedConditions.visibilityOf(largeButton));
        largeButton.click();
        guacamolePlus.click();
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(nextButton2));
        nextButton2.click();
        wait.until(ExpectedConditions.visibilityOf(goToCartButton));
        goToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(addPay));
        addPay.click();
        wait.until(ExpectedConditions.visibilityOf(payment));
        payment.click();
        //Thread.sleep(3000);
        //TouchAction touch = new TouchAction<>((PerformsTouchActions) driver);
        //touch.press(PointOption.point(0,1244)).perform();
        wait.until(ExpectedConditions.visibilityOf(payPall));
        payPall.click();
        wait.until(ExpectedConditions.visibilityOf(successScreen));



    }

    public void CheckChurosScenario(String storeName) throws InterruptedException {

    }


    public void reorder(String storeName) throws InterruptedException {


    }

    public void changeRestaurantOrder(String storeName,String changeRestaurant) throws InterruptedException {


    }


    public void reorderChangeRestaurantOrder(String storeName,String changeRestaurant) throws InterruptedException {


    }

    public void reorderRecentOrder(String storeName) throws InterruptedException {


    }
}