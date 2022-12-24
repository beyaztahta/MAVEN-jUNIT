package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertionTest {

   WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    //1)Bir class oluşturun:YoutubeAssertions
    //2)https://www.youtube.com adresinegidin
    //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
    //○ title Test  => Sayfa başlığının “Amazon” oldugunu testedin
    //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) testedin
    //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “amazon” olmadigini dogrulayin

    @Test
    public void Test01(){
        String actualTitle= driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void Test02(){
      WebElement logo=driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
       Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void Test03(){
        WebElement searchBox= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void Test04(){
        String actualTitle= driver.getTitle();
        String expectedTitle="amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }






}
