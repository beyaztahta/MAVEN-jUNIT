package day17_Jsexecutors;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutors_Click extends TestBase {

    //clickByJSTest
    //Techpro education ana sayfasina git
    //LMS LOGIN elementine tikla
    //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et


    @Test
    public void clickByJSTest() {
        driver.get("https://techproeducation.com");
        waitFor(3);

        WebElement login = driver.findElement(By.linkText("LMS LOGIN"));
        clickJS(login);
        waitFor(2);

        Assert.assertEquals("https://techproeducation.com", driver.getCurrentUrl());
    }
}
