package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverConfiguration {

    private static WebDriver driver;

    public WebDriver getWebDriver(String url) {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : "firefox";
        switch (browser) {
            case "chrome":
                getChromeDriver(url);
            default:
                return getFfDriver(url);
        }
    }

    //return FF Driver with Custom setting for my PC, Sorry!
    public WebDriver getFfDriver(String url) {
        //File pathToBinary = new File("c:\\Program Files (x86)\\Mozilla Firefox38ESR\\firefox.exe");
        //FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        //FirefoxProfile firefoxProfile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WEBDrivers\\FireFox\\geckodriver.exe");
        driver = new FirefoxDriver();
        defaultSettings(driver);
        driver.get(url);
        return driver;
    }

    //return Chrome Driver
    public WebDriver getChromeDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WEBDrivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        defaultSettings(driver);
        driver.get(url);
        return driver;
    }

    private void defaultSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    public void closeDriver(WebDriver driver) {
        driver.quit();
    }

}
