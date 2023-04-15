package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends UtilitiesMethods {

    private WebDriver driver;
    private WebElement emailIdField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage loginWithValidData(String emailID, String password) {
        emailIdField = driver.findElement(By.id("login_id"));
        passwordField = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.id("login_btn"));
        emailIdField.clear();
        passwordField.clear();
        enterDataToInputField(emailIdField, emailID);
        enterDataToInputField(passwordField, password);
        clickOnElement(loginButton);
        return new HomePage(driver);
    }
}
