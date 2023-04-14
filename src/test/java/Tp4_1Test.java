import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tp4_1Test {

        WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void teardown() {
            driver.quit();
        }

        final static int TIMEOUT_SIDE_PANEL = 5;

        @Test
        public void testExo1() {
            String keyword = "iphone 13";
            String amzUrl = "https://www.amazon.fr/";
            driver.get(amzUrl);
            driver.findElement(By.id("sp-cc-accept")).click();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click(); //div.s-product-image-container

            List<WebElement> searchResultList = driver.findElements(By.cssSelector("div.s-product-image-container"));
            searchResultList.get(0).click();
            driver.findElement(By.cssSelector("input#add-to-cart-button")).click();

            // Explicit Wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
            WebElement nonMerciButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#attachSiNoCoverage")));
            nonMerciButton.click();

            // sleep 2
            WebElement panierButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#attach-sidesheet-view-cart-button")));
            panierButton.click();

            WebElement resultButton = driver.findElement(By.cssSelector("input[name=proceedToRetailCheckout]"));

            Assert.assertTrue(resultButton.isDisplayed(), "Payment button not visible");


            WebElement serachResultTitle = driver.findElement(By.cssSelector("span.a-truncate-cut"));
            String actualResults = serachResultTitle.getText();
            Assert.assertTrue(actualResults.toLowerCase().contains(keyword.toLowerCase()), "The product title doesn't contain " + keyword);

        }
}
