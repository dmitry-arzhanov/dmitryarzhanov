/*
Неявные ожидания элементов.
2. Для сайта заказа такси составьте CSS-локаторы, в них:

Найдите тег input, у которого нет атрибута id.
Найдите все теги p, у которых одновременно выполняются два условия:
class начинается на слово form;
class НЕ заканчивается на слово error.
Найдите <div class="form-inner">, у него найдите первый по счёту элемент такого типа: <p class="form-row">.

3. Для сайта онлайн-ежедневника составьте один тест, в котором:

Перейдите на страницу.
Кликните на заметку из списка заметок по центру экрана.
Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.
Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
В разделе «Все записи» выберите самую верхнюю запись (первую).
Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
Дождитесь исчезновения записи в разделе «Все записи».
Проверьте, что справа в списке «Все записи» не видно записей.

 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class waitElement {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty ( "webdriver.chrome.driver", "drivers\\chromedriver.exe" );
        driver = new ChromeDriver ();
        wait = new WebDriverWait ( driver, Duration.ofSeconds ( 5 ) );
        driver.manage ().timeouts ().implicitlyWait ( 5, TimeUnit.SECONDS );
    }

    @After
    public void tearDown() {
        driver.quit ();
    }


    @Test
    public void task1() {
        // Составьте такой CSS-локатор, по которому бы находились все элементы,
        // отмеченные записью <!-- Нужен этот элемент -->.

        // поиск элементов для блока кода - "a":
        driver.navigate ().to ( "file: //file_html/a_html.html" );
        var aLocator = By.cssSelector ( "p" );

        // поиск элементов для блока кода - "b":
        driver.navigate ().to ( "file: //file_html/b_html.html" );
        var bLocator = By.cssSelector ( "div.text > a" );

        // поиск элементов для блока кода - "c":
        driver.navigate ().to ( "file: //file_html/c_html.html" );
        var cLocator = By.cssSelector ( "div:nth-of-type(2) > a" );
    }

    @Test
    public void task2() {

        // Для сайта заказа такси составьте CSS-локаторы, в них:

        driver.navigate ().to ( "https://lm.skillbox.cc/qa_tester/module04/practice1/" );

        // Найдите тег input, у которого нет атрибута id.
        var timeLocator = By.cssSelector ( "input:not(#date)" );

        // Найдите все теги p, у которых одновременно выполняются два условия:
        // class начинается на слово form;
        // class НЕ заканчивается на слово error.
        var dateLocator = By.cssSelector ( "p.form-row:not(error)" );

        // Найдите <div class="form-inner">,
        // у него найдите первый по счёту элемент такого типа: <p class="form-row">.
        var textLocator = By.cssSelector ( "div.form-inner p.form-row:nth-of-type(1)" );

    }

    @Test
    public void task3() {

        // Перейдите на страницу.
        driver.navigate ().to ( "http://qa.skillbox.ru/module15/bignotes/#/statistic" );

        // Кликните на заметку из списка заметок по центру экрана.
        var noteButtonLocator = By.cssSelector ( "button.articlePreview__link" );
        driver.findElement ( noteButtonLocator ).click ();

        // Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
        var sectionLocator = By.cssSelector ( "div.articlePreview.pageArticle__articlePreview:nth-of-type(1)" );

        // Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.

        var headNoteLocator = By.cssSelector ( "div.articlePreview:nth-of-type(1)>div.articlePreview__content>p.articlePreview__title" );
        var textNoteLocator = By.cssSelector ( "div:nth-of-type(1) > div.articlePreview__content > p.articlePreview__text" );

        var actualHeadNote = driver.findElement ( headNoteLocator ).getText ();
        var actualTextNote = driver.findElement ( textNoteLocator ).getText ();

        var expectedHeadNote = "План на следующий месяц";
        var expectedTextNote = "Прочитать книгу «Искусство цвета».";

        Assert.assertTrue ( "Не отобразился заголовок для записи", driver.findElement ( headNoteLocator ).isDisplayed () );
        Assert.assertEquals ( "Неправильный заголовок для записи", expectedHeadNote, actualHeadNote );
        Assert.assertTrue ( "Не отобразился текст в записи", driver.findElement ( textNoteLocator ).isDisplayed () );
        Assert.assertEquals ( "Неправильный текст в записи", expectedTextNote, actualTextNote );

        // Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        var buttonTrashLocator = By.cssSelector ( "div.pageArticle__contentHeader > div.pageArticle__buttons > button:nth-of-type(2)" );
        driver.findElement ( buttonTrashLocator ).click ();

        // В разделе «Все записи» выберите самую верхнюю запись (первую).
        var firstNoteLocator = By.cssSelector ( "div.pageArticle__sidebarList.vb.vb-invisible > div.vb-content > div > button" );
        driver.findElement ( firstNoteLocator ).click ();

        // Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        var buttonTrash2Locator = By.cssSelector ( "div.pageArticle__contentHeader > div.pageArticle__buttons > button:nth-of-type(2)" );
        driver.findElement ( buttonTrash2Locator ).click ();

        // Дождитесь исчезновения записи в разделе «Все записи».
        // Проверьте, что справа в списке «Все записи» не видно записей.
        var nullNoteLocator = By.cssSelector ( "div.vb-content" );
        wait.until ( ExpectedConditions.invisibilityOfElementLocated ( nullNoteLocator ) );
    }
}