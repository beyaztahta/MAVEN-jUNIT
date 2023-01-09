package homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Faker01 extends TestBase {
    @Test
    public void faketTest01() {
        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String surname = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName, Keys.TAB, surname, Keys.TAB, email);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='reg_email_confirmation__']")));
        emailBox.sendKeys(email, Keys.TAB, password);




        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        // “email” onay kutusuna emaili tekrar yazin
        //“password” giris kutusuna bir password yazin)
        //Bir sifre girin

        //Tarih icin gun secin
//        WebElement gun= driver.findElement(By.xpath("//select[@id='day']"));
//        Select gunDddwn=new Select(gun);
//        gunDddwn.selectByIndex(7);
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='day']")), "10");

        //Tarih icin ay secin
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")), "Kas");

        //Tarih icin yil secin
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "1991");


        //Cinsiyeti secin
        WebElement seciliOlanKutu = driver.findElement(By.xpath("//*[text()='Kadın']"));
        seciliOlanKutu.click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement seciliOlmayanKutu1 = driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement seciliOlmayanKutu2 = driver.findElement(By.xpath("//*[text()='Özel']"));

        Assert.assertTrue(seciliOlanKutu.isSelected());
        Assert.assertFalse(seciliOlmayanKutu1.isSelected());
        Assert.assertFalse(seciliOlmayanKutu2.isSelected());


        //Sayfayi kapatin
    }

}
