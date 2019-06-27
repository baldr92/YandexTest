import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    WebDriverWait webDriverWait;


    @FindBy(xpath = "//a[contains(text(),'Маркет')]")
    WebElement marketBtn;

    public MainPage(WebDriver webDriver) {
        driver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void goToMarket(){
        marketBtn.click();
    }
}
