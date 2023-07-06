import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest  extends BaseTest {

    LogInPage logInPage;
    InventoryPage inventoryPage;

    CartPage cartPage;

    CheckoutStepOnePage checkoutStepOnePage;

    @BeforeMethod
    public void Setup() {
        driver = browserOpen();
        logInPage = new LogInPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        logInPage.loginPage();
    }

    @Test
    public void AddToCart() {
        /*logInPage.setUserName("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickLogin();*/

        inventoryPage.clickBackpack();
        inventoryPage.clickLight();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(), "2");

    }

    @Test
    public void removeProduct()
    {
        /*logInPage.setUserName("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickLogin();*/

        inventoryPage.clickBackpack();
        inventoryPage.clickLight();
        inventoryPage.removeBackpack();

        Assert.assertEquals(inventoryPage.getCartNumber(),"1");


    }

    @Test
    public void sortProduct()
    {
        /*logInPage.setUserName("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickLogin();*/

        inventoryPage.sortProducts("Price (high to low)");

        Assert.assertEquals(inventoryPage.getPrice(),"$49.99");

    }

    @Test public void sortProductsByLowPrice()
    {
       /* logInPage.setUserName("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickLogin();*/

        inventoryPage.sortProducts("Price (low to high)");

        Assert.assertEquals(inventoryPage.getPrice(),"$7.99");
    }

    @Test
    public void BuyProductsToTheEnd()
    {
        inventoryPage.clickLight();
        inventoryPage.clickBackpack();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.setForm("Uros","Spasojevic","11000");
        checkoutStepOnePage.clickFinish();
    }

    @Test
    public void BuyProductsWithoutData()
    {
        inventoryPage.clickLight();
        inventoryPage.clickBackpack();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.setForm("","","");

        Assert.assertEquals(checkoutStepOnePage.getError(),"Error: First Name is required");

    }
    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
