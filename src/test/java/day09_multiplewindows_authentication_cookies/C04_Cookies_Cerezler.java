package day09_multiplewindows_authentication_cookies;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies_Cerezler extends TestBase {

    @Test
    public void cookiesTest() {
        //Amazona git
        driver.get("https://www.amazon.com");

        //1.toplam cookie sayisini bul
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies sayisi = " + cookies.size());

        //3. Bir Cookie yi smiyle bul
        //tum cookileri bir yazdıralım.
        //cookies.stream().forEach(t -> System.out.println(t.getName()));-->lambdalı cozum
        for(Cookie cookie : cookies){
            System.out.println(cookie);// burada cookie nin tum bilgilerini yazdirdik.
            System.out.println("cookie isimleri = " + cookie.getName());
        }

        System.out.println("Cookie i ismiyle cagırıyoruz.= " + driver.manage().getCookieNamed("i18n-prefs"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookies=new Cookie("Cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookies);
        System.out.println("Yeni cookie sayisi "+"  "+driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("i18n-prefs");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        System.out.println("TUM COOKIES LERI SİLDİM YENI COOKIES SAYISI: "+ driver.manage().getCookies().size());
    }
}
