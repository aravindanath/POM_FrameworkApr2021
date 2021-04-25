package testscripts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_LGN_001 extends BaseTest{

    /**
     * TC_LGN_001 : Verify login page elements
     */


    @Test
    public void TC_LGN_001(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyLoginPage();

    }

}
