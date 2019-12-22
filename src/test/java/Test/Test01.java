package Test;

import Utility.Constant;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test01 extends initializeAppium
{

    public FilterApply filterApply = null;
    public FilterResult result = null;

    @Test(priority = 0,description = "This is demonstration of no broker buy flat search.")
    public void selectBuyoptionAndFilters() throws InterruptedException
    {
        filterApply = new FilterApply(driver);

        Reporter.log("click on buy option");
        filterApply.clickOnBuy();
        Reporter.log("Buy option clicked successfully.");

        Reporter.log("Click on search icon");
        filterApply.clickOnSearchIcon();
        Reporter.log("Search icon clicked successfully.");

        Reporter.log("Select ["+Constant.CITY_MUMBAI+"] from drop down.");
        filterApply.selectCityMumbai();
        Reporter.log("City ["+Constant.CITY_MUMBAI+"] selected successfully.");

        Reporter.log("select Checkbox for near by properties");
        filterApply.selectIncludeNearByProperties();
        Reporter.log("Checkbox for near by properties selected successfully.");

        Reporter.log("Select room type ["+Constant.roomType.bhktwo+"] and ["+Constant.roomType.bhkthree+"]");
        filterApply.selectBedroomsType(Constant.roomType.bhktwo.toString());
        filterApply.selectBedroomsType(Constant.roomType.bhkthree.toString());
        Reporter.log("Room type selected successfully.");

        Reporter.log("Select ["+Constant.LOCATION_MALAD_EAST+"] and ["+Constant.LOCATION_MALAD_WEST+"] from the drop down.");
        filterApply.selectLocation(Constant.LOCATION_MALAD_EAST);
        filterApply.selectLocation(Constant.LOCATION_MALAD_WEST);
        Reporter.log("Location selected successfully.");

        Reporter.log("click on search button after filter apply.");
        result = filterApply.clickOnSearch();
        Reporter.log("Search button clicked after filter applied successfully.");

        Reporter.log("Select the 4th result from searched resultset");
        result.select4thResult();
        Reporter.log("4th result set selected successfully.");

        Reporter.log("verify that, description text and desciption area are present.");
        Assert.assertTrue(result.isDesciptionSectionIsPresent(),Constant.DESC_SEC_MESSAGE);
        Assert.assertTrue(result.isDesciptionAreaIsEmpty(),Constant.DESC_AREA_MESSAGE);
        Reporter.log("verified succesfully that, description text and desciption area are present.");

    }
}
