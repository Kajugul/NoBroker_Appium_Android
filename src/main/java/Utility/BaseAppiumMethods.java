package Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Set;

public class BaseAppiumMethods
{

    public final AppiumDriver driver;

    public BaseAppiumMethods(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
    }

    /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     */
    public Boolean isElementPresent(By targetElement) throws InterruptedException
    {
        Boolean isPresent = driver.findElements(targetElement).size() > 0;
        return isPresent;
    }

    /**
     * method to get all the context handles at particular screen
     */
    public void getContext()
    {
        ((AppiumDriver) driver).getContextHandles();
    }
    
    /**
     * method to click on Element By Name
     *
     * @param locator - String element to be clicked
     */
    public void click(By locator)
    {
        driver.findElement(locator).click();
    }

    /**
     * method to scroll down on screen from java-client 6
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollDown(int swipeTimes, int durationForSwipe)
    {
        Dimension dimension = driver.manage().window().getSize();

        for (int i = 0; i <= swipeTimes; i++)
        {
            int start = (int) (dimension.getHeight() * 0.8);
            int end = (int) (dimension.getHeight() * 0.21);
            int x = (int) (dimension.getWidth() /2.2);


            new TouchAction((AppiumDriver) driver)
                    .press(PointOption.point(x, start))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durationForSwipe)))
                    .moveTo(PointOption.point(x, end)).release().perform();
        }
    }

    /**
     * wait only
     * @param milliSeconds
     * @throws InterruptedException
     */
    public void wait(int milliSeconds) throws InterruptedException
    {
        Thread.sleep(milliSeconds);
    }

}

