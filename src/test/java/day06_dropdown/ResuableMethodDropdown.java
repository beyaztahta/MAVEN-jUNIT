package day06_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ResuableMethodDropdown {
     WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Given kullanıcı:https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    //REUSABLE METHOD:Dropdown için tekrar tekrar kullanabilecegimiz bir method olusturalım.

    public void selectFromDropdown(WebElement dropdowmn,String secenek){
   //selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']"),"2000")__>2000
   //selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']"),"January")   ___>January
   //selectFromDropdown(driver.findElement(By.xpath("//select[@id='day']"),"12") ___>12................

      //Gonderilen dropdown elementinin tum optionslar alınır.Herhangi bir sayfadaki ddwn optionları da alabilir.
        List<WebElement>tumOptions=dropdowmn.findElements(By.tagName("option"));//Tum option taglarını alır.
        for (WebElement w:tumOptions) {
            if(w.getText().equals(secenek)){
                w.click();
                break;
            }
        }
    }

    @Test
    public void selectFromDropdown() {
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")),"2005");
        selectFromDropdown(driver.findElement(By.id("month")),"November");
        selectFromDropdown(driver.findElement(By.id("day")),"10");
        selectFromDropdown(driver.findElement(By.id("state")),"Texas");
    }





}
