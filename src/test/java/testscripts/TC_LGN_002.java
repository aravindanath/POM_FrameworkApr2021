package testscripts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_LGN_002 extends BaseTest{

    /**
     * TC_LGN_002 : Verify login
     */


    @Test
    public void TC_LGN_002(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyLoginPage();
        lp.verifyLogin("TC_PP_001");


    }

}
