package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class DebitNoteListPage extends UtilitiesMethods {
    private WebDriver driver ;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private WebElement assertItem;
    private WebElement newButton;

    public DebitNoteListPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement getSalesInvoicesListElement() {
        wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة اشعار اضافة')]")));
        assertItem = driver.findElement(By.xpath
                ("//h5[contains(text(),'قائمة اشعار اضافة')]"));
        return assertItem;
    }
    public DebitNotePage openNewDebitNote() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='appframe-btn-جديد']")));
        newButton = driver.findElement(By.id("appframe-btn-جديد"));
        //clickOnButton(newButton);
        js.executeScript("arguments[0].click();", newButton);
        return new DebitNotePage(driver);
    }
}
