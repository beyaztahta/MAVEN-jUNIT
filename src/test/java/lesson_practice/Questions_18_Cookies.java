package lesson_practice;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Questions_18_Cookies extends TestBase {
    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test01() {
        //Techproeducation adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies=driver.manage().getCookies();
        System.out.println("cookies sayisi = " + cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for(Cookie c : cookies){
            System.out.println("c.getName() + c.getValue() = " + c.getName()+ " : " + c.getValue());
        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie=new Cookie("mycookie","123456789");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız

        Set<Cookie>cookies2=driver.manage().getCookies();

        System.out.println("cookies.size() = " + cookies2.size());

        for(Cookie d:cookies2){
            System.out.println("d.getName()+ : + d.getValue() = " + d.getName() + " : " + d.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        System.out.println("cookies.size() = " + driver.manage().getCookies().size());
    }
}
