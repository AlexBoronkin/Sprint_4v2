package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']" );

    //Поле Фамилия
    private final By familyField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле Адрес
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Станция метро
    private final By metroMain = By.xpath(".//input[@tabindex = '0']");

    //Телефон
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Станция Черкизовская
    private final By metroCherkizovskaya = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[2]/button/div[2]");

    //Станция Комсомольская
    private final By metroKomsomolskaya = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[6]/button/div[2]");

    //Кнопка Далее
    private final By dalee = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //Когда привезти самокат
    private final By whenToDeliverField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Выбор даты 27-е декабря
    private final By date27 = By.xpath(".//div[@aria-label = 'Choose среда, 27-е декабря 2023 г.']");

    // Выбор даты 28-е декабря
    private final By date28 = By.xpath(".//div[@aria-label = 'Choose четверг, 28-е декабря 2023 г.']");

    // Поле Срок аренды
    private final By daysOfRent = By.xpath(".//div[@class = 'Dropdown-placeholder']");

    // Выбираем двое суток
    private final By twoDays = By.xpath(".//div[text() = 'двое суток']");

    // Выбираем пять суток
    private final By fiveDays = By.xpath(".//div[text() = 'пятеро суток']");

    // Чекбокс черный жемчуг
    private final By blackColour = By.id("black");

    // Чекбокс серая безысходность
    private final By greyColour = By.id("grey");

    // Комментарий для курьера
    private final By comments = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");

    // Кнопка Заказать итоговая
    private final By finalOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка Да в попапе подтверждения
    private final By yesButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");

    //Попап Заказ оформлен
    private final By orderConfirmed = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");

    //Кнопка проверки статуса заказа
    private final By statusOrderCheck = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button");


    // Заполняем первую страницу Черкизовской
    public void firstPageOfOrder (String name, String sureName, String address, String number) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(familyField).sendKeys(sureName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroMain).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(metroCherkizovskaya));
        driver.findElement(metroCherkizovskaya).click();
        driver.findElement(phone).sendKeys(number);
        driver.findElement(dalee).click();
    }

    // Заполняем первую страницу Комсомольской
    public void firstPageOfOrderKomsomol (String name, String sureName, String address, String number) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(familyField).sendKeys(sureName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroMain).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(metroKomsomolskaya));
        driver.findElement(metroCherkizovskaya).click();
        driver.findElement(phone).sendKeys(number);
        driver.findElement(dalee).click();
    }

    //Заполняем вторую страничку черным цветом и двумя днями аренды + дата 27-е
    public void secondPageOfOrder (String comment) {
        driver.findElement(whenToDeliverField).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(date27));
        driver.findElement(date27).click();
        driver.findElement(daysOfRent).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(twoDays));
        driver.findElement(twoDays).click();
        driver.findElement(blackColour).click();
        driver.findElement(comments).sendKeys(comment);
        driver.findElement(finalOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']")));
        driver.findElement(yesButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")));
        //driver.findElement(orderConfirmed).getText();
    }

    //Заполняем вторую страничку серым цветом и пятью днями + другая дата
    public void secondPageOfOrderFiveDays (String comment) {
        driver.findElement(whenToDeliverField).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(date28));
        driver.findElement(date27).click();
        driver.findElement(daysOfRent).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(fiveDays));
        driver.findElement(twoDays).click();
        driver.findElement(greyColour).click();
        driver.findElement(comments).sendKeys(comment);
        driver.findElement(finalOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']")));
        driver.findElement(yesButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")));
        //driver.findElement(orderConfirmed).getText();
    }


}
