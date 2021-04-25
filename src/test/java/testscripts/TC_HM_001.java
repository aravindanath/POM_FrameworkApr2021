package testscripts;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_HM_001 extends BaseTest{

    /**
     * TC_HM_001 : Verify productPage
     */


    @Test
    public void TC_HM_001(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyLogin("TC_PP_001");
        HomePage hp = new HomePage(driver);
        hp.navigateToProductMenu();


    }

}
