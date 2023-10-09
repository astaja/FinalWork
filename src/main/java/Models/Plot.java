package Models;
import Extra.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import javax.swing.*;
import java.util.List;

public class Plot extends RealEstate{

    public String selectNr;
    public String selectRCNr;
    public String area;
    public String purpose;
    public String features;
    public String textArea;

    public Plot(String region, String district, String quartal, String street, String selectNr, String selectRCNr,
                String area, String purpose, String features, String description, String photo, String link, String threedee,
                String price, String phone, String email) {
        super(region,
                district,
                quartal,
                street,
                description,
                photo,
                link,
                threedee,
                price,
                phone,
                email);
        this.selectNr = selectNr;
        this.selectRCNr = selectRCNr;
        this.area = area;
        this.purpose = purpose;
        this.features = features;
        this.driver = Helper.driver;
        this.wait = Helper.wait;
    }

    @Override
    public void fill() {
        Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        super.fill();
        selectNr();
        selectRCNr();
        area();
        purpose();
        features();
        driver.findElement(By.id("submitFormButton")).click();
    }
    public void selectNr() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input")).sendKeys(selectNr);
    }
    public void selectRCNr() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/div[1]/input")).sendKeys(selectRCNr);
    }
    public void area() {
        driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]")).sendKeys(area);
    }
    public void purpose() {
        driver.findElement(By.name("FIntendance[]")).click();
    }
    //By.id("cb_FIntendance_forest")
    public void features() {
        driver.findElement(By.id("showMoreFields")).click();
        driver.findElement(By.id("cb_SpecialLot_11")).click();
    }
}
