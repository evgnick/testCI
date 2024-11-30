import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver(Utils.getChromeOptions());
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='app_logo']")).getText(), "Swag Labs");

        driver.quit();
    }
}
