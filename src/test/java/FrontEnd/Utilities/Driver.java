package FrontEnd.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Driver {
    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver get() {
        // Test
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    BrowserUtils.waitForPageToLoad(Duration.ofSeconds(10));
            }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}