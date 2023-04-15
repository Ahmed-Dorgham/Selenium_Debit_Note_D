package TestCases;

import Pages.DebitNoteListPage;
import Pages.DebitNotePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class SaveAndSubmitDebitNote_Test extends TestBase {
    String emailID = "Administrator";
    String password = "123456789";
    String selectedSalesInvoiceName;
    private HomePage homePageObject;
    private LoginPage loginPageObject;
    private DebitNoteListPage debitNoteListPageObject;
    private DebitNotePage debitNotePageObject;

    @Test(priority = 1)
    private void loginWithValidData() {
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.loginWithValidData(emailID, password);
        Assert.assertTrue(homePageObject.getWebElement().isDisplayed());
    }

    @Test(priority = 2)
    private void openDebitNotesListPage() {
        debitNoteListPageObject = homePageObject.openDebitNotesPage();
        Assert.assertTrue(debitNoteListPageObject.getSalesInvoicesListElement().isDisplayed());
    }

    @Test(priority = 3)
    public void createNewDebitNote() throws InterruptedException, AWTException {
        debitNotePageObject = debitNoteListPageObject.openNewDebitNote();
        debitNotePageObject.getSalesInvoices();
        selectedSalesInvoiceName = debitNotePageObject.getSelectedSalesInvoiceName().getText();
        debitNotePageObject.selectSalesInvoice();
        Assert.assertEquals(selectedSalesInvoiceName, debitNotePageObject.getSelectedSalesInvoiceForAssertion().getText());
        debitNotePageObject.writeReason();
       // debitNotePageObject.saveDebitNote();

        debitNotePageObject.saveAndSubmitDebitNote();
        debitNotePageObject.getDebitNoteNameAfterSubmitting();
    }
}