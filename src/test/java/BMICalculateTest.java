import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculateTest extends BaseTest{
    @Test
    public void normalCategoryShouldBeShown() {
        //Enter weight
        driver.findElement(By.name("wg")).sendKeys("59");
        //Enter height
        driver.findElement(By.name("ht")).sendKeys("164");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println(category);
        Assert.assertEquals(category, "Your category is Normal");

        //Check index
        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "21.94");

        //Check uk
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(uk, "139.32");
    }

    @Test
    public void OverweightCategoryShouldBeShown() {
        //Enter weight
        driver.findElement(By.name("wg")).sendKeys("67");
        //Enter height
        driver.findElement(By.name("ht")).sendKeys("163");
        //Click calculate button
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println(category);
        Assert.assertEquals(category, "Your category is Overweight");

        //Check index
        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "21.94");

        //Check uk
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(uk, "139.32");
    }
}
