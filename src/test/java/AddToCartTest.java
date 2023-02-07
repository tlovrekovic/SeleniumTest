import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class AddToCartTest {
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
    public void testAddToCart() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("FI-SW-01")).click();
        driver.findElement(By.linkText("Add to Cart")).click();
        WebElement message =  driver.findElement(By.xpath("//div[@id='Cart']/form/table/tbody/tr[2]/td[2]"));
        assertEquals(message.getText(), "FI-SW-01");
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
