package day16_excelokuma_excelyazma;

import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws IOException {
//    WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) >ROW (SATIR)> CELL(VERI HUCRESI)
        String path = "./src/test/java/resources/Capitals.xlsx";
//        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS

//        DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        SAYFAYI AC / Sheet1
//     Sheet sheet1= workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheet("Sheet1"); //Sheet1 isimli sayfayı ac.

//        ILK SATIRA GIT / Row

        Row row1 = sheet1.getRow(0);//ilk satıra git.

//        INK SATIRDAKI ILK VERIYI AL

        Cell cell1 = row1.getCell(0);//ilk hucredeki datayı al.


//        O VERIYI YAZDIR
        System.out.println("ilk veri = " + cell1);

//       1.SATIR 2.SUTUN
        System.out.println("1.SATIR 2.SUTUN= " + sheet1.getRow(0).getCell(1));

//       3.SATIR 1.SUTUN yazdır ve o verinin France oldugunu dogrula.
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println("cell3-1 = " + cell31);
        Assert.assertEquals("France", cell31);

//       EXCELDEKI TOPLAM SATIR SAYISINI BUL.
        int sumRow = sheet1.getLastRowNum() + 1;//son satır numarası.index 0 dan baslıyor.
        System.out.println("sumRow = " + sumRow);//11

//       KULLANILAN TOPLAM SATIR SAYISINI BULUN
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println("kullanilanToplamSatirSayisi = " + kullanilanToplamSatirSayisi);//1 den baslıyor.

//      COUNTRY,CAPITALS KEY VE VALUE LARI MAP A ALIP PRINT EDELİM.
        //{{USA,D.C.}},{{FARANCE,PARIS}} .....

        //Variable olusturalım. Bu variable exceldeki country capital verilerini tutacak.

        Map<String, String> ulkeBaskentleri = new HashMap<>();
        for (int satirSayisi = 1; satirSayisi < kullanilanToplamSatirSayisi; satirSayisi++) {
            String country=sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital=sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
            //ulkeBaskentleri.put(sheet1.getRow(satirSayisi).getCell(0).toString(),sheet1.getRow(satirSayisi).getCell(1).toString());
        }
        System.out.println(ulkeBaskentleri);
    }
    /*
    Excel Okuma
 ----  Excelden veriyi okumak icin hangi sırayla gitmem gerekir
       workbook > sheet > row > cell
 ----  Bir exceldeki toplam satir sayısı nasıl bulunur?
     getLastROwNumber
     Yada
     getPhysicalNumberOfRows- toplam kullanılan satir sayısı
-----   Excel Yazdırma
    Microsoft dosyalari ile iletişime gecmek icin apache poi dependency’s kullanılır
-----   Su anki projende exceli nasil kullandin?
     Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz. Bu datalari test caselerde kullanmak icin excelden çekiyorum
     ve test caselerimde kullanıyorum.
     Datalari excelde tutmanın faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.
     */
}
