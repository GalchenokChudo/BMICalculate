import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RabotaTutTest extends BaseTest {
    public static final String URL = "https://rabota.by/";

    @Test
    public void GetNameCompany(){
        driver.get(URL);

        driver.findElement(By.cssSelector("[data-qa='search-input']")).sendKeys("QA");
        driver.findElement(By.cssSelector("[data-qa='search-button']")).click();
        driver.findElement(By.cssSelector("[data-qa='vacancy-serp__vacancy-title']")).click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.cssSelector("[data-qa='vacancy-response-link-top']")).getCssValue("Откликнуться");

        driver.switchTo().defaultContent();
    }
}
