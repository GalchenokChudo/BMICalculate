import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculateTest {

    @Test
    public void normalCategoryShouldBeShown(){
        //WebDriver = Browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver2");


        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //Ввести вес
        driver.findElement(By.name("wg")).sendKeys("59");
        //Ввести рост
        driver.findElement(By.name("ht")).sendKeys("164");
        //Проверить название категории
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println(category);
        Assert.assertEquals(category,"Your category is Normal");

        //Проверить индекс




        driver.quit();

        //WebElement = element on the page
    }

}
