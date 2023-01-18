package lesson_practice;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C07_FluentWait extends TestBase {
     /*
                                - Fluent Wait -
        Selenium’da Fluent Wait, web sürücüsünün bir koşulu beklemesi için maksimum süreyi ve “ElementNotVisibleException”
    exception’ını atmadan önce koşulu kontrol etmek istediğimiz sıklığı tanımlamak için kullanılır.
    Nesne bulunana veya zaman aşımı gerçekleşene kadar düzenli aralıklarla web elementini kontrol eder.
        Bir elemanın farklı zaman aralıklarında yüklendiği bir senaryo düşünelim.
    Öğe 10 saniye, 20 saniye veya daha uzun bir süre içinde yüklenebilir.
    Bu durumda 20 saniyelik Explicit Wait tanımlarsak bir exception atmadan önce belirtilen süreye kadar bekleyecektir.
    Bu tür senaryolarda, Fluent Wait öğeyi bulana kadar veya son zamanlayıcı bitene kadar farklı frekansta bulmaya
    çalışacağından, kullanımı ideal olacaktır.
    Syntax:
                 Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);//Eğer element bulunmazsa NoSuchElementException hatasını yok sayar.
     */
    //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
    //Click me, to open an ... butonuna basalım
    //Çıkan alert'i kapatalım


    @Test
    public void fluentWaitTest01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //Click me, to open an ... butonuna basalım
        WebElement buton=driver.findElement(By.xpath("//*[@id='alert']"));
        buton.click();

        FluentWait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))//max bekleme suresi
                .pollingEvery(Duration.ofSeconds(3))//hangi sıklıkla beklemsi gerektigini soyluyoruz.
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.alertIsPresent());//alert cıkana kadar bekle

        //Çıkan alert'i kapatalım
        driver.switchTo().alert().accept();


    }
}
