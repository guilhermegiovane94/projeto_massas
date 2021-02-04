package factory;

import org.openqa.selenium.chrome.ChromeDriver;

public class driverFactory {
    private static ChromeDriver driver;
    private static String chromeDriverPath = "C:/ChromeDriver/chromedriver.exe";

    public static void startDriver(){
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();
    }
    public static ChromeDriver getDriver(){
        return driver;
    }
    public static void quitDriver(){
        driver.quit();
    }
    public static void accessDriver(String site){
        driver.get(site);
    }
}
