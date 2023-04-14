import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tp4 {

    WebDriver driver;
    final static int TIMEOUT_SIDE_PANEL = 5;



    @AfterMethod
    public void teardown() {

    driver.quit(); // fermeture du navigateur chrome
    }






    @Test
    public void testAmazon2() {

        //String expectedTitle = "";
        driver.get("https://www.amazon.fr");
        driver.findElement(By.id("sp-cc-accept")).click();

        String keyword = "iPhone 13";
        driver.findElement(By.name("field-keywords")).sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click(); //click sur la loupe de recherche

        driver.findElement(By.cssSelector("img.s-image")).click();
        driver.findElement(By.cssSelector("input#add-to-cart-button.a-button-input.attach-dss-atc")).click();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.cssSelector("span#attachSiNoCoverage.a-button.a-button-span12.a-button-base")).click();


        //Pour endormir de quelques secondes pour que le clic fonctione vue que c'est un pop

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("#attach-sidesheet-view-cart-button")).click();


        //Tester le le resultat attendu est bien celle mentionner sur la barre de recherche

        //WebElement searchResultTitle = driver.findElement(By.cssSelector(".a-truncate-cut"));
        //String realResult = searchResultTitle.getText();
        //Assert.assertEquals(realResult, keyword);

        WebElement serachResultTitle = driver.findElement(By.cssSelector(".a-truncate-cut"));
        String actualResults = serachResultTitle.getText();
        Assert.assertTrue(actualResults.toLowerCase().contains(keyword.toLowerCase()), "The product title doesn't contain " + keyword);


        //driver.findElement(By.cssSelector(".a-button-abutton-normal-a-button-span12-a-button-primary")).click().is_enabled();

       //if (driver.findElement(By.cssSelector("#fo616p-9grdqr-ppmcfo-c6e4g")).isEnabled()) WebElement = true;
       //else WebElement = false;



    }

        @BeforeMethod
        public void setup () {

            driver = new ChromeDriver(); //recupération des Chromedriver
            driver.manage().window().maximize(); // Afin d'ouvrir la page a la taille maximum proposée par le navigateur

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }





        }
    }