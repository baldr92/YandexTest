import org.openqa.selenium.WebDriver;


public class YandexSite {
    WebDriver webDriver;

    public YandexSite(WebDriver driver) {
        webDriver=driver;
    }

    public MarketPage marketPage(){
        return new MarketPage(webDriver);
    }

    public MainPage mainPage(){
        return new MainPage(webDriver);
    }
}
