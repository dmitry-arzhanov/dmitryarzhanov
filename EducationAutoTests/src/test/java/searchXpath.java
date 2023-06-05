/*
XPath-локаторы
Для сайта домашнего кинотеатра составьте XPath-локаторы следующих элементов:

Кнопка перехода к предыдущему объявлению в слайдере «<». <span class="da-arrows-prev"></span>
Кнопка «Узнать больше» в слайдере. Используйте поиск сразу по двум классам. <a href="#" class="da-link button">Узнать больше</a>
Все неактивные фильтры из раздела фильмов, которые есть в онлайн-кинотеатре.
Все элементы, у которых класс начинается на слова button.
Кнопка «Подписаться сейчас».
Все картинки клиентов из раздела «Наши клиенты». Для уточнения локатора используйте указание ближайшего родительского элемента с ID.
Необязательное задание. Все элементы с ценами тарифов, следующих после тарифа «Любительский».
Необязательное задание. Все поля для ввода в форме «Скажите “Привет”», которые предшествуют полю «* Текст сообщения».

 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchXpath {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty ( "webdriver.chrome.driver", "drivers\\chromedriver.exe" );
        driver = new ChromeDriver ();
    }

    @After
    public void tearDown() {
        driver.quit ();
    }

    @Test
    public void task1() {

        // Задание 1. XPath-локаторы для сайта домашнего кинотеатра

        // Для сайта домашнего кинотеатра составьте XPath-локаторы следующих элементов:
        driver.navigate ().to ( "http://qa.skillbox.ru/module19/" );

        // 1. Кнопка перехода к предыдущему объявлению в слайдере «<». <span class="da-arrows-prev"></span>
        var buttonSlider = By.xpath ( "//span[@class='da-arrows-prev']" );

        // 2. Кнопка «Узнать больше» в слайдере. Используйте поиск сразу по двум классам.
        // <a href="#" class="da-link button">Узнать больше</a>
        var buttonMore = By.xpath ( "//a[@class='da-link button']" );

        // 3. Все неактивные фильтры из раздела фильмов, которые есть в онлайн-кинотеатре.
        var filterSection = By.xpath ( "//li[@class='filter']" );

        // 4. Все элементы, у которых класс начинается на слова button.
        var allElements = By.xpath ( "//*[starts-with(@class,'button')]" );

        // 5. Кнопка «Подписаться сейчас».
        var buttonSubscribe = By.xpath ( "//div[contains(@class,'container centered')]/a" );

        // 6. Все картинки клиентов из раздела «Наши клиенты».
        // Для уточнения локатора используйте указание ближайшего родительского элемента с ID.
        var allImg = By.xpath ( "//ul[contains(@id,'clint-slider')]//li//img" );

    }

    @Test
    public void task2() {

        // Задание 2. XPath-локаторы для сайта онлайн-института

        // Для сайта онлайн-института составьте XPath-локаторы следующих элементов:
        driver.navigate ().to ( "http://qa.skillbox.ru/module16/maincatalog/" );

        // 1. Заголовок пятого курса.
        var fiveCourse = By.xpath ( "(//span)[5]" );

        // 2. Элемент с учебным периодом последнего курса.
        var periodLastCourse = By.xpath ( "(//div[@class='baseCondition'])[last()]//p" );

    }

    @Test
    public void task3() {

        // Задание 3. XPath-локаторы для сайта книжного магазина

        // Применяя правила построения хороших локаторов,
        // составьте XPath-локаторы для следующих элементов на сайте книжного магазина:
        driver.navigate ().to ( "http://qajava.skillbox.ru/index.html" );

        // 1. Ссылка «О магазине» в футере.
        var aboutFooter = By.xpath ( "//*[@test-info='about-us']" );

        // 2. Заголовок «Бестселлеры».
        var headerBestsellers = By.xpath ( "(//li[.='Бестселлеры'])" );

        // 3. Строка поиска.
        var stringSearch = By.xpath ( "//input" );

        // 4. Итоговая сумма заказа в корзине.
        driver.navigate ().to ( "http://qajava.skillbox.ru/checkout.html" );
        var totalCart = By.xpath ( "//div[@id='total']" );

        // 5. Заголовок «Ваш заказ: в корзине.
        var headerOrder = By.xpath ( "//div[@class='order-info']//div[1]" );

        // 6. Кнопка «Отменить» на странице поиска.
        var buttonCancel = By.xpath ( "//button[@class='filter-button']" );

    }

}
