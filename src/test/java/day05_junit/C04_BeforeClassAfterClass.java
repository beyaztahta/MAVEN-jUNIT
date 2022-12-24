package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

  /*
  @BeforeClass  ve @AfterClass notasyonları sadece static methodlar icin calısır.@BeforeClass ve @AfterClass kullanırsak oluturdugumuz
   test methodlarının hepsini aynı anda calıstırıp en son @AfterClass ı calıstırırız.
   Ama sadece @Before ve @After kullanırsak her test icin before ve after ı kullanır.
   */


    @BeforeClass
    public static void setUp(){
        System.out.println("Butun testlerden once  bir kez calısır.");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Butun testlerden sonra bır kez calıstı.");
    }
    @Before
    public void setUp01(){
        System.out.println("Her testten once calısır.");
    }

    @After
    public void tearDown01(){
        System.out.println("Her testten sonra calısır.");
    }

    @Test
    public void tes01(){
        System.out.println("first test");
    }

    @Test
    public void tes02(){
        System.out.println("second test");
    }

    @Test
    @Ignore// amacı==>calıstırmak istemedigimiz testin altına yazarsak o test calısmaz.
    public void test03(){
        System.out.println("Ucuncu test");
    }

}
