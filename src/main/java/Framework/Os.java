package Framework;

import enums.Mobile;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;


import java.net.MalformedURLException;
import java.net.URL;

public class Os {
    private static String reportDirectory = "reports";
    private static String reportFormat = "xml";
    private static String testName = "Untitled";

    public static WebDriver getDriver(Mobile mobileOs) throws MalformedURLException {
        WebDriver driver = null;



        switch (mobileOs) {
            case IOS:
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability("reportDirectory", reportDirectory);
                dc.setCapability("reportFormat", reportFormat);
                dc.setCapability("testName", testName);
                dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
                dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.guzmanygomez.gyg");
                driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);



                break;


            case ANDROID:
                break;
            default:
                throw new RuntimeException("Unknown browser: " + mobileOs);
        }
        return driver;
    }
}