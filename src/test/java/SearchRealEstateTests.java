import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.*;
import Models.Helper;

public class SearchRealEstateTests {
    @BeforeClass
    public void beforeClass() {
        Helper.driver = new ChromeDriver();
        Helper.driver.manage().window().maximize();
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterClass
    public void afterClass() {
        Helper.driver.quit();
    }
    @BeforeMethod
    public void beforeMethod() {
        Models.Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        Models.Helper.acceptCookies();
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
    }
    @Test
    public void positiveTest() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click(); // city
        Helper.driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[2]")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click(); // microdistrict
        Helper.driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[2]")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click(); // street
        Helper.driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[24]")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click(); //object type
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul/li[2]")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[13]/div/div[1]/textarea")).sendKeys("description description description");
        String path = System.getProperty("user.dir") + "/TestImages/house2.png"; // upload pic
        WebElement upload_file = Helper.driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]"));
        upload_file.sendKeys(path);
        boolean hasClass = Helper.driver.findElement(By.xpath("//*[@id=\"fieldPhotosInfo\"]/div")).getAttribute("class").contains("infoCol");
        Assert.assertTrue(hasClass);
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/span[1]/input")).sendKeys("https://www.youtube.com/watch?v=k85mRPqvMbE&pp=ygUKY3JhenkgZnJvZw%3D%3D&ab_channel=CrazyFrog");
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/span[1]/input")).sendKeys("https://www.youtube.com/watch?v=bs9Gx4Q20pE&ab_channel=YEES");
        Helper.driver.findElement(By.xpath("//*[@id=\"priceField\"]")).sendKeys("99999");
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/span[1]/input")).sendKeys("61111111");
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/span[1]/input")).sendKeys("itdvifdc@gmail.com");
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/span/label")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[24]/div/div/div/label")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label")).click();
        Helper.driver.findElement(By.id("submitFormButton")).click();

    }

//    @Test
//    public void secondTest() {
//        Models.RealEstate  r = new Models.RealEstate();
//        r.fill();
//    }




}
