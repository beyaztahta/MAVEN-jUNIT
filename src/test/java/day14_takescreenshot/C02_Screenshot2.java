package day14_takescreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshot2 extends TestBase {
    //Techpro education a git
    //Sosyal medya elemanlarını goruntusunu al


    @Test
    public void test01() throws IOException {
//        Techpro education a git
        driver.get("https://techproeducation.com");

        //Sosyal medya elemanlarını goruntusunu al

    //1.Adım ekran goruntusunu cek.
        WebElement sosyalMedyaIconlari=driver.findElement(By.xpath("(//div[@class='elementor-widget-container'])[1]" ));
        File image=sosyalMedyaIconlari.getScreenshotAs(OutputType.FILE);

    //2.Adım ekran goruntusunu kaydet
        String currentTime = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));

    }
}
