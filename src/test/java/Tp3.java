import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Tp3 {

    WebDriver driver;


    @Test
    public void testAmazon2() {
        String keyword = "playstation 5";
        String expectedTitle = "Sony, PlayStation 5 Édition Standard, PS5 avec 1 Manette Sans Fil DualSense, Couleur : Blanche";
        driver.get("https://www.amazon.fr");
        driver.findElement(By.id("sp-cc-accept")).click();
        driver.findElement(By.name("field-keywords")).sendKeys(keyword);
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        WebElement searchResultTitle = driver.findElement(By.cssSelector("span.a-color-state.a-text-bold"));
        String realResult = searchResultTitle.getText();

        Assert.assertEquals(realResult,"\"" + keyword + "\"");

        List<WebElement> searchResultList = driver.findElements(By.cssSelector("[data-component-type='s-search-result']:not(.AdHolder)"));
        String firstTitle = searchResultList.get(0).getText();
        Assert.assertTrue(firstTitle.contains(expectedTitle));

    }


    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver(); //recupération des Chromedriver
        driver.manage().window().maximize(); // Afin d'ouvrir la page a la taille maximum proposée par le navigateur
    }


}
