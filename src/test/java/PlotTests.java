import Extra.Helper;
import Models.Plot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
public class PlotTests {
    @BeforeClass
    public void beforeClass() {
        Helper.driver = new ChromeDriver();
        // Helper.wait = new WebDriverWait(Helper.driver, Duration.ofSeconds(5));
        Helper.driver.manage().window().maximize();
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Helper.acceptCookies();
    }
    @AfterClass
    public void afterClass() {
        Helper.driver.quit();
    }
    @BeforeMethod
    public void beforeMethod() {
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
    }
    @Test
    public void positivePlotTest() {
        Plot pl = new Plot("Kaunas", "Kauno m.", "Aleksotas", "Aido g.",
                "123 ", "2198-8002-1019:0004", "10", "", "", "DESCRIPTION",
                "/TestImages/house3.jpg",
                "https://www.youtube.com/watch?v=k85mRPqvMbE&pp=ygUKY3JhenkgZnJvZw%3D%3D&ab_channel=CrazyFrog",
                "https://www.youtube.com/watch?v=bs9Gx4Q20pE&ab_channel=YEES", "6666", "61234567",
                "uyvuyg@gmail.com");
        pl.fill();
    }
}