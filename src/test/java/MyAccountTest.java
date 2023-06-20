import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utils.ChromeRunner;

import java.time.Duration;

import static dataObjects.LoginData.emailAddress;

import static dataObjects.LoginData.password;
import static dataObjects.MyAccountData.expectedText;
import static dataObjects.MyAccountData.expectedURL;

public class MyAccountTest extends ChromeRunner {
    MyAccountPage object1 = new MyAccountPage(driver);
    @Test
    public void subscribe() {
        object1.changeSiteLanguage();
        object1.getLoginPage();
        object1
                .enterEmail(emailAddress)
                .enterPassword(password);

        object1.clickOnSignInButton(driver);
        object1.goToMyAccountPage();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        object1
                .enterEmailAddress(emailAddress)
                .clickSubscribe(driver);
       js.executeScript("window.scrollBy(0,-500)");
       String actualText = object1.logoutButton.getText();
       Assert.assertEquals(actualText, expectedText);
       object1.logOut(driver);

    }
}
