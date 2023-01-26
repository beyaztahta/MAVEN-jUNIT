package lesson_practice;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class C001_Files{
    //Temel amacı kendı sahsı bilgisayarımızda olan dosyanın mevcut olup olmadıgını test etmektir.
    //dosyayı upload etmektir.
    //dosyayı secmektir.
    //Selenium dosyay uzerinde islem yapamaz bu sebepten javadan yardım alırız.

    @Test
    public void test01() throws FileNotFoundException {
        // masaustunde bir text dosyası olusturun


        // masaustundeki text dosyasının varlıgını test edin
        String farkliKisim=System.getProperty("user.home");  //"C:\\Users\\hp"
        String ortakKisim="\\Desktop\\Untitled (1).txt";

        String path=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(path)));//dosyam mevcut mu diye kontrol etitik.

    }



}
