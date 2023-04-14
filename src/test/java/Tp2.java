import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tp2 {

    WebDriver driver;


    @Test
    public void testAmazon() {
        driver.get("https://www.amazon.fr"); //ouverture de la page Web
        WebElement cookieButton= driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        cookieButton.click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("PlayStation5"); //pour ecrire dans un champs
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

    }

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver(); //recupération des Chromedriver
        driver.manage().window().maximize(); // Afin d'ouvrir la page a la taille maximum proposée par le navigateur
    }


    //@AfterMethod
   // public void teardown() {

    //    driver.quit(); // fermeture du navigateur chrome
   // }
}
