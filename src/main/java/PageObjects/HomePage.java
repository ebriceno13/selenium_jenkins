package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    //private By searchBarSelector = By.cssSelector(".input-group");
    //private By searchButtonSelector = By.cssSelector(".input-group-btn");

    public HomePage(WebDriver _driver){
         super(_driver);
    }



    public String getFirstProductName(){
        return driver.findElement(HomePageLocators.FirstProductTitleSelector).getText();
    }
    public void selectProductByName(String name){
        driver.findElement(By.xpath(HomePageLocators.FirstH4Locator.replace("<name>", name))).click();
    }
    public String selectFirstProductAndGetName(){
        String name = getFirstProductName();
        selectProductByName(name);
        return name;
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnYourStoreButton();
    }

    //public void FillSearchBar(String product){
        //driver.findElement(searchBarSelector).sendKeys(product);
        //driver.findElement(searchButtonSelector).click();
    //}
}
