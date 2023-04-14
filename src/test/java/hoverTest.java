import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class hoverTest {

    WebDriver driver;

    By listAndAccountButtonBy = By.cssSelector("#nav-link-accountList");

    By signInButtonBy = By.cssSelector(".nav-action-button");

    public void createNewAccount() {
        Actions actions = new Actions(driver);

        WebElement buttonAccount = driver.findElement(listAndAccountButtonBy);
        actions.moveToElement(buttonAccount);
        actions.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(signInButtonBy)).click();
    }

}
