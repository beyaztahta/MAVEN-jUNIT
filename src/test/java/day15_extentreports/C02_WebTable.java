package day15_extentreports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {

    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

private static Logger logger= LogManager.getLogger(C02_WebTable.class.getName());
    @Test
    public void tablePrint01() {
        //Task 1.
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        //System.out.println("TABLE1 VERİLERİ");
        logger.info("TABLE1 VERILERI");
        System.out.println(table1);


        List<WebElement> tableAllData = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement tableElement : tableAllData) {
            System.out.println("tableElement.getText() = " + tableElement.getText());
        }

    }

    @Test
    public void rowTest() {
        //Task 2.
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement>row3=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td "));
        for (WebElement row:row3) {
            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void sonTest() {
        //Task 3.
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement>sonRow=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        for (WebElement son :sonRow){
            System.out.println("son.getText() = " + son.getText());
        }
        //sonRow.stream().forEach(WebElement-> System.out.println(WebElement.getText()));
    }

    @Test
    public void sutunTest() {
        //Task 4
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement>sutun=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        for (WebElement veri :sutun){
            System.out.println( veri.getText());
        }

    }



    public void printData(int row,int column){
        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }
    @Test
    public void test5() {
        //Task 5 :
        printData(2,3);//fbach@yahoo.com
        printData(1,4);//$50.00
        printData(2,5);//http://www.frank.com
    }



}
