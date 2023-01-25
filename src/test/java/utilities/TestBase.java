package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class TestBase {
    //abstract yapmamızın sebebi: bu sınıfın objesini olusturmak istemiyoruz.Yani TestBase testbase=new TestBase(); yapılamaz.Amacım bu
    //bu sınıfı extends etmek ve hazır methodlarını kullanmaktır.
    protected static WebDriver driver;//driver objesini olusturduk.Burada public veya protected kullanılır,sebebi ise diger child classlardan cagırılmasıdır.Cunku inheritanse olacak.


    /*
    1- <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports --> pom.xml'e yüklemek
    2- Eğer extentReport almak istersek ilk yapmamız gereken ExtentReport class'ından bir obje oluşturmak
    3- HTLM formatında düzenleneceği için ExtentHtmlReporter class'ından obje oluşturmak
     */
    protected ExtentReports extentReports;//Raporlamayı başlatırız
    protected ExtentHtmlReporter extentHtmlReporter;//Raporumu HTLM formatında düzenler
    protected ExtentTest extentTest; //Test aşamalarına extentTest objesi ile bilgi ekleriz
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @After
    public void tearDown() {
        driver.quit();

    }



    //    MULTIPLE WINDOW

    /*
    1 perametre alır : Gecis yapmak istedigim sayfanın baslıgı(title)
        ORNEK:
          driver.get("https://the-internet.herokuapp.com/windows");
          switchToWindow("New Window");
           switchToWindow("The Internet")
     */
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //windowNumber sıfır (0)'dan başlıyor.
    //    index numarasini parametre olarak alir ve o indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber) {

        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*   HARD WAIT:
   @param : second
       */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToWindow_URL(String url) {
        for (String w : driver.getWindowHandles()) {
            driver.switchTo().window(w);
            if (driver.getCurrentUrl().equals(url)) return;
        }
    }

    public WebElement selectFromDropdown(WebElement dropdown, String myOption) {
        Select option = new Select(dropdown);
        option.selectByVisibleText(myOption);
        return option.getFirstSelectedOption();
    }


    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }

    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions() {
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions() {
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }


    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }


    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }


    //   SCREENSHOTS
    //BU FULL EKRAN GORUNTUSU:
    public void takeScreenShotOfPage() throws IOException {
//        1. Take screenshot
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));
    }

    //LOCAT ALDIGIMIZ ELEMANIN EKRAN GORUNTUSU :

    public void takeScreenshotOfElement(WebElement element) throws IOException {
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));
    }


    //JS EXECUTE SCROLLINTOVIEW
    //asagıya ve yukarıya iki tarafa da kaydırma islemini gerceklestirir.
    public void scrollIntoViewJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //SAYFANIN EN ASGISINA IN
    //Bu method ile sayfanın en asagısına inebiliriz.
    public void scrollEndJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //Bu method ile sayfanın en ustune cıkabiliriz.
    public void scrollTabJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    //Bu method ile belirli bir elemente JS executor ile tıklanabilir.

    public void clickJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    //Bu method ile belirli bir elemanın degerini degistirebiliriz.Yeni girmis oldugumuz metni elemente yazdırır.
    //   gitmis oldugum metni elemente yazdirir
//    bu method sendKeys metotuna bir alternatifdir.
//    sendKeys oncelikli tercihimizdir
    public void typeWithJS(WebElement element, String metin) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + metin + "')", element);

    }

    //Bu method ile input tagındaki elementeindeki degerleri alırız.
    //    input elementindeki degerleri(value) al
    //   Belirli bir WebElement'in id değerini String olarak alır ve value attribute değerini String olarak döndürür
    //    return
    //    document HTML'E GIT
    //    .getElementById('" + idOfElement + "') ID'si VERILEN ELEMENTI BUL
    //    .value")
    //    .toString();
    public void getAttributeValueJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String metin = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println("Kutudaki input degeri: " + metin);

        //----value yu orada id, class, name gibi attribute leride kullanabiliriz.

    }
               //NOTE:
  //    document.querySelector("p").value;  --->TAG KULLANILABILIR.
  //    document.querySelector(".example").value;  --->CSS DEGERI KULLANILABILIR.
  //    document.querySelector("#example").value;  --->CSS DEGERI KULLANILABILIR.



    //EXCELDEN DATA OKUMAK ICIN:
    public String getDataFromExcel(String path,String pageName,int row,int cell) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return workbook.getSheet(pageName).getRow(row).getCell(cell).toString();
    }

    //EXCELE DATA GİRMEK:
    public void setDataToExcel(String path,String pageName,int row,int cell,String data){

        FileInputStream fis= null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook= null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        workbook.getSheet(pageName).createRow(row).createCell(cell).setCellValue(data);

        FileOutputStream fos= null;
        try {
            fos = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //EXCELDEN DATA SİLMEK:
    public void removeDataExcel(String path,String pageName,int rowNumber,int cellNumber){
        FileInputStream fis= null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook= null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheet(pageName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        row.removeCell(cell);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


  //ILK RAPOR OLUSTUR
    public void getExtentReport(){
        //----------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ExtentReports/htmlreport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Elif");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Sonucu");
        extentTest=extentReports.createTest("Extent Tests","Test Raporu");

    }

   //RAPORU KAPAT.
    public void closeExtentReport(){
        extentReports.flush();
    }
}
