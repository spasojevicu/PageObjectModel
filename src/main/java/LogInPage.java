import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage  extends BasePage {
    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = ".error-message-container h3")
    WebElement error;

    public LogInPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String name) {
        userName.sendKeys(name);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.submit();
    }

    public void loginPage()
    {
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }

    public String getError() {
     return error.getText();
    }
}

