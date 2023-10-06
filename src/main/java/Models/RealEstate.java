package Models;
import Extra.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class RealEstate {
    public WebDriver driver;
    public String region;
    public String district;
    public String quartal;
    public String street;
    public String object;
    public String description;
    public String photo;
    public String link;
    public String threedee;
    public String price;
    public String phone;
    public String email;

    public RealEstate (String region, String district, String quartal, String street, String object,
                  String description, String photo, String link, String threedee, String price, String phone,
                  String email) {
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.object = object;
        this.description = description;
        this.photo = photo;
        this.link = link;
        this.threedee = threedee;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.driver = Helper.driver;
    }

    public void fill() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[24]")).click();
    }

}
