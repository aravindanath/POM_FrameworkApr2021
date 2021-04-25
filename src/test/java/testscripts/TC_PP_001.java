package testscripts;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class TC_PP_001 extends BaseTest{

    /**
     * TC_HM_003 : Verify search funcnalti on product page
     */


    @Test
    public void TC_PP_001(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyLogin("TC_PP_001");
        HomePage hp = new HomePage(driver);
        hp.navigateToProductMenu();
        ProductPage pp = new ProductPage(driver);
        pp.searchProductByName("TC_PP_001" );
        pp.verifyListOfProducts();


    }

}
