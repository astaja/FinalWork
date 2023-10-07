import Models.RealEstate;
import Models.SearchRE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import Extra.Helper;

public class SearchRealEstateTests {
    @BeforeClass
    public void beforeClass() {
        Helper.driver = new ChromeDriver();
        Helper.wait = new WebDriverWait(Helper.driver, Duration.ofSeconds(5));
        Helper.driver.manage().window().maximize();
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterClass
    public void afterClass() {
        Helper.driver.quit();
    }
    @BeforeMethod
    public void beforeMethod() {
        Helper.acceptCookies();
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void positiveOOPTest() {
        SearchRE re = new SearchRE("Kaunas", "Kauno m.", "Aleksotas", "Aido g.",
                "Namai Pirkti", "DESCRIPTION", "/TestImages/house3.jpg",
                "https://www.youtube.com/watch?v=k85mRPqvMbE&pp=ygUKY3JhenkgZnJvZw%3D%3D&ab_channel=CrazyFrog",
                "https://www.youtube.com/watch?v=bs9Gx4Q20pE&ab_channel=YEES", "6666", "61234567",
                "uyvuyg@gmail.com");
        re.fill();
    }
//    @Test
//    public void positiveTest() {
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click(); // region
//        Helper.driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[2]")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click(); // district
//        Helper.driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[2]")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click(); // street
//        Helper.driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[24]")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click(); //object type
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul/li[2]")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[13]/div/div[1]/textarea")).sendKeys("description description description");
//        String path = System.getProperty("user.dir") + "/TestImages/house3.jpg"; // upload pic
//        WebElement uploadFile = Helper.driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input"));
//        uploadFile.sendKeys(path);
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/span[1]/input")).sendKeys("https://www.youtube.com/watch?v=k85mRPqvMbE&pp=ygUKY3JhenkgZnJvZw%3D%3D&ab_channel=CrazyFrog");
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/span[1]/input")).sendKeys("https://www.youtube.com/watch?v=bs9Gx4Q20pE&ab_channel=YEES");
//        Helper.driver.findElement(By.xpath("//*[@id=\"priceField\"]")).sendKeys("99999");
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/span[1]/input")).sendKeys("61111110");
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/span[1]/input")).sendKeys("itdvifdc@gmail.com");
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/span/label")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[24]/div/div/div/label")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label/span")).click();
//        Helper.driver.findElement(By.id("submitFormButton")).click();
    }
}
