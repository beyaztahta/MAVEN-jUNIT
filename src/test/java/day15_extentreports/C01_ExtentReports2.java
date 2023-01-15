package day15_extentreports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReports2 extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    @BeforeClass
    public static void extentReportsSetUp() {
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + "html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//     ************************RAPORU CUSTOMIZE EDEBILIRIZ ******************************
        extentReports.setSystemInfo("Test Envirament", "Regression Environment");
        extentReports.setSystemInfo("Application", "TechPro Education");
        extentReports.setSystemInfo("Browser", "Chrome Driver");
        extentReports.setSystemInfo("Takim", "QA-6");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi", "Sprint 145");
        extentReports.setSystemInfo("QA Tester", "ElifCALIK");


//   ***************************EKSTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRIZ***************

        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");


//   ****************************RAPOR AYARLARI BITTI*******************************************

        extentReports.attachReporter(extentHtmlReporter);//Raporu projeme ekliyorum.

//           EXTENT TEST OBJESINI OLUSTURDUK
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Raporu");
    }

    @Test
    public void extentReportsTest() {
        extentTest.pass("PASS");
        extentTest.info("BILGILENDIRME NOTU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARI MESAJI");
        extentTest.skip("ATLAMA MESAJI");
        extentTest.fatal("SISTEM COKUS HATASI");

    }

    @AfterClass
    public static void extentReporstTeatDown() {
        extentReports.flush();

    }

    /*
    Dosyada acmak icin sag click:
     Open in -> Explorer
     */
}
