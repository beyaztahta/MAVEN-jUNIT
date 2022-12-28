package lesson_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Question_05 {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() {

        //http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    @Test
    public void Test01() {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("The God Father", Keys.ENTER);
    }

    @Test
    public void Test02() {
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void Test03() {
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Kill Bill", Keys.ENTER);

    }

    @After
    public void tearDown() throws Exception {
        String sonuc[] = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonuc[1]);

        String sonuc2[] = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonuc[1]);

        String sonuc3[] = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonuc[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();

    }

}
