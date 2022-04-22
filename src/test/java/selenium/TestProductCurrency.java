package selenium;

import com.google.gson.JsonObject;
import dataProviders.ProductsProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ProductsData;

//esto es un comment
public class TestProductCurrency extends BaseClass{
/*
    Caso 3 del Proyecto
    Dado un json con productos y precios en distintas monedas.
    Ir a la página del producto.
    Verificar el precio de cada producto en las distintas monedas.
*/
    @Description("Verificar el precio de un producto en las distintas monedas.")
    @Test(dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsProvider.class)
    public void Test_Currency(ProductsData testProducts) {

        /*
        System.out.println(testProducts.getDollarPrice());
        System.out.println(testProducts.getEuroPrice());
        System.out.println(testProducts.getPoundPrice());
        System.out.println(testProducts.getProductName());
         */
        String productName = testProducts.getProductName();
        String imageURL = testProducts.getImageURL();
        String dollarPrice = testProducts.getDollarPrice();
        String poundPrice = testProducts.getPoundPrice();
        String euroPrice = testProducts.getEuroPrice();
        headerPage().fillSearchBar(productName);
        WebElement productLink = driver.findElement(By.linkText(productName));
        productLink.click();
        headerPage().clickCurrencyButton();
        //WebElement clicker = driver.findElement(By.cssSelector("#form-currency [data-toggle='dropdown']"));
        //clicker.click();
        headerPage().clickDollarCurrencyButton();
        //WebElement clicker2 = driver.findElement(By.cssSelector("[name='USD']"));
        //clicker2.click();
        String productDollarPrice = productPage().GetPrice();
        Assert.assertEquals(productDollarPrice, dollarPrice);
        //clicker.click();
        //WebElement clicker3 = driver.findElement(By.cssSelector("[name='EUR']"));
        //clicker3.click();
        headerPage().clickCurrencyButton();
        headerPage().clickEuroCurrencyButton();
        String productEuroPrice = productPage().GetPrice();
        Assert.assertEquals(productEuroPrice, euroPrice);
        //clicker.click();
        //WebElement clicker4 = driver.findElement(By.cssSelector("[name='GBP']"));
       //clicker4.click();
        headerPage().clickCurrencyButton();
        headerPage().clickPoundCurrencyButton();
        String productPoundPrice = productPage().GetPrice();
        Assert.assertEquals(productPoundPrice, poundPrice);
    }
}
