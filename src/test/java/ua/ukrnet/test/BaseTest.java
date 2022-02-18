package test.java.ua.ukrnet.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import test.java.ua.ukrnet.configuration.ConfProperties;

import java.time.Duration;

public abstract class BaseTest {
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public static void setup() {
        //определение пути до драйвера и его настройка
        //System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Professional\\Desktop\\UkrNet\\chrome_webdriver\\chromedriver.exe");
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("homePage"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
