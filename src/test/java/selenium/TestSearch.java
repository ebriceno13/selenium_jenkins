package selenium;


import dataProviders.SearchProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;

//esto es un comentario
public class TestSearch extends BaseClass {
    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        //Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expected %s results, but got %s",results.size()));

        Assert.assertEquals(getResults(), results,
                "Expecting " + expectedResult + " results, but got " + getResults());
    }

    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        //Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        //List<WebElement> results = driver.findElements(By.cssSelector(".product-thumb"));

        //Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expected %s results, but got %s",results.size()));

        Assert.assertEquals(getResults(), expectedResult,
                "Expecting " + expectedResult + " results, but got " + getResults());
    }

    public int getResults(){
        return driver.findElements(By.cssSelector(".product-thumb")).size();
    }


    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(testData.getSearchCriteria());

        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        if(testData.getExpectedResults() > 0){
            Assert.assertEquals(searchResultsPage().getResultsCount(), testData.getExpectedResults());
        }else{
            Assert.assertTrue(searchResultsPage().isNoResultsVisible());
        }
    }
}
