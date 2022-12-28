package lesson_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Questions_07_Dropdown {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void Test01() {
        // dropdown'dan "Baby" secenegini secin
        // sectiginiz option'i yazdirin

        WebElement baby= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select ddwn=new Select(baby);
        ddwn.selectByVisibleText("Baby");

        System.out.println(ddwn.getFirstSelectedOption().getText());


        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement>ddwnSayisi=ddwn.getOptions();
        int actualOptionsSayisi=ddwnSayisi.size();
        int expectedOptionsSayisi=28;
        Assert.assertEquals(expectedOptionsSayisi, actualOptionsSayisi);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
