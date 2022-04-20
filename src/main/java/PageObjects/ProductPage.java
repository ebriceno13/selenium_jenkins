package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    //Elementos
    public String ProductTitleSelector = "//h1[text()='<name>']";
    public  By ProductQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By AlertSuccess = By.cssSelector(".alert-success");
    public By AddedProductMessageSelector = By.cssSelector(".alert-dismissible");
    public By PriceSelector = By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");
    private By imageSelector = By.cssSelector("img");

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>", name))).isDisplayed();
    }

    public void SetQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }

    public String GetPrice(){
        String price = driver.findElement(PriceSelector).getText().replace("$","").replace("€", "").replace("£","");
        System.out.println("El precio es: " + price);
        return price;
    }

    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

    public boolean isAddedProductMessageDisplayed(){
        return driver.findElement(AddedProductMessageSelector).isDisplayed();
    }

}
