import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BMICalculateTest {

    @Test
    public void normalCategoryShouldBeShown(){
        //WebDriver = Browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver2");


        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //Enter weight
        driver.findElement(By.name("wg")).sendKeys("59");
        //Enter height
        driver.findElement(By.name("ht")).sendKeys("164");
        //Check name of category
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println(category);
        Assert.assertEquals(category,"Your category is Normal");

        //Check index
        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index,"21.94");

        //Check uk
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(uk,"139.32");

        driver.quit();
    }

//    @AfterTest(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//
//        }
//    }


}
