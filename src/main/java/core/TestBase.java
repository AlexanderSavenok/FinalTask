package core;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static WebDriver driver;
    protected static final String MY_EMAIL = "artemrudzko@tut.by";
    protected static final String MY_PASSWORD = "199999";
    private static final String URL_MAIN_PAGE = "http://automationpractice.com/index.php";

    protected DriverConfiguration driverConfiguration = new DriverConfiguration();

    @BeforeMethod
    public void setUp(){
        driver = driverConfiguration.getWebDriver(URL_MAIN_PAGE);
    }

    @AfterMethod
    public void tearDown(){
        driverConfiguration.closeDriver(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
