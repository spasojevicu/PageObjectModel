import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LogInPage logInPage;

    @BeforeMethod
    public void setUp()
    {
        driver= browserOpen();
        logInPage = new LogInPage(driver);
    }

    @Test
    public void LoginPageIn()
    {
        /*logInPage.setUserName("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickLogin();*/
    }


    @Test
    public void loginInvalidUserName()
    {
        /*logInPage.setUserName("standard_us");
        logInPage.setPassword("secret_sauce");
        logInPage.clickLogin();*/
        Assert.assertEquals(logInPage.getError(), "Epic sadface: Username and password do not match any user in this service");

    }



    @Test
    public void loginInvalidPass()
    {
        /*logInPage.setUserName("standard_user");
        logInPage.setPassword("");
        logInPage.clickLogin();*/
        Assert.assertEquals(logInPage.getError(),"Epic sadface: Password is required");
    }





    @AfterMethod
    public void after()
    {
        driver.quit();
    }


}

