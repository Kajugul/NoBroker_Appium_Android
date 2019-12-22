package Test;

import Utility.BaseAppiumMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class FilterApply extends BaseAppiumMethods
{

    public final AppiumDriver driver;

    public FilterApply(AppiumDriver<MobileElement> driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), FilterApply.class);
    }

    /**
     * This method is used to click on buy option button
     */
    public void clickOnBuy()
    {
        click(By.id("com.nobroker.app:id/buyLayoutText"));
    }

    /**
     * This method is used to click on search icon
     *
     * @throws InterruptedException
     */
    public void clickOnSearchIcon() throws InterruptedException
    {
        click(By.id("com.nobroker.app:id/locationImageHome"));
        wait(500);

        if (isElementPresent(By.id("com.google.android.gms:id/message")))
        {
            wait(500);
            click(By.xpath("//android.widget.Button[@text='OK']"));
            wait(500);
        }

    }

    /**
     * This method is used to select mumbai city.
     *
     * @throws InterruptedException
     */
    public void selectCityMumbai() throws InterruptedException
    {

        if (isElementPresent(By.id("com.nobroker.app:id/spinnergo")))
        {
            click(By.id("com.nobroker.app:id/spinnergo"));
            try
            {
                wait(500);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            click(By.xpath("//android.widget.CheckedTextView[@index='2']"));
        }
        else
        {
            System.out.println("Failed to find spinner drop down.");
        }
    }


    /**
     * This method is used to select location
     *
     * @param loc name of the location.
     * @throws InterruptedException
     */
    public void selectLocation(String loc) throws InterruptedException
    {
        // malad east
        driver.findElement(By.id("com.nobroker.app:id/localityAutoCompleteTxt")).sendKeys(loc);
        wait(1000);
        click(By.xpath("//android.widget.ImageView[@index='1']"));
        wait(1000);
    }

    /**
     * This method is used to click on check of near by properties.
     */
    public void selectIncludeNearByProperties()
    {
        click(By.id("com.nobroker.app:id/nearByRadio"));
    }

    /**
     * This method is used to click on bedroom type
     *
     * @param roomtype type of room
     */
    public void selectBedroomsType(String roomtype)
    {
        click(By.id("com.nobroker.app:id/" + roomtype + ""));
    }

    /**
     * This method is used to click on search button.
     *
     * @return filter result class
     * @throws InterruptedException
     */
    public FilterResult clickOnSearch() throws InterruptedException
    {
        wait(500);
        click(By.xpath("//android.widget.Button[@text='SEARCH']"));
        wait(4000);
        return new FilterResult(driver);
    }
}
