package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test extends TestBase {
    String emailID = "Administrator";
    String password = "123456789";
    private HomePage homePageObject;
    private LoginPage loginPageObject;

    @Test
    private void loginWithValidData() {
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.loginWithValidData(emailID, password);
        Assert.assertTrue(homePageObject.getWebElement().isDisplayed());

    }
}
