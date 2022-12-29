package day06_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DropDown_01 {

    WebDriver driver;

    //Eger test sınıfında birden fazla method olusturulmussa, @Before kullanılır.
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Given kullanıcı:https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    /*Selenium da Select diye bir class vardır sadece dropdownı bulmak icin kullanılır.Aslında bir listedir.
     Dropdown da sembol olabilir.Sitelerde farklı olabilir.Ozel bir web elementidir.En kullanıslı olan da selectByVisibleText("10");
    html de multiple varsa bu bize birden fazla cok secenek saglar.select>optiontagları..
     */
    @Test
    public void selectByIndexTest() {

        //Dogum yılı, dogum ayı ve dogum gununu secelim.2000,January,10

        //1.LOCATE:
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2.ADIM:Select objesi olustur.
        Select yearddn = new Select(year);

        //3.ADIM:objeyi cagır.3 farklı yolla yapılabilir.
        yearddn.selectByIndex(22);    //--->selectByIndex  secenek sırasıdır.0 dan baslar.


        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthddn = new Select(month);
        monthddn.selectByValue("0"); //--->selectByValue value ile secim yapılabilir,string tir.January nin valuesi  0 bu sebepten oraya yazdık

        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayddn = new Select(day);
        dayddn.selectByVisibleText("10"); //--->case sensitivedir(yani buyuk kucuk harfe duyarlıdır.)selectByVisibleText text yazısı ne ise onu kabul eder,stringtir.En cok kullanılan yontemdir.

    }

    @Test
    public void printAllTest() {
        //Tum eyaletleri print edelim.
        WebElement eyalet = driver.findElement(By.xpath("//select[@id='state']"));
        Select eyaletDropdown = new Select(eyalet);

        List<WebElement> list = eyaletDropdown.getOptions();
        for (WebElement w : list) {
            System.out.println(w.getText());
        }
        // list.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptions() {

        //State dropdowndaki  varsayılan secili secenegin Select a state  oldugunu verify edelim.
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String varsayılanText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals("Select a State", varsayılanText);
    }

    @After
    public void tearDown(){
        driver.close();
    }

/*
    INTERVIEW SORULARI
    1.What is dropdown?Dropdown nedir?
  -->  Dropdown liste olusturmak icin kullanılır.Acılır menudur.

    2.How to handle dropdown elements?Dropdown nasıl handle edilir?
  --> Dropdown locate edilir.
  --> Select objesi olustururum.
  --> Select objesişle istedigim secenegi secerim
  NOT:select olusturma nedenim,dropdownların Select classı ile olusturulması.

  3.Tum dropdown seceneklerini nasıl print ederiz?
  --> Tum dropdown elementlerini getOptions()methodu ile listeye koyarız.
  --> Sonra loop ile yazdırabiliriz.
  Select objesini kullanarak belli secimler yapabiliriz. Aynı zamanda birden fazla secenekleri tum listeye alabiliriz.

  4.Bir secenegin secili oldugunu otomate etmek icin ne yapılır?
  Ornek:Gun olarak 10 sectik ama ya secilmediyse?
  getFirstSelectedOption():Bu method secili olan secenegi return ederve bunu kullanarak sadece birini istiyorse yazdırabiliriz.(getText().getFirstSelectedOption())

     */

}
