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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Question_02 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @Test
    public void Test01() {
        //fill the lastname//fill the firstname   //check the gender   //check the experience //fill the date
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.ARROW_RIGHT
                , Keys.TAB, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.TAB, "22/10/2022", Keys.TAB, Keys.TAB
                , Keys.SPACE, Keys.TAB, Keys.TAB, Keys.TAB, Keys.SPACE, Keys.TAB, "Africa", Keys.TAB, Keys.LEFT_CONTROL,
                Keys.SPACE, Keys.ARROW_DOWN, Keys.SPACE, Keys.ARROW_DOWN, Keys.SPACE, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);


        //fill the lastname
        //check the gender
        //check the experience
        //fill the date
        //choose your profession -> Automation Tester
        //choose your tool -> Selenium Webdriver
        //choose your continent -> Antartica
        //choose your command  -> Browser Commands
        //click submit button
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
