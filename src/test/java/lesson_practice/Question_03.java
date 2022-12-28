package lesson_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Question_03 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @Test
    public void Test01() {
        // Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();

        // Type any number in the first input
        //Type any number in the second input
        // Click on Calculate
       WebElement calculator= driver.findElement(By.xpath("//input[@id='number1']"));
       calculator.sendKeys("25", Keys.TAB,Keys.TAB,"65",Keys.ENTER);

        // Print the result
        System.out.println(driver.findElement(By.xpath("//div[@class='centered']//p[1]")).getText());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
