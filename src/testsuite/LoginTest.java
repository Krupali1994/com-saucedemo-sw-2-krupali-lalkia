package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        //Find the password field and type the password to password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the login button element and click
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        String expectedText = "Products";
        //Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//span"));
        String actualText = actualTextElement.getText();

        //Verify expected and actual text
        Assert.assertEquals("Products", expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Find the username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        //Find the password field and type the password to password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Total number of products = " + driver.findElement(By.xpath("//div[@class='inventory_item_name ']")).getSize());

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
