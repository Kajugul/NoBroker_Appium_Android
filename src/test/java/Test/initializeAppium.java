package Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class initializeAppium
{
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void init() throws MalformedURLException
    {
        DesiredCapabilities cab = new DesiredCapabilities();
        cab.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 5 pro");
        cab.setCapability(MobileCapabilityType.UDID, "ab01dcd");
        cab.setCapability("platformName", "Android");
        cab.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        cab.setCapability("appPackage", "com.nobroker.app");
        cab.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        cab.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
        cab.setCapability(MobileCapabilityType.NO_RESET, "true");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, cab);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void quitAppium() throws InterruptedException
    {

        if (driver != null)
        {
            locationOff();
            Thread.sleep(1000);
            driver.quit();
        }
        else
        {
            System.out.println("Driver is already closed.");
        }

    }

    private void locationOff()
    {
        ((AndroidDriver) driver).openNotifications();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Location Services']")).click();
    }

}
