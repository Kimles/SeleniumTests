import org.junit.Test;

public class SeleniumTestSuite {

    public Chrome chrome = new Chrome();

    @Test
    public void Test () {
        chrome.openURL("https://google.com");
    }

}
