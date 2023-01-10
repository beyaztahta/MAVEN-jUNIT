package day13_seleniumexceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class C04_NullPointerException  {

      WebDriver driver;
      Faker faker;//=new Faker();
    @Test
    public void test01() {
        driver.get("https://techproeducation.com");//java.lang.NullPointerException
    }

    @Test
    public void test02() {
//        faker=new Faker();
        System.out.println("name = " + faker.name().firstName());//java.lang.NullPointerException
    }
}
