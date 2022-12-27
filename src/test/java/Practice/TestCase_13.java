package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_13 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }
    @Test
    public void Test01() {
        //3. Verify that home page is visible successfully --> Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }

    @Test
    public void Test02() {
        //4. Click 'View Product' for any product on home page== Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın
        //5. Verify product detail is opened   5. Ürün detayının açıldığını doğrulayın
        //6. Increase quantity to 4   6. Miktarı 4'e yükseltin
        //7. Click 'Add to cart' button    7. 'Sepete ekle' düğmesini tıklayın
        //8. Click 'View Cart' button      8. 'Sepeti Görüntüle' düğmesini tıklayın
        //9. Verify that product is displayed in cart page with exact quantity  9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
    }

}
