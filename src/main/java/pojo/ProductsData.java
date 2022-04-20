package pojo;

public class ProductsData {

    private String productName;
    private String imageURL;
    private String dollarPrice;
    private String poundPrice;
    private String euroPrice;

    public ProductsData(String productName, String _imageURL, String _dollarPrice, String _poundPrice, String _euroPrice) {
        this.productName = productName;
        this.imageURL = _imageURL;
        this.dollarPrice = _dollarPrice;
        this.poundPrice = _poundPrice;
        this.euroPrice = _euroPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDollarPrice() {
        return dollarPrice;
    }

    public void setDollarPrice(String dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public String getPoundPrice() {
        return poundPrice;
    }

    public void setPoundPrice(String poundPrice) {
        this.poundPrice = poundPrice;
    }

    public String getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(String euroPrice) {
        this.euroPrice = euroPrice;
    }


}