package lesson_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Questions_06_Dropdown {
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
        // dropdown'dan "Books" secenegini secin
        WebElement books = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select dropDown = new Select(books);
        dropDown.selectByVisibleText("Books");
        //dropDown.selectByValue("search-alias=stripbooks");
        //dropDown.selectByIndex(12);

        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        String expectedResult = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(expectedResult.contains("Java"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
