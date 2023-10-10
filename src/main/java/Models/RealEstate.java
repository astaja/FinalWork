package Models;
import Extra.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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
        //openPage();
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

//    public void openPage() {
//        Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
//    }
    public void setClicks() {
        List<WebElement> li = driver.findElements(By.tagName("li"));
        int thirdFromEnd = li.size() - 3;
        int fourthFromEnd = li.size() - 4;
        int fifthFromEnd = li.size() - 5;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        li.get(fifthFromEnd).findElements(By.tagName("label")).get(1).click();
        li.get(fourthFromEnd).findElements(By.tagName("label")).get(1).click();
        li.get(thirdFromEnd).findElements(By.tagName("span")).get(1).click();
//        Helper.driver.findElement(By.id("cbdont_show_in_ads")).click();
//        Helper.driver.findElement(By.id("cbdont_want_chat")).click();
//        Helper.driver.findElement(By.id("cbagree_to_rules")).click();
        Helper.driver.findElement(By.id("submitFormButton")).click();
    }
    public void setEmail() {
        Helper.driver.findElement(By.name("email")).sendKeys(email);
    }
    public void setPhone() {
        Helper.driver.findElement(By.name("phone")).sendKeys(phone);
    }
    public void setPrice() {
        Helper.driver.findElement(By.xpath("//*[@id=\"priceField\"]")).sendKeys(price);
    }
    public void setThreedee() {
        Helper.driver.findElement(By.name("tour_3d")).sendKeys(threedee);
    }
    public void setLink() {
        Helper.driver.findElement(By.name("Video")).sendKeys(link);
    }

    public void description() {
        Helper.driver.findElement(By.name("notes_lt")).sendKeys(description);
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
