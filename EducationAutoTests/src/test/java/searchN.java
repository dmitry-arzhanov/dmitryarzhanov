/*
Поиск N-го элемента
Для сайта книжного магазина составьте, используя CSS:
Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>.
Осуществите поиск только по атрибуту test-info, равному about-us.
Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
Локатор на странице поиска для всех элементов с тегом option и с атрибутом selected. Осуществите поиск только
по атрибуту selected.
Локатор на главной странице для элемента <div class="book-price">. Осуществите поиск одновременно по тегу
и классу, равному book-price.
Локатор на главной странице  для всех элементов с тегом button и с атрибутом class, начинающимся на book.
Локатор на главной странице для всех элементов, у которых атрибут class заканчивается на main.
Локатор на главной странице для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.
Для сайта книжного магазина составьте CSS-локаторы:
На главной странице найдите все теги div, которые являются дочерними элементами первого уровня
у элемента <footer id="footer">.
На главной странице найдите любой тег, который расположен сразу после <li id="genres">.
На странице поиска найдите любые теги, которые расположены после <div class="filter-container">
(необязательно ближайший сосед).
Для сайта клуба любителей весёлых носков составьте CSS-локаторы, в которых найдите:
Первый тег h1, находящийся сразу на первом уровне вложенности внутри <section class="important-section-block" for="main-header-page">.
Используйте поиск по первому child.
Последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">.
Используйте поиск по child.
Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.
Все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">.
Используйте поиск по type.
По желанию: найдите элемент с тегом <a>, который является первым дочерним элементом данного типа у
своего родителя <div class="footer__menuList">, при этом <div class="footer__menuList">
является первым дочерним элементом у своего родителя <div class="footer__menu">.
Составленный поиск должен вернуть ровно один найденный элемент.
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchN {

    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty ( "webdriver.chrome.driver", "drivers\\chromedriver.exe" );
        driver = new ChromeDriver ();
    }

    @After
    public void tearDown() {
        driver.quit ();
    }

    @Test
    public void task1() {
        driver.navigate ().to ( "http://qajava.skillbox.ru/index.html" );
        // 1.1 Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>.
        // Осуществите поиск только по атрибуту test-info, равному about-us.
        var aboutLocator = By.cssSelector ( "[test-info='about-us']" );
        // 1.2 Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
        var nullLocator = By.cssSelector ( "[href='']" );
        // 1.4 Локатор на главной странице для элемента <div class="book-price">. Осуществите поиск одновременно по тегу и классу, равному book-price.
        var bookPriceLocator = By.cssSelector ( "[class='book-price']" );
        // 1.5 Локатор на главной странице  для всех элементов с тегом button и с атрибутом class, начинающимся на book.
        var bookLocator = By.cssSelector ( "[class^=book]" );
        // 1.6 Локатор на главной странице для всех элементов, у которых атрибут class заканчивается на main.
        var mainLocator = By.cssSelector ( "[class$='main']" );
        // 1.7 Локатор на главной странице для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.
        var menuLocator = By.cssSelector ( "[class*='menu']" );
        // 2.1 На главной странице найдите все теги div, которые являются дочерними элементами первого уровня у элемента <footer id="footer">.
        var footerElement = By.cssSelector ( "footer>div" );
        // 2.2 На главной странице найдите любой тег, который расположен сразу после <li id="genres">.
        var genresElement = By.cssSelector ( "li#genres+*" );
    }

    @Test
    public void task1Search() {
        driver.navigate ().to ( "http://qajava.skillbox.ru/search.html" );
        // 1.3 Локатор на странице поиска для всех элементов с тегом option и с атрибутом selected. Осуществите поиск только по атрибуту selected.
        var selectedLocator = By.cssSelector ( "[selected='']" );
        // 2.3 На странице поиска найдите любые теги, которые расположены после <div class="filter-container"> (необязательно ближайший сосед).
        var filterLocator = By.cssSelector ( "div.filter-container~*" );
    }

    @Test
    public void task3() {
        driver.navigate ().to ( "http://qajava.skillbox.ru/module05/auth/index.html/" );
        // 3.1 Первый тег h1, находящийся сразу на первом уровне вложенности внутри <section class="important-section-block" for="main-header-page">.
        // Используйте поиск по первому child.
        var firstElement = By.cssSelector ( "section.important-section-block>h1:first-child" );
        // 3.2 Последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">. Используйте поиск по child.
        var lastElement = By.cssSelector ( "form.form#login-form>p:last-child" );
        // 3.3 Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.
        var bodyElement = By.cssSelector ( "body>*:nth-child(3)" );
        // 3.4 Все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">. Используйте поиск по type.
        var footerElement = By.cssSelector ( "div.footer__menuList>a:nth-of-type(1)" );
    }
}
