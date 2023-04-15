package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class DebitNotePage extends UtilitiesMethods {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private WebElement fromSalesInvoiceButton;
    private WebElement listOfSalesInvoices;
    private WebElement getButton;
    private WebElement selectedSalesInvoice;
    private WebElement reasonField;
    private WebElement saveButton;
    private WebElement closeIcon;
    private WebElement save_submitButton;
    private WebElement submitButton;
    private WebElement yesButton;
    private WebElement debitNoteName;
    private WebElement selectedSalesInvoiceForAseerstion;
    private List<WebElement> salesInvoices;

    public DebitNotePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getSalesInvoices() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(10));
        // Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("appframe-btn-من فاتورة مبيعات")));
        fromSalesInvoiceButton = driver.findElement(By.id
                ("appframe-btn-من فاتورة مبيعات"));
        js.executeScript("arguments[0].click();", fromSalesInvoiceButton);

        //   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
        //  ("(//ul[@class='ui-autocomplete ui-front scroll-styler ui-menu ui-widget ui-widget-content ui-corner-all'])[24]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div//div//div//div[@class='clearfix modal-body ui-front']/ul)[1]")));

        //   listOfSalesInvoices = driver.findElement(By.xpath
        //         ("(//ul[@class='ui-autocomplete ui-front scroll-styler ui-menu ui-widget ui-widget-content ui-corner-all'])[24]"));
        listOfSalesInvoices = driver.findElement(By.xpath
                ("(//div//div//div//div[@class='clearfix modal-body ui-front']/ul)[1]"));

        salesInvoices = listOfSalesInvoices.findElements(By.tagName("span"));

    }

    public WebElement getSelectedSalesInvoiceName() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //  listOfSalesInvoices = driver.findElement(By.xpath
        // ("(//ul[@class='ui-autocomplete ui-front scroll-styler ui-menu ui-widget ui-widget-content ui-corner-all'])[24]"));
        listOfSalesInvoices = driver.findElement(By.xpath
                ("(//div//div//div//div[@class='clearfix modal-body ui-front']/ul)[1]"));
        salesInvoices = listOfSalesInvoices.findElements(By.tagName("span"));
        return salesInvoices.get(0);
    }

    public void selectSalesInvoice() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(10));
        clickOnElement(salesInvoices.get(0));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("Button-الحصول_على")));
        getButton = driver.findElement(By.id("Button-الحصول_على"));
        clickOnElement(getButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='control-value like-disabled-input']//a[contains(@href,'#Form/Sales Invoice/')]")));
    }

    public WebElement getSelectedSalesInvoiceForAssertion() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='control-value like-disabled-input']//a[contains(@href,'#Form/Sales Invoice/')]")));
        selectedSalesInvoiceForAseerstion = driver.findElement(By.xpath
                ("//div[@class='control-value like-disabled-input']//a[contains(@href,'#Form/Sales Invoice/')]"));
        System.out.println(selectedSalesInvoiceForAseerstion.getText());
        return selectedSalesInvoiceForAseerstion;
    }

    public void writeReason() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        reasonField = driver.findElement(By.xpath("//input[@data-fieldname='reason']"));
        enterDataToInputField(reasonField, "reason");
        js.executeScript("window.scrollBy(0,-1000)");
    }

    public void saveDebitNote() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        saveButton = driver.findElement(By.xpath("//button[@id='appframe-btn-حفظ']//i"));

        //  clickOnElement(saveButton);
        js.executeScript("arguments[0].click();", saveButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class='btn btn-info btn-yes']")));
        yesButton = driver.findElement(By.xpath("//button[@class='btn btn-info btn-yes']"));
        js.executeScript("arguments[0].click();", yesButton);

    }
    public void submitAfterSavingDebitNote() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//button[@id='appframe-btn-اعتماد'])[2]")));

        submitButton = driver.findElement(By.xpath("(//button[@id='appframe-btn-اعتماد'])[2]//i"));
        js.executeScript("arguments[0].click();", submitButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class='btn btn-info btn-yes']")));
       yesButton = driver.findElement(By.xpath("//button[@class='btn btn-info btn-yes']"));
        js.executeScript("arguments[0].click();", yesButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
               ("//button[@class='btn btn-info btn-yes']")));
        yesButton = driver.findElement(By.xpath("//button[@class='btn btn-info btn-yes']"));
        js.executeScript("arguments[0].click();", yesButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'×')])[6]")));
        closeIcon = driver.findElement(By.xpath("(//a[contains(text(),'×')])[6]"));

        js.executeScript("arguments[0].click();", closeIcon);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'×')])[5]")));
        closeIcon = driver.findElement(By.xpath("(//a[contains(text(),'×')])[5]"));
        js.executeScript("arguments[0].click();", closeIcon);

    }
    public void saveAndSubmitDebitNote() {
        save_submitButton = driver.findElement(By.xpath("//button[@id='appframe-btn-حفظ و اعتماد']"));
        js.executeScript("arguments[0].click();", save_submitButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class='btn btn-info btn-yes']")));
        yesButton = driver.findElement(By.xpath("//button[@class='btn btn-info btn-yes']"));
        js.executeScript("arguments[0].click();", yesButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class='btn btn-info btn-yes']")));
        yesButton = driver.findElement(By.xpath("//button[@class='btn btn-info btn-yes']"));
        js.executeScript("arguments[0].click();", yesButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'×')])[6]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'×')])[6]")));
        closeIcon = driver.findElement(By.xpath("(//a[contains(text(),'×')])[6]"));

        js.executeScript("arguments[0].click();", closeIcon);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'×')])[5]")));
        closeIcon = driver.findElement(By.xpath("(//a[contains(text(),'×')])[5]"));
        js.executeScript("arguments[0].click();", closeIcon);

    }

    public String getDebitNoteNameAfterSaving() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        debitNoteName = driver.findElement(By.xpath("(//h5[@class='title-text pull-left'])[2]"));
        //  Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//button[@id='appframe-btn-اعتماد'])[2]")));

    //    submitButton = driver.findElement(By.xpath("(//button[@id='appframe-btn-اعتماد'])[2]//i"));
      //  js.executeScript("arguments[0].click();", submitButton);
        System.out.println(debitNoteName.getText());
        return debitNoteName.getText();
    }
    public String getDebitNoteNameAfterSubmitting() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        debitNoteName = driver.findElement(By.xpath("(//h5[@class='title-text pull-left'])[2]"));
        System.out.println(debitNoteName.getText());
        return debitNoteName.getText();
    }
}
