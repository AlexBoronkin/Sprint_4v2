package Page_Object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Кнопка Заказать в шапке
    public static By orderButtonPageTop = By.xpath(".//button[@class = 'Button_Button__ra12g']");


    // Кнопка Заказать в центре страницы
    public static By orderButtonPageMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");


    // Сколько это стоит? И как оплатить?
    public static By howMuch = By.xpath(".//div[@id = 'accordion__heading-0']");


    //Хочу сразу несколько самокатов! Так можно?
    public static By fewScooters = By.xpath(".//div[@id ='accordion__heading-1']");


    //Как рассчитывается время аренды?
    public static By rentingTime = By.xpath(".//div[@id ='accordion__heading-2']");


    //Можно ли заказать самокат прямо на сегодня?
    public static By todayOrder = By.xpath(".//div[@id ='accordion__heading-3']");


    //Можно ли продлить заказ или вернуть самокат раньше?
    public static By changeOrderTime = By.xpath(".//div[@id ='accordion__heading-4']");


    //Вы привозите зарядку вместе с самокатом?
    public static By charger = By.xpath(".//div[@id ='accordion__heading-5']");


    //Можно ли отменить заказ?
    public static By cancelOrder = By.xpath(".//div[@id ='accordion__heading-6']");


    //Я жизу за МКАДом, привезёте?
    public static By liveFar = By.xpath(".//div[@id ='accordion__heading-7']");



}
