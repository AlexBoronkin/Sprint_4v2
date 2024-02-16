import Page_Object.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Page_Object.MainPage.orderButtonPageMiddle;
import static Page_Object.MainPage.orderButtonPageTop;
import static org.junit.Assert.assertEquals;


public class PositiveOrderTest {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    public void PositiveOrderTestTopButton() {
        driver.findElement(orderButtonPageTop).click();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.firstPageOfOrder("Александр", "Боронкин", "Лестева 21к2", "89999133632");
        orderPage.secondPageOfOrder("Второй подъезд");
        Boolean isButtonCheckOrderPresent = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button")) != null;
        assertEquals(true, isButtonCheckOrderPresent);
    }

    @Test
    public void PositiveOrderTestMiddleButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@class = 'Button_Button__ra12g']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']")));
        driver.findElement(orderButtonPageMiddle).click();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.firstPageOfOrderKomsomol("Вероника", "Брусника", "Автозаводская 29", "89999786543");
        orderPage.secondPageOfOrderFiveDays("Быстрее скорее надо есть самокат");
        Boolean isButtonCheckOrderPresent = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button")) != null;
        assertEquals(true, isButtonCheckOrderPresent);


    }





}
