package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.JavaUtils;

import java.util.HashMap;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

// Object repo

    @FindBy(xpath = "//h1[text()='Admin area demo']")
    WebElement pageTitle;

    @FindBy(xpath = "//strong[text()='Welcome, please sign in!']")
    WebElement welcomeTitle;

    @FindBy(id = "Email" )
    WebElement emailTextField;

    @FindBy(css = "#Password")
    WebElement passwordTextField;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashboardText;



    HashMap<String, String> lp;


    // Business Logic

    public void verifyLoginPage(){
        assertTitle(pageTitle,"Admin area demo");
        assertTitle(welcomeTitle,"Welcome, please sign in!");
        assertElementIsEnable(emailTextField,"EmailTextField");
        assertElementIsEnable(passwordTextField,"Password Text Field");
        assertElementIsEnable(loginButton,"Login button");
        System.out.println("Page title is: "+driver.getTitle());
    }

    public void verifyLogin(String tcID){
        lp = JavaUtils.readExcelData("Login",tcID);
        emailTextField.clear();
        emailTextField.sendKeys(lp.get("USERNAME"));
        passwordTextField.clear();
        passwordTextField.sendKeys(lp.get("PASSWORD"));
        loginButton.click();
        assertTitle(dashboardText,"Dashboard");
    }



}
