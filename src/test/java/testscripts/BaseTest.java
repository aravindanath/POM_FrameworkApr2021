package testscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.BaseClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(BaseClass.getvalue("url"));
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

}
