import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class RegisterTest {
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
    public void testRegister() {
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.findElement(By.linkText("Sign In")).click();
        driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
        driver.findElement(By.linkText("Register Now!")).click();
        driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(RandomGenerator.generateUserID());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(RandomGenerator.generatePassword());
        driver.findElement(By.name("repeatedPassword")).clear();
        driver.findElement(By.name("repeatedPassword")).sendKeys(RandomGenerator.generateRepeatPassword());
        driver.findElement(By.name("account.firstName")).clear();
        driver.findElement(By.name("account.firstName")).sendKeys(RandomGenerator.generateFirstName());
        driver.findElement(By.name("account.lastName")).clear();
        driver.findElement(By.name("account.lastName")).sendKeys(RandomGenerator.generateLastName());
        driver.findElement(By.name("account.email")).clear();
        driver.findElement(By.name("account.email")).sendKeys(RandomGenerator.generateEmail());
        driver.findElement(By.name("account.phone")).clear();
        driver.findElement(By.name("account.phone")).sendKeys(RandomGenerator.generatePhone());
        driver.findElement(By.name("account.address1")).clear();
        driver.findElement(By.name("account.address1")).sendKeys(RandomGenerator.generateAddress1());
        driver.findElement(By.name("account.address2")).clear();
        driver.findElement(By.name("account.address2")).sendKeys(RandomGenerator.generateAddress2());
        driver.findElement(By.name("account.city")).clear();
        driver.findElement(By.name("account.city")).sendKeys(RandomGenerator.generateCity());
        driver.findElement(By.name("account.state")).clear();
        driver.findElement(By.name("account.state")).sendKeys(RandomGenerator.generateState());
        driver.findElement(By.name("account.zip")).clear();
        driver.findElement(By.name("account.zip")).sendKeys(RandomGenerator.generateZip());
        driver.findElement(By.name("account.country")).clear();
        driver.findElement(By.name("account.country")).sendKeys(RandomGenerator.generateCountry());
        driver.findElement(By.name("newAccount")).click();
        String title = driver.getTitle();
        assertEquals(title, "JPetStore Demo");
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


