package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * <p>
 * 1. LoginTest
 * <p>
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * <p>
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */
public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Find username and Enter username in userfield: 'tomsmith'
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        //Enter valid password in password field:SuperSecretPassword!
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify the text Secure Area
        String expectedMessage = "Secure Area";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='example']//h2"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Text Not matched", actualMessage1, expectedMessage);
        Thread.sleep(4000);

    }

    @Test
    public void verifyTheUsernameErrorMessage() throws InterruptedException {
        //Find username and Enter  invalid username in userfield: 'tomsmith1'
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");
        //Enter valid password in password field:SuperSecretPassword!
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify the error message
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Error message not found", actualMessage1, expectedMessage);
        Thread.sleep(4000);
    }

    @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {
        //Find username and Enter username in userfield: 'tomsmith'
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");
        //Enter invalid password in password field:SuperSecretPassword!
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify the error message
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Error message not found", actualMessage1, expectedMessage);
        Thread.sleep(4000);

    }

    @After
    public void TearDown() {
        closeBrowser();
    }


}
