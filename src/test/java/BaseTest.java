import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    public static final String URL = "https://healthunify.com/bmicalculator/";

    @BeforeMethod
    public void Precondition() {
        //WebDriver = Browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver2");

        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
