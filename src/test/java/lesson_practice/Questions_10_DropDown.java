package lesson_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Questions_10_DropDown extends TestBase {
    @Test
    public void test01() {
        //www.amazon.com gidin.
        driver.get("https://www.amazon.com ");

        //Dropdown menuyu yazdıralım.
        List<WebElement> baby = driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
        baby.stream().forEach(t -> System.out.println(t.getText()));
/*
        Select ddwn=new Select(baby);

        for (WebElement w:ddwn.getOptions){
          System.out.println(w.getText());
          }
       ddwn.selectByVisibleText("Baby");
    }
    */
        //Dropdown menusunden baby aratalım.arama menusunden milk aratalım.
        driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).
                              sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);



        //https://www.cars.com/

    }
}
