package day15_extentreports;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WebTables extends TestBase {

    //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
    //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
    //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
    //Bütün Height bilgilerini yazdırınız
    //Otel uzunluklarının hepsini toplayınız
    //Bir method ile satır ve sutun bilgilerini çağıralım
    @Test
    public void test01() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        List<WebElement> list = driver.findElements(By.xpath("//table[@border=1]//tbody//tr//th"));
        list.forEach(t -> System.out.println(t.getText()));
        waitFor(3);

        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        List<WebElement> heights = driver.findElements(By.xpath("//table[@border=1]//tbody//tr"));
        heights.stream().filter(t -> t.getText().contains("601")).forEach(t -> System.out.println(t.getText()));

        //Bütün Height bilgilerini yazdırınız
        List<WebElement> heights1 = driver.findElements(By.xpath("//table[@border=1]//tbody//tr//td[3]"));
        heights1.forEach(t -> System.out.println(t.getText()));

        //Otel uzunluklarının hepsini toplayınız

        int sum = 0;
        for (WebElement w : heights1) {
            String yukseklik = w.getText().replace("m", "");
            sum += Integer.parseInt(yukseklik);
        }
        System.out.println("sum = " + sum);

        System.out.println(tabloVeri(3, 2));

        getExtentReport();
        extentTest.pass("TEST BASRARILI ILE GECTI");
        closeExtentReport();
    }
    //Bir method ile satır ve sutun bilgilerini çağıralım

    public String tabloVeri(int row, int cell) {
        String xPath = "//table[@border=1]//tbody//tr[" + row + "]//td[" + cell + "]";
        return driver.findElement(By.xpath(xPath)).getText();
    }
}
