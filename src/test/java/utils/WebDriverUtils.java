package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\irfan\\Downloads\\KarateTest\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://fego.vmos-demo.com");
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver setDriver(){
        return driver;
    }
}
