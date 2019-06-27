import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class YandexTests {
    WebDriver webDriver;
    YandexSite website;
    //By by = By.xpath("//img[contains(@title, 'Смартфон Apple')][1]");

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div")
    WebElement checker;


    @FindBy(xpath = "//span[contains(text(), 'Все категории')]")
    private WebElement categoryBtn;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://yandex.ru/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        website = new YandexSite(webDriver);

    }

    @Test
    public void testMainPageAndMarket() {
        website.mainPage().goToMarket();
        webDriver.getCurrentUrl();
        System.out.println( webDriver.getCurrentUrl());
        webDriver.navigate().refresh();
        website.marketPage().clickOnAllCategories();
        website.marketPage().chooseMobilePhones();
        website.marketPage().goToPhones();
        website.marketPage().choosePriceFrom("50000");
        website.marketPage().choosePriceUntil("65000");
        website.marketPage().chooseAllIphones();
        }

     @Test
     public void testSearchFieldWitValue(){
         website.mainPage().goToMarket();
         webDriver.getCurrentUrl();
         System.out.println( webDriver.getCurrentUrl());
         webDriver.navigate().refresh();
         website.marketPage().findSmth("Iphone XR 64 gb");
         website.marketPage().pressFind();
         //Assert.assertEquals(true ,checker.isDisplayed());
         try {
             webDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div"));
         } catch (NoSuchElementException e){
             System.out.println("No content");
         }
     }


    @After
    public void cleanUp(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }

}
