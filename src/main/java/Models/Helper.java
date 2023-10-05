package Models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Helper {
    public static WebDriver driver;

    public static void acceptCookies() {
        Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        Helper.driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }

}
