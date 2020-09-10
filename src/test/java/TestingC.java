
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;


public class TestingC {

    private static ChromeDriver chrome;
    private static FirefoxDriver firefox;
    @BeforeClass
    public static void  before(){
        File file1 = new File("C:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
        File file2=new File("C:\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", file2.getAbsolutePath());
        chrome=new ChromeDriver();
        firefox=new FirefoxDriver();
    }
    @Test
    public void test_01(){
        chrome.get("https://www.walla.co.il/");
        firefox.get("https://www.ynet.co.il/home/0,7340,L-8,00.html");
    }
    @Test
    public void test_02(){
        String title="וואלה! NEWS - האתר המוביל בישראל - עדכונים מסביב לשעון";;
        chrome.navigate().refresh();
        Assert.assertEquals(chrome.getTitle(),title);
    }
    @Test
    public void test_03(){
        String site="https://www.walla.co.il/";
        Assert.assertEquals(chrome.getCurrentUrl(),site);
    }
    @Test
    public void test_04(){
        chrome.get("https://translate.google.com/");
        WebElement we=chrome.findElement(By.id("source"));
        WebElement web=chrome.findElementByXPath("//*[@id=\"source\"]");
        System.out.println(we);
        System.out.println(web);
    }
    @Test
    public void test_05(){
        firefox.get("https://www.youtube.com/");
        WebElement we=firefox.findElement(By.id("logo-icon-container"));
        System.out.println(we);
    }
    @Test
    public void test_06(){
        firefox.get("https://www.selenium.dev/");
        WebElement we= firefox.findElement(By.name("search"));
        System.out.println(we);
        we.sendKeys("selenium");


    }
    @Test
    public void test_07(){
        chrome.get("https://www.amazon.com/");
        String title="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(chrome.getTitle(),title);
        chrome.findElement(By.id("twotabsearchtextbox")).sendKeys("leather shoes");

    }
    @Test
    public void test_08(){
        chrome.get("https://translate.google.com/");
        chrome.findElement(By.id("source")).sendKeys("כלב");
    }
    @Test
    public void test_09(){
        chrome.get("https://www.youtube.com/");
        // chrome.findElement(By.id("search")).sendKeys("eyal golan");
        chrome.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("eyal golan");

        chrome.findElement(By.id("search-icon-legacy")).click();

    }
    @Test
    public void test_10() {
        chrome.get("https://dgotlieb.github.io/Controllers/");
        List<WebElement> list = chrome.findElements(By.name("group1"));
        for (WebElement we : list) {
            if (we.getAttribute("value").equals("Cheese")) {
                we.click();
            }
            System.out.println(we.getAttribute("value"));
        }
        Select s = new Select(chrome.findElement(By.name("dropdownmenu")));
        s.selectByValue("Cheese");
        for (int i = 0; i < s.getOptions().size(); i++) {
            System.out.println(s.getOptions().get(i).getText());
        }
    }
    @Test
    public void test_11(){
        chrome.get("https://www.facebook.com/");
        chrome.findElement(By.name("email")).sendKeys("ab@gmail.com");
        chrome.findElement(By.id("pass")).sendKeys("123456");
        chrome.findElement(By.name("login")).click();
    }
    @Test
    public void test_12() {
        chrome.get("https://dgotlieb.github.io/WebCalculator/");
        chrome.findElement(By.id("seven")).getSize();
        chrome.findElement(By.id("six")).isDisplayed();
        String num1 = "5";
        chrome.findElement(By.id("three")).click();
        chrome.findElement(By.id("plus")).click();
        chrome.findElement(By.id("two")).click();
        chrome.findElement(By.id("equal")).click();
        String num2 = chrome.findElement(By.id("screen")).getText();
        Assert.assertEquals(num2, num1);
    }
    @Test
    public void test_13() {
        chrome.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(chrome.findElement(By.id("two")).getRect().getHeight());
        System.out.println(chrome.findElement(By.id("six")).getRect().getWidth());
    }

    //14
    @Test
    public void test_14() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chrome = new ChromeDriver(chromeOptions);
    }



    @AfterClass
    public void afterAll() {
        chrome.quit();
        firefox.quit();
    }

}

