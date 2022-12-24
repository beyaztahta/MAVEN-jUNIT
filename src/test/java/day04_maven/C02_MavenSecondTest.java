package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenSecondTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3.Login alanine “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

        //4.Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password'"));
        password.sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.navigate().back();

        //6.OnlingBankinge tıklayın.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("100");

        //8.tarih kismina “2020-09-10” yazdirin
        WebElement date=driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        System.out.println(driver.findElement(By.xpath("//*[@title='$ 100 payed to payee sprint']")).isDisplayed() ? "TEST PASSED" : "TEST FAILED");

        driver.close();

    }
}
