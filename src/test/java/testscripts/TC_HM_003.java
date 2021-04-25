package testscripts;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class TC_HM_003 extends BaseTest{

    /**
     * TC_HM_003 : Verify productPage with list of products
     */


    @Test
    public void TC_HM_003(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyLogin("TC_PP_001");
        HomePage hp = new HomePage(driver);
        hp.navigateToProductMenu();
        ProductPage pp = new ProductPage(driver);
        pp.searchProduct();
        pp.verifyListOfProducts();


    }

}
