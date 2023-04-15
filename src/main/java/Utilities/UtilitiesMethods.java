package Utilities;

import org.openqa.selenium.WebElement;

public class UtilitiesMethods {

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterDataToInputField(WebElement element, String text) {
        element.sendKeys(text);
    }
    public void clearField(WebElement element) {
        element.clear();
    }
}
