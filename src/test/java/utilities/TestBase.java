package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //abstract yapmamızın sebebi: bu sınıfın objesini olusturmak istemiyoruz.Yani TestBase testbase=new TestBase(); yapılamaz.Amacım bu
    //bu sınıfı extends etmek ve hazır methodlarını kullanmaktır.
    protected static WebDriver driver;//driver objesini olusturduk.Burada public veya protected kullanılır,sebebi ise diger child classlardan cagırılmasıdır.Cunku inheritanse olacak.

    //setUp
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    //teardown
    @After
    public void tearDown() {
        waitFor(5);
        driver.quit();
    }


    //    MULTIPLE WINDOW

    /*
    1 perametre alır : Gecis yapmak istedigim sayfanın baslıgı(title)
        ORNEK:
          driver.get("https://the-internet.herokuapp.com/windows");
          switchToWindow("New Window");
           switchToWindow("The Internet")
     */
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //windowNumber sıfır (0)'dan başlıyor.
    //    index numarasini parametre olarak alir ve o indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber){

        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*   HARD WAIT:
   @param : second
       */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToWindow_URL(String url) {
        for (String w : driver.getWindowHandles()) {
            driver.switchTo().window(w);
            if(driver.getCurrentUrl().equals(url)) return;
        }
    }

    public WebElement selectFromDropdown(WebElement dropdown, String myOption) {
        Select option = new Select(dropdown);
        option.selectByVisibleText(myOption);
        return option.getFirstSelectedOption();
    }



}
