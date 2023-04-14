import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tp1 {
    WebDriver driver;

    @Test
    public void testGoogle() {
        driver.get("https://google.fr"); //ouverture de la page Web
    }

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver(); //recupération des Chromedriver
    }


    @AfterMethod
    public void teardown() {

        driver.quit(); // fermeture du navigateur chrome
    }
}
