package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C0005_Dropdown_Actions extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // sag ust bolumde bulunan dil menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change butonuna basiniz
    // DropDown'dan Visible Text kullanarak 'TRY - Turkish Lira' optionunu secin ve yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki tum optionlarin toplam sayısının 68'ye esit oldugunu test edin
    // Save Changes butonuna basınız
    // arama motoruna 'Kitap' yazip aratin
    // ilk cikan urunun parabiriminin 'TRY' oldugunu test edin


    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/ ");

        // sag ust bolumde bulunan dil menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilMenusu = driver.findElement(By.xpath("//div[text()='EN']"));
        Actions action = new Actions(driver);
        action.moveToElement(dilMenusu).perform();
        waitFor(3);

        // Change butonuna basiniz
        driver.findElement(By.linkText("Change")).click();

        // DropDown'dan Visible Text kullanarak 'TRY - Turkish Lira' optionunu secin ve yazdırın
        WebElement ddwn = driver.findElement(By.xpath("//select[@id='icp-currency-dropdown']"));
        Select select = new Select(ddwn);
        select.selectByVisibleText("TRY - Turkish Lira");

        // Tüm option'ları yazdırın
        List<WebElement> list = select.getOptions();
        for (WebElement element : list) {
            System.out.println(element.getText());
        }
        System.out.println("list.size() = " + list.size());

        // dropdown'daki tum optionlarin toplam sayısının 68'ye esit oldugunu test edin
        waitFor(3);
        int actualSize = list.size();
        int expectedSize = 68;
        Assert.assertEquals(expectedSize, actualSize);

        // Save Changes butonuna basınız
        driver.findElement(By.xpath("//input[@aria-labelledby='icp-save-button-announce']")).click();

        // arama motoruna 'Kitap' yazip aratin
        waitFor(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Kitap" + Keys.ENTER);

        // ilk cikan urunun parabiriminin 'TRY' oldugunu test edin
        waitFor(2);
        String actualResult = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[2]")).getText();
        assert actualResult.contains("TRY");

    }
}
