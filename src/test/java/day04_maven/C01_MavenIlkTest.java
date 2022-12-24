package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2-arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3-“Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones");//Keys.enter yaparak da bulabiliriz
        searchBox.submit();//entere bastı

        //4-Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));//ilk birinciyi vercek
        System.out.println(aramaSonucu.getText());  //getText webelementinin uzerindeki yazıyı alır.

        String[] aramaSonucuSayısı = aramaSonucu.getText().split(" ");
        System.out.println(aramaSonucuSayısı[2]);

        //5-Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();


        //6-Sayfadaki tum basliklari yazdiralim
        List<WebElement>sayfaBaslıklarıListesii=driver.findElements(By.xpath("//h1"));
        for (WebElement w:sayfaBaslıklarıListesii) {
            System.out.println(w.getText()+" ");
        }
        //Lambda ile cozumu:
        //sayfaBaslıklarıListesii.stream().forEach(t-> System.out.println(t.getText()+" "));

        driver.close();

    }


}
