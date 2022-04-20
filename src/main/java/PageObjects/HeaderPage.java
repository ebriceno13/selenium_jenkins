package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {


    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By yourStoreButtonLocator = By.linkText("Your Store");
    private By currencyButtonLocator = By.cssSelector("#form-currency [data-toggle='dropdown']");
    private By selectEuroCurrencyLocator = By.cssSelector("[name='EUR']");
    private By selectPoundCurrencyLocator = By.cssSelector("[name='GBP']");
    private By selectDollarCurrencyLocator = By.cssSelector("[name='USD']");
    private By searchBarLocator = By.name("Search");

    public HeaderPage(WebDriver _driver){
        super(_driver);
    }

    public void clickOnMyAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLinkLocator)).click();
    }
    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }
    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }
    public void clickOnYourStoreButton() {driver.findElement(yourStoreButtonLocator).click();}
    public void clickCurrencyButton() {driver.findElement(this.currencyButtonLocator).click();}
    public void clickEuroCurrencyButton() {driver.findElement(this.selectEuroCurrencyLocator).click();}
    public void clickPoundCurrencyButton() {driver.findElement(this.selectPoundCurrencyLocator).click();}
    public void clickDollarCurrencyButton() {driver.findElement(this.selectDollarCurrencyLocator).click();}
    public void fillSearchBar(String productName){
        WebElement webElement1 = driver.findElement(By.cssSelector("#search input"));
        webElement1.sendKeys(productName, Keys.ENTER);
    }
}
