package lesson_practice;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C002_ExcelWrite extends TestBase {

    @Test
    public void test01() throws IOException {
        //Data isimli excel dosyasına yeni kullanıcı adı ve password ekliyelim

        String dosyaYolu = "C:\\Users\\hp\\Desktop\\data.xlsx";
        setDataToExcel(dosyaYolu, "Sayfa1", 3, 0, "yeni");


    }

    @Test
    public void baslıkTest02() throws IOException {

        //Yeni bir methodda kullanıcı bilgileri başlığını silelim
        String dosyaYolu = "C:\\Users\\hp\\Desktop\\data.xlsx";
        //removeDataExcel(dosyaYolu, "Sayfa1", 3, 0);
        removeDataExcel(dosyaYolu, "Sayfa1", 4, 1);
        removeDataExcel(dosyaYolu, "Sayfa1", 5, 1);

    }


}
