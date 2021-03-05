import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SeleniumTestSuite {

    public String URL = "https://demoqa.com/forms";
    public static Chrome chrome = new Chrome();

    public void init() {
        chrome.openURL(URL);
        chrome.getChromeDriver().findElement(By.xpath("//span[text()='Practice Form']")).click();
    }

    public void submit() {
        WebElement button = chrome.getChromeDriver().findElement(By.id("submit"));
        ((JavascriptExecutor) chrome.getChromeDriver()).executeScript("arguments[0].scrollIntoView(true)", button);
        button.click();
    }

    @Test
    public void fullRequiredFieldsAndSubmit() {
        init();
        chrome.getChromeDriver().findElement(By.id("firstName")).sendKeys("Olesya");
        chrome.getChromeDriver().findElement(By.id("lastName")).sendKeys("Kim");
        chrome.getChromeDriver().findElement(By.id("userNumber")).sendKeys("9223334411");

        chrome.getChromeDriver().findElement(By.xpath("//label[text()='Female']")).click();

        submit();

        Assert.assertEquals("Olesya Kim",
                chrome.getChromeDriver().findElement(By.xpath("//td[text()='Student Name']//following-sibling::td")).getText());
        Assert.assertEquals("Female",
                chrome.getChromeDriver().findElement(By.xpath("//td[text()='Gender']//following-sibling::td")).getText());
        Assert.assertEquals("9223334411",
                chrome.getChromeDriver().findElement(By.xpath("//td[text()='Mobile']//following-sibling::td")).getText());
    }

    @Test
    public void checkSelectedValueInList() {
        init();

        WebElement field = chrome.getChromeDriver().findElement(By.id("subjectsInput"));
        field.sendKeys("E");

        WebElement selectElem = chrome.getChromeDriver().findElement(By.xpath("//div[contains(text(), 'English')]"));
        selectElem.click();

        WebElement selectedValue = chrome.getChromeDriver().findElement(By.xpath("//div[@id='subjectsContainer']//div[text()='English']"));

        Assert.assertEquals("English", selectedValue.getText());
    }


    @Test
    public void checkColorFieldsFilled() {
        String green = "rgb(40, 167, 69)";

        init();

        chrome.getChromeDriver().findElement(By.id("firstName")).sendKeys("Olesya");
        chrome.getChromeDriver().findElement(By.id("lastName")).sendKeys("Kim");
        chrome.getChromeDriver().findElement(By.id("userNumber")).sendKeys("9223334411");

        submit();

        chrome.getChromeDriver().findElement(By.xpath("//label[text()='Female']")).click();


        String firstNameColor = chrome.getChromeDriver().
                findElement(By.cssSelector("input#lastName.form-control:valid")).getCssValue("border-color");
        Assert.assertEquals(green, firstNameColor);

        String lastNameColor = chrome.getChromeDriver().
                findElement(By.cssSelector("input#lastName.form-control:valid")).getCssValue("border-color");
        Assert.assertEquals(green, lastNameColor);

        String userNumberColor = chrome.getChromeDriver().
                findElement(By.cssSelector("input#userNumber.form-control:valid")).getCssValue("border-color");
        Assert.assertEquals(green, userNumberColor);
    }

}
