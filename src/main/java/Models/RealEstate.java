package Models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealEstate {
    public WebDriver driver;
    public String municipality;
    public String place;
    public String microdistrict;
    public String street;
    public String object;
    public String description;
    public String photo;
    public String link;
    public String threedee;
    public String price;
    public String phone;
    public String email;

    public RealEstate (String municipality, String place, String microdistrict, String street, String object,
                  String description, String photo, String link, String threedee, String price, String phone,
                  String email, WebDriver driver) {
        this.municipality = municipality;
        this.place = place;
        this.microdistrict = microdistrict;
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
//        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click(); // city
//        Helper.driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[2]")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click(); // microdistrict
//        Helper.driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[2]")).click();
//        Helper.driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click(); // street
//        Helper.driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[24]")).click();
    }

}
