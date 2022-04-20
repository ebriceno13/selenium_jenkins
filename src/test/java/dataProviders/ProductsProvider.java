package dataProviders;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.ProductsData;
import pojo.SearchData;
import pojo.UserAccount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ProductsProvider {
    /*
    @DataProvider(name = "getProductsCurrencyData")
    private Object[][] getProductData(){
        return new Object[][]{
                {new ProductsData("MacBook","macbook_1-47x47.jpg", "602.00", "454.10", "518.16")},
                {new ProductsData("iPhone", "iphone_1-228x228.jpg", "123.20", "92.93", "106.04")},
                {new ProductsData("Apple Cinema 30\"", "apple_cinema_30-228x228.jpg", "110.00", "82.98", "94.68")},
                {new ProductsData("Samsung Galaxy Tab 10.1", "samsung_tab_1-228x228.jpg", "241.99", "182.54", "208.29")}
        };
    }
    */
    @DataProvider(name = "getProductsDataFromJson")
    private Object[][] getUsersDataFromJson() throws IOException {
        JsonElement jsonData = new JsonParser().parse(new FileReader(PropertiesFile.pfInstance().getProperty("productsFile")));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<ProductsData> testData = new Gson().fromJson(dataSet, new TypeToken<List<ProductsData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
