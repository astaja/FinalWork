package Extra;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helper {
    public static WebDriver driver;

    public static WebDriverWait wait;

    public static void acceptCookies() {
        driver.get("https://www.aruodas.lt/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

}
