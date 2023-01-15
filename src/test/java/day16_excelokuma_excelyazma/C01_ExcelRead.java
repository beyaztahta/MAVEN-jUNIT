package day16_excelokuma_excelyazma;

import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws IOException {
//    WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) >ROW (SATIR)> CELL(VERI HUCRESI)
        String path ="./src/test/java/resources/Capitals.xlsx";
//        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS

//        DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbook= WorkbookFactory.create(fileInputStream);

//        SAYFAYI AC / Sheet1
//     Sheet sheet1= workbook.getSheetAt(0);
     Sheet sheet1= workbook.getSheet("Sheet1"); //Sheet1 isimli sayfayı ac.

//        ILK SATIRA GIT / Row

        Row row1=sheet1.getRow(0);//ilk satıra git.

//        INK SATIRDAKI ILK VERIYI AL

        Cell cell1=row1.getCell(0);//ilk hucredeki datayı al.


//        O VERIYI YAZDIR
        System.out.println("ilk veri = " + cell1);

//       1.SATIR 2.SUTUN
        System.out.println("1.SATIR 2.SUTUN= " + sheet1.getRow(0).getCell(1));

    }
}
