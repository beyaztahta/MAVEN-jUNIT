package day07_tb_alert_ifrm;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
     /*
    UTILITIES:
    Utilities tekrar tekrar kullanabilecegimiz methodları ve classları koydugumuz paketin adıdır.
   --- TestBase
   --- Driver
   --- ExcelUtil
   --- Configuration
   Utilities package testcase ler yazılmaz.
   Sadece tekrar kullanılabilecek desdek siniflari(support class) olustururuz.Bu support class lar test case lerin yazılmasini hızlandırır.
     */

    @Test
    public void test01() {
        //Techproeducation sayfasına git.
        //title ın Bootcamps icerdigini test edelim.
        driver.get("https://www.techproeducation.com");
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("Bootcamps"));
    }
}
