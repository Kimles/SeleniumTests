import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Chrome {

    private static WebDriver driver;

    public WebDriver getChromeDriver() {
        if (driver != null)
            return driver;

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }

    public void openURL(String url) {
        getChromeDriver().get(url);
    }
}
