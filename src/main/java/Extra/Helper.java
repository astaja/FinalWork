package Extra;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helper {
    public static WebDriver driver;

    public static WebDriverWait wait;

    public static void acceptCookies() {
        Helper.driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }

}
