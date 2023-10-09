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
                String area, String purpose, String features, String textArea, String photo, String link, String threedee,
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
        this.textArea = textArea;
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
        textArea();
        driver.findElement(By.id("submitFormButton")).click();
    }
    public void selectNr() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input")).sendKeys("123");
    }
    public void selectRCNr() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/div[1]/input")).sendKeys("123-123-123");
    }
    public void area() {
        driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]")).sendKeys("10");
    }
    public void purpose() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[5]/label/text()")).click();
    }
    public void features() {
        driver.findElement(By.id("showMoreFields")).click();
        driver.findElement(By.id("cb_SpecialLot_11")).click();
    }
    public void textArea() {
        driver.findElement(By.name("notes_lt")).sendKeys("MY TEXT AREA IS HERE");
    }
}
