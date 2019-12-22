package Test;

import Utility.BaseAppiumMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class FilterResult extends BaseAppiumMethods
{

    public final AppiumDriver driver;

    public FilterResult(AppiumDriver<MobileElement> driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method will click on 4th result set.
     */
    public void select4thResult() throws InterruptedException
    {
        scrollDown(1, 0);

        if (isElementPresent(By.id("com.nobroker.app:id/property_seen")))
        {
            click(By.xpath("//android.widget.TextView[@text='Omkar Alta Monte Tower C, Kokanipada, Malad East, Mumbai, Maharashtra 400097, India, Malad East']"));
            wait(500);
        }
    }

    /**
     * This method is used to validate the, description section present or not.
     *
     * @return true
     */
    public boolean isDesciptionSectionIsPresent()
    {
        scrollDown(1, 2);
        if (driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).isDisplayed())
        {
            return true;
        }
        return false;
    }

    /**
     * This method is used to validate that, description is not blank.
     *
     * @return true.
     */
    public boolean isDesciptionAreaIsEmpty() throws InterruptedException
    {
        if (isElementPresent(By.id("com.nobroker.app:id/description")))
        {
            return true;
        }
        return false;
    }
}
