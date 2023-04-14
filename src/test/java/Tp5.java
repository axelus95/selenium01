import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tp5 {
    WebDriver driver;
    final static int TIMEOUT_SIDE_PANEL = 5;


    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver(); //recupération des Chromedriver
        driver.manage().window().maximize(); // Afin d'ouvrir la page a la taille maximum proposée par le navigateur
    }



    //@AfterMethod
    //public void teardown() {

      //  driver.quit(); // fermeture du navigateur chrome
    //}


    @Test

   public void amazonTest (){
        //String expectedTitle = "";
        driver.get("https://www.amazon.fr");
        driver.findElement(By.id("sp-cc-accept")).click();

        //WebElement menueButton = driver.findElement(By.id("a#nav-hamburger-menu"));
        //menueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));

        driver.findElement(By.cssSelector("a#nav-hamburger-menu")).click();

        //List<WebElement> menuTotal = driver.findElements(By.cssSelector("#hmenu-content.hmenu-visible.hmenu-item"));
        //menuTotal.get(17).click();
        //driver.findElement(By.cssSelector("#hmenu-content .hmenu-visible .hmenu-item")).click();


        //WebElement jeuxEtConsole = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav_em_1_1_1_17")));
        //jeuxEtConsole.click();

        //driver.findElement(By.cssSelector("a#nav-hamburger-menu")).click();
        //driver.findElement(By.cssSelector("nav_em_1_1_1_17")).click(); //Jeux vidéo et console


    }
}
