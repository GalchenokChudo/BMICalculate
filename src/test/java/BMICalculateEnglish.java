import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculateEnglish extends BaseTest{
    public String URL = "https://healthunify.com/bmicalculator/";

    @Test
    public void NormalWeightInPoundsSelect(){
        driver.get(URL);

        Select weightSelect = new Select(driver.findElement(By.name("opt1")));
        Select heightFirstSelect = new Select(driver.findElement(By.name("opt2")));
        Select heightSecondSelect = new Select(driver.findElement(By.name("opt3")));

        weightSelect.selectByValue("pounds");
        driver.findElement(By.name("wg")).sendKeys("23");
        heightFirstSelect.selectByValue("3");
        heightSecondSelect.selectByValue("6");
        driver.findElement(By.name("cc")).click();

        //Check index
        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "9.13");

        //Check uk
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(uk, "57.99");

        //Check category
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println(category);
        Assert.assertEquals(category, "Your category is Normal");
    }

    @Test
    public void ObeseWeightInPoundsSelect(){
        driver.get(URL);

        Select weightSelect = new Select(driver.findElement(By.name("opt1")));
        Select heightFirstSelect = new Select(driver.findElement(By.name("opt2")));
        Select heightSecondSelect = new Select(driver.findElement(By.name("opt3")));

        weightSelect.selectByValue("pounds");
        driver.findElement(By.name("wg")).sendKeys("60");
        heightFirstSelect.selectByValue("1");
        heightSecondSelect.selectByValue("11");
        driver.findElement(By.name("cc")).click();

        //Check index
        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "81.07");

        //Check uk
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(uk, "514.81");

        //Check category
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println(category);
        Assert.assertEquals(category, "Your category is Obese");
    }
}
