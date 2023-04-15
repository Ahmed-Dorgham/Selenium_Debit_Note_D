package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class HomePage extends UtilitiesMethods {
    private WebDriver driver ;
    private WebDriverWait wait;
    private WebElement assertItem ;
    private WebElement salesAnchor;
    private WebElement debitNote;
    private JavascriptExecutor js;

    public HomePage (WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement getWebElement() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        assertItem = driver.findElement(By.xpath
                ("//div[contains(@class ,'dashboard-header')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[contains(@class ,'dashboard-header')]")));
        wait.until(ExpectedConditions.visibilityOf(assertItem));
        return assertItem;
    }
    public DebitNoteListPage openDebitNotesPage() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        salesAnchor = driver.findElement(By.id("module-anchor-Selling"));
        js.executeScript("arguments[0].click();", salesAnchor);
        // clickOnButton(salesAnchor);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-selling-debit-note")));
        debitNote = driver.findElement(By.id("sidebar-selling-debit-note"));
        js.executeScript("arguments[0].click();", debitNote);
        //clickOnButton(debitNote);
        return new DebitNoteListPage(driver);
    }
}
