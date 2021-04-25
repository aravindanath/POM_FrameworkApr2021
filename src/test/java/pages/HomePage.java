package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  extends BaseClass{


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//p[contains(text(),' Dashboard')]")
    WebElement dashboard;

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[2]/a/p")
    WebElement catlog;

    @FindBy(xpath = "//p[contains(text(),' Products')]")
    WebElement products;


    public void navigateToProductMenu(){
        BaseClass.click(driver,catlog);

        waitForElement(3000);
        BaseClass.click(driver,products);
    }



}
