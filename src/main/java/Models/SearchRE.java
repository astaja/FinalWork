package Models;

import Extra.Helper;
import org.openqa.selenium.By;

public class SearchRE extends RealEstate{
    public String object;
    public SearchRE(String region, String district, String quartal, String street, String object, String description, String photo, String link, String threedee, String price, String phone, String email) {
        super(region, district, quartal, street, description, photo, link, threedee, price, phone, email);
        this.object = object;
    }
    public void selectObjectType() {
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul/li[2]")).click();
    }

    @Override
    public void fill() {
        Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11");
        super.fill();
        selectObjectType();
    }

}
