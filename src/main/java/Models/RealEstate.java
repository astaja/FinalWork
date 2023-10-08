package Models;
import Extra.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RealEstate {
    public WebDriver driver;
    public WebDriverWait wait;
    public String region;
    public String district;
    public String quartal;
    public String street;
    public String description;
    public String photo;
    public String link;
    public String threedee;
    public String price;
    public String phone;
    public String email;

    public RealEstate (String region, String district, String quartal, String street, String description, String photo,
                       String link, String threedee, String price, String phone, String email) {
        this.region = region.toLowerCase();
        this.district = district.toLowerCase();
        this.quartal = quartal.toLowerCase();
        this.street = street.toLowerCase();
        this.description = description;
        this.photo = photo;
        this.link = link;
        this.threedee = threedee;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.driver = Helper.driver;
        this.wait = Helper.wait;
    }

    public void fill() {
        openPage();
        setLocation(0, region);
        setLocation(1, district);
        setLocation(2, quartal);
        setLocation(3, street);
        description();
        uploadFile();
        setLink();
        setThreedee();
        setPrice();
        setPhone();
        setEmail();
        setClicks();
    }

    public void openPage() {
        Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
    }
    public void setClicks() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/span/label")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[24]/div/div/div/label")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label/span")).click();
        Helper.driver.findElement(By.id("submitFormButton")).click();
    }
    public void setEmail() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/span[1]/input")).sendKeys(email);
    }
    public void setPhone() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/span[1]/input")).sendKeys(phone);
    }
    public void setPrice() {
        Helper.driver.findElement(By.xpath("//*[@id=\"priceField\"]")).sendKeys(price);
    }
    public void setThreedee() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/span[1]/input")).sendKeys(threedee);
    }
    public void setLink() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/span[1]/input")).sendKeys(link);
    }

    public void description() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[13]/div/div[1]/textarea")).sendKeys(description);
    }

    public void uploadFile() {
        String path = System.getProperty("user.dir") + "/TestImages/house3.jpg"; // upload pic
        WebElement uploadFile = Helper.driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input"));
        uploadFile.sendKeys(path);
    }

    public void setLocation(int pos, String location) {
        try {
            WebElement span = driver.findElements(By.className("input-style-dropdown")).get(pos);
            Thread.sleep(500);
            span.findElement(By.className("dropdown-input-value-title")).click();
            WebElement ul = span.findElement(By.className("dropdown-input-values-address"));
            if (ul.findElements(By.tagName("input")).isEmpty()) {
                for (WebElement li : ul.findElements(By.tagName("li"))) {
                    if (li.getText().toLowerCase().contains(location)) {
                        li.click();
                        break;
                    }
                }
            } else {
                int count = ul.findElements(By.tagName("li")).size();
                ul.findElement(By.tagName("input")).sendKeys(location);
                while (true) {
                    List<WebElement> lis = ul.findElements(By.tagName("li"));
                    if (count != lis.size()) {
                        lis.get(lis.size() - 1).click();
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
