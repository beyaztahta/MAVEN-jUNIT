package day09_multiplewindows_authentication_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest() {

//        1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        String windowHandle1 = driver.getWindowHandle();

//        2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.amazon.com");//1.Yeni pencere olusturur ve 2. oraya gecis yapar.
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//        3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        //Driver nerede? LinkedIn de
        //Techproeducation sayfasına gitmel icin: driver.switchTo().window(techpro handle)
        driver.switchTo().window(windowHandle1);
        waitFor(3);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

    }

}
