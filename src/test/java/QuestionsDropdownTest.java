import Page_Object.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Page_Object.MainPage.*;
import static org.junit.Assert.*;




@RunWith(Parameterized.class)
public class QuestionsDropdownTest {


    private final By question;
    private final String message;

    public QuestionsDropdownTest(By question, String message) {
        this.question = question;
        this.message = message;
    }

    @Parameterized.Parameters
            public static Object[][] getMessage() {
        return new Object[][] {
                {howMuch, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {fewScooters, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {rentingTime, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {todayOrder, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {changeOrderTime, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {charger, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {cancelOrder, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {liveFar, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void questionsDropdownTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id = 'accordion__heading-0']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(question));
        driver.findElement(question).click();
        String actualText = driver.findElement(By.xpath(".//p[text() = '"+ message +"']")).getText();
        assertEquals(message, actualText);
        driver.quit();
    }




}
