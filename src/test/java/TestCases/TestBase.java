package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.time.Duration.ofSeconds;

public class TestBase {

    protected WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        // System.setProperty("webdriver.chrome.driver", "D:\\to run  intelliJ & to begin automation\\chromedriverr_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(20));
        driver.get("https://engineering-dorgham.dafater.biz/index.html");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void closeBrowser ()
    {
        driver.quit();
    }
}
