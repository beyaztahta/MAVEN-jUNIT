package lesson_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C003_WebTables extends TestBase {
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
        List<WebElement> otelBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr"));
        otelBilgileri.stream().forEach(t -> System.out.println(t.getText()));

        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        int row = 1;
        for (WebElement w : otelBilgileri) {
            if (w.getText().contains("601")) {
                System.out.println("Tablodaki " + row + " .satırdaki otel bilgileri : " + w.getText());
            }
            row++;
        }

        //Bütün Height bilgilerini yazdırınız
        List<WebElement> heights = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr//td[3]"));
        heights.stream().forEach(t -> System.out.println(t.getText()));


        //Otel uzunluklarının hepsini toplayınız
        List<String> list = new ArrayList<>();
        for (WebElement w : heights) {
            list.add(w.getText());
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replace("m", ""));
        }
        list.stream().forEach(t -> System.out.println(t));
        int sum = 0;
        for (String s : list) {
            sum = Integer.parseInt(sum + s);
        }
        System.out.println("Otellerin toplam uzunlugu : " + sum);


        //Bir method ile satır ve sutun bilgilerini çağıralım
        tabloSatırSutun(3, 4);
    }

    private void tabloSatırSutun(int row, int column) {
        System.out.println(row + " .satır " + column + ".sutun bilgisi");
        driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr["+ row +"]//td["+ column +"]")).getText();

    }
}
