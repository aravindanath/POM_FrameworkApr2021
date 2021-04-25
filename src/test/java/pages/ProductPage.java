package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaUtils;

import java.util.HashMap;
import java.util.List;

public class ProductPage extends BaseClass{


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "#SearchProductName")
    WebElement searchProoductTextField;

    @FindBy(id="search-products")
    WebElement searchProductButton;

    @FindAll(@FindBy(xpath = "//table[@id='products-grid']/tbody/tr/td[3]"))
    List<WebElement> productList;


    HashMap<String, String> pp;

    public void searchProductByName(String tciD){
        pp = JavaUtils.readExcelData("Products",tciD);
        searchProoductTextField.sendKeys(pp.get("PRODUCT"));
        searchProductButton.click();
    }

    public void verifyListOfProducts(){

        System.out.println("Total products are "+ productList.size());

        for(WebElement ele : productList){
            System.out.println(ele.getText());
        }


    }

    public void searchProduct(){
        searchProductButton.click();
    }


}
