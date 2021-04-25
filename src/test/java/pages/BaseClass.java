package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {


    protected WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static void assertTitle(WebElement element, String excepted){
        String actual =   element.getText();
        System.out.println("Title is "+actual);
        Assert.assertEquals(actual,excepted,"Title mismatch!");
    }


    public static void assertElementIsEnable(WebElement element, String elementName){
        System.out.println(elementName + " is enabled ? "+ element.isEnabled());
        Assert.assertTrue(element.isEnabled(),"Element is not enabled!");
    }


    public static void assertElementIsDisplayed(WebElement element,String elementName){
        System.out.println(elementName + " is displayed ? "+ element.isDisplayed());
        Assert.assertTrue(element.isDisplayed(),"Element is not displayed!");
    }

    public static void sfAssertElementIsDisplayed(WebElement element,String elementName){
        System.out.println(elementName + " is displayed ? "+ element.isDisplayed());
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(element.isDisplayed(),"Element is not displayed!");
        sa.assertAll();
    }


    public static String getvalue(String key)  {
        String path = System.getProperty("user.dir")+ File.separator+"config.properties";
        String value= null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }


    public static void waitForElement(long sec){
        try {
            Thread.sleep(sec);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void alertAccept(WebDriver driver){
        Alert alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept(); // click on OK
    }

    public static void alertDismiss(WebDriver driver){
        Alert alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.dismiss(); // click on cancel
    }

    public static void alertAccept(WebDriver driver,String text){
        Alert alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.sendKeys(text);
        alt.accept(); // click on cancel
    }

    public static void mouseHover(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        //Mouse hover
        act.moveToElement(element).build().perform();
    }

    public static void click(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }
    public static void dragAndDrop(WebDriver driver, WebElement a, WebElement b){
        Actions act = new Actions(driver);
        act.dragAndDrop(a,b).build().perform();


    }


    public  static void scroll(WebDriver driver, WebElement element){
        JavascriptExecutor js  = (JavascriptExecutor) driver; // Typecasting to js
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


    public static void selectByVisibleTEXT( WebElement ele, String text) {
        Select sel = new Select(ele);
        sel.selectByVisibleText(text);

    }



    public static void selectByINDEX( WebElement ele, int index) {
        Select sel = new Select(ele);
        sel.selectByIndex(index);

    }



    public static void selectByVALUE( WebElement ele, String value) {
        Select sel = new Select(ele);
        sel.selectByValue(value);
    }


    public static void screenShot(WebDriver driver) throws IOException {

        TakesScreenshot scrShot = (TakesScreenshot) driver; // upcasting

        File src = scrShot.getScreenshotAs(OutputType.FILE);

        File dest = new File("./screenshot.gif");

        FileUtils.copyFile(src, dest);


    }

}
