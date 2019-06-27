import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage {
    WebDriver driver;
    WebDriverWait webDriverWait;


    @FindBy(xpath = "//span[contains(text(), 'Все категории')]")
    private WebElement categoryBtn;

    @FindBy(xpath = "//a[contains(text(), 'Электроника')]")
    private WebElement electonics;

    @FindBy(xpath = "//a[text()='Мобильные телефоны']")
    private WebElement mobilePhones;

    @FindBy(xpath = "//input[@id='glpriceto']")
    private WebElement priceUntil;

    @FindBy(xpath = "//input[@id='glpricefrom']")
    WebElement priceFrom;

    @FindBy(xpath = "//legend[contains(text(), 'Производитель')]//following::ul[1]//span[contains(text(), \"Apple\")]")
    WebElement selectIphones;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchWithField;

    //  //div[contains(text(), 'Сортировать')]//following-sibling:*
    @FindBy(xpath = "/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div")
    WebElement content;

    @FindBy(xpath = "//span[text()='Найти']/parent::*")
    WebElement find;





    public MarketPage(WebDriver webDriver) {
        driver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }


    public void clickOnAllCategories(){
        categoryBtn.click();
    }

    public void chooseMobilePhones(){
        electonics.click();
    }

    public void goToPhones(){
        mobilePhones.click();
    }

    public void choosePriceUntil(String yourPrice){
        priceUntil.sendKeys(yourPrice);
    }
    public void choosePriceFrom(String yourPrice){
        priceFrom.sendKeys(yourPrice);
    }
    public void chooseAllIphones(){
        selectIphones.click();
    }
    public void findSmth(String goods){
        searchWithField.clear();
        searchWithField.sendKeys(goods);
    }
    public void checkVisibility(){
        content.isDisplayed();
    }
    public void pressFind(){
        find.click();
    }

}
