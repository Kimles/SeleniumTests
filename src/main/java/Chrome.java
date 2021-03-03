import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Chrome {

    private static WebDriver driver;
    private String CHROME_PATH = "C:/chromedriver/chromedriver.exe";

    public WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }

    public void openURL(String url) {
        getChromeDriver().get(url);
    }
}
