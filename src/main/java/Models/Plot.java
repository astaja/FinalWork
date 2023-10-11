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
    public int[] purpose;
    public int[] features;

    public Plot(String region, String district, String quartal, String street, String selectNr, String selectRCNr,
                String area, int[] purpose, int[] features, String description, String photo, String link, String threedee,
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


    /**
     * 1 - Namų valda
     * 2 - Sklypas soduose
     * 3 - Sandėliavimo
     * 4 - Kita
     * 5 - Daugiabučių statyba
     * 6 - Miškų ūkio
     * 7 - Komercinė
     * 8 - Žemės ūkio
     * 9 - Pramonės
     * 10 - Rekreacinė
     */
    public void purpose() { // paskirtis
        for (int i = 0; i < purpose.length; i++) {
            switch (purpose[i]) {
                case 1:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
                    break;
                case 2:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[4]/label")).click();
                    break;
                case 3:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[7]/label")).click();
                    break;
                case 4:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[10]/label")).click();
                    break;
                case 5:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[2]/label")).click();
                    break;
                case 6:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[5]/label")).click();
                    break;
                case 7:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[8]/label")).click();
                    break;
                case 8:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[3]/label")).click();
                    break;
                case 9:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[6]/label")).click();
                    break;
                case 10:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[9]/label")).click();
                    break;
            }
        }
    }
    /**
     * 1 - Elektra
     * 2 - Kraštinis sklypas
     * 3 - Geodeziniai matavimai
     * 4 - Dujos
     * 5 - Greta miško
     * 6 - Su pakrante
     * 7 - Vanduo
     * 8 - Be pastatų
     * 9 - Asfaltuotas privažiavimas
     * 10 - Domina keitimas
     * 11 - Varžytinės/aukcionas
     */

    public void features() { // žymėti ypatumus
        driver.findElement(By.id("showMoreFields")).click();
        for (int i = 0; i < features.length; i++) {
            switch (purpose[i]) {
                case 1:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[1]/label")).click();
                    break;
                case 2:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[4]/label")).click();
                    break;
                case 3:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[7]/label")).click();
                    break;
                case 4:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[2]/label")).click();
                    break;
                case 5:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[5]/label")).click();
                    break;
                case 6:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[8]/label")).click();
                    break;
                case 7:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[3]/label")).click();
                    break;
                case 8:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[6]/label")).click();
                    break;
                case 9:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[9]/label")).click();
                    break;
                case 10:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/div/div/div/label")).click();
                    break;
                case 11:
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/div/div/div/label")).click();
            }
        }
    }

}
