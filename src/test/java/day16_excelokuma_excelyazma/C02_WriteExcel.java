package day16_excelokuma_excelyazma;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        //    WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) >ROW (SATIR)> CELL(VERI HUCRESI)


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

//      ILK SATIR 3.SUTUNU CREATE ET.
        Cell cell3 = row1.createCell(2);//hucreyi olusturduk.Daha yazmadık.

        cell3.setCellValue("NUFUS");//hucrenın ıcıne yazıyı yazdık.

//       2.SATIR 3.SUTUNA 45000 YAZDIRALIM

        sheet1.getRow(1).createCell(2).setCellValue(450000);

//       3.SATIR 3.SUTUNA 350000 YAZDIRALIM

        sheet1.getRow(2).createCell(2).setCellValue(350000);

//      KAYDET: KAYIT FILE OUTPUT STREAM ILE YAPILIR.
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);


    }
}
