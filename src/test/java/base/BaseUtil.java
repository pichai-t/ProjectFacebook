package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseUtil {
    private static ThreadLocal<WebDriverWait> waiter = new ThreadLocal<>();
    private static ThreadLocal<Actions> actions = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static String url = "https://www.facebook.com/";
    public static String fileAccount = "C://Users//kawin.thi//Desktop//Facebook//account.csv";


    public static WebDriver getDriver() {
        return drivers.get();
    }
    public static WebDriverWait getWaiter() {
        return waiter.get();
    }
    public static Actions getActions() {
        return actions.get();
    }
    public static void initialize(String browserName, Integer implicitlyWait, Integer waiterTime) {

        createDriver(browserName);
        drivers.get().manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        createWaiter(waiterTime);
        createActions();
    }

    public static void createDriver(String browserName) {
        removeDriver();
        WebDriver newDriver;
        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("Chrome");
            System.setProperty("webdriver.chrome.driver", "C://Users//kawin.thi//Desktop//Facebook//driver//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("enable-automation");
            //  options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            newDriver = new ChromeDriver(options);
            System.out.println("Chrome has been open");
        } else {
            System.out.println("Firefox");
            newDriver = new FirefoxDriver();
        }
        drivers.set(newDriver);
    }

    public static void removeDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
        }
        drivers.remove();
    }

    public static ExpectedCondition<Boolean> textIsEqual(final String firstText, final String secondText) {
        return driver -> firstText.equals(secondText);
    }

    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout * 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createWaiter(int timeout) {
        waiter.set(new WebDriverWait(drivers.get(), timeout));
    }

    public static void createActions() {
        actions.set(new Actions(drivers.get()));
    }
}
