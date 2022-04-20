package selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {

    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        /**
        * opciones de navegacion
         * 1. search
         * 2. home add to cart ***
         * 3. home -> Product Page -> add to cart
         * 4. construir la URL
        * */

        //home.GoTo()
        //homePage.getFirstProductName()
        //homrPage.selectProductByName("Macbook")
        //Assertion validate page
        //productPage.clickclicckAddButton()
        //Assertion validate Success message
        //headerPage.clickCartButton()
        //Assertion validate amount of products

        int quantity = 5;
        String imageURL = "macbook_1-47x47.jpg";
        String name = homePage().selectFirstProductAndGetName();
        Assert.assertTrue(productPage().isTitleDisplayed(name));
        productPage().SetQuantity(quantity);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());
        headerPage().clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage().isProductRowDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductRowQuantity(), quantity, "Quantity is not matching");
        Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL), "Image is not the one expected");
    }

    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart(){
        homePage().selectProductByName("MacBook");
        productPage().SetQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().SetQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }


    //Caso 2 del proyecto
    /*
    *   Ir al sitio web.
        Buscar un producto (Macbook)
        Hacer click en el producto.
        Agregar el producto al carrito de compras.
        Verificar el mensaje de éxito.
        Ir al carrito de compras
        Verificar que el producto no se pueda agregar!
    * */
    @Description("Add a purchase order using search to find the product")
    @Test
    public void Test_Add_Purchase_From_Search(){
        String searchCriteria = "MacBook";
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);
        searchResultsPage().ClickOnProduct();
        productPage().SetQuantity(113);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAddedProductMessageDisplayed());
        headerPage().clickOnCartButton();
        shoppingCartPage().clickCheckoutButton();
        Assert.assertTrue(shoppingCartPage().isProductNotInStockMessageDisplayed());
    }
}
