import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;
import utils.ChromeRunner;
import static dataObjects.LoginData.*;
import static dataObjects.LoginData.password;


public class LoginTest extends ChromeRunner {
    MyAccountPage object = new MyAccountPage(driver);
    @Test
    public void validLogin() {
        checkURL();
        object.changeSiteLanguage();
        object.getLoginPage();
        object
                    .enterEmail(emailAddress)
                    .enterPassword(password)
                    .clickOnSignInButton(driver);

     String actualResult = object.myAccountButton.getText();
     Assert.assertEquals(actualResult, "My Account");

    }
}




