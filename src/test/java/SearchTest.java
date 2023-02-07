import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class SearchTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "F:\\TestProjektSelenium\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testProductSearch() {
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        WebElement searchField = driver.findElement(By.name("keyword"));
        searchField.sendKeys("Angelfish");
        WebElement searchButton = driver.findElement(By.name("searchProducts"));
        searchButton.click();
        WebElement productName =    driver.findElement(By.xpath("//div[@id='Catalog']/table/tbody/tr[2]/td[3]"));
        assertEquals(productName.getText(), "Angelfish");
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

