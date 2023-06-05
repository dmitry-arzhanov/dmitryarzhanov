/*
Selenium WebDriver: избавляемся от дублирования кода
использовать аннотации JUnit  — @Before и @After, которые позволяют вызывать методы до и после выполнения теста
вне зависимости от результата его прохождения. А также передавать сообщение об ошибке в функции.
В первом уроке мы разбирали пять браузерных тестов на сайте-приветствии с тремя полями ввода и кнопкой.
Вынесите в этих тестах в setUp- и tearDown-методы подготовительную работу по настройке драйвера, открытию и закрытию браузера.
Добавьте два новых браузерных теста для сайта-регистрации в онлайн-кинотеатре,
осуществляя поиск элементов по их атрибуту name, а в случае его отсутствия — по классу:
В первом тесте:
Перейдите на сайт, введите любое имя, email skillbox@test.ru и пароль «qwerty!123».
Кликните по кнопке «Зарегистрироваться».
Убедитесь, что текст у элемента с результатом регистрации равен «Вам на почту skillbox@test.ru отправлено письмо».
Во втором тесте:
Перейдите на сайт.
Сразу же кликните по кнопке «Зарегистрироваться».
Убедитесь, что текст у элемента с ошибкой регистрации равен «Введите имя».
Вынесите отдельно в setUp- и tearDown-методы всю подготовительную работу с драйвером.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchElements {
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testAllFieldsHello()
    {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("+7900-000-00-00");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, Иванов Иван Иванович.\n"+
            "На вашу почту (test@test.ru) отправлено письмо.\n"+
            "Наш сотрудник свяжется с вами по телефону: +7900-000-00-00.";
        Assert.assertEquals("Неправильный текст приветствия", expectedText, actualText);
    }

    @Test
    public void testEmptyFieldsHello()
    {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n"+
        "На вашу почту () отправлено письмо.\n"+
        "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testAllCinemaFieldsHello()
    {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys ("Дмитрий");
        driver.findElement(By.name("email")).sendKeys ("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys ("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualText = driver.findElement(By.className("form-result")).getText();
        var expectedText = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void testEmptyCinemaHello()
{
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualText = driver.findElement(By.className("form-error")).getText();
        var expectedText = "Введите имя";
        Assert.assertEquals(expectedText, actualText);
}

    @Test
    public void testLocators()
    {
        driver.navigate().to ("https://lm.skillbox.ru/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var passwordConfirmElement = driver.findElement(By.name("confirm_password"));
        var buttonElement = driver.findElement(By.tagName("button"));
        var headerResultElement = driver.findElement(By.tagName("h3"));
        var password = "123";
        var email = "test@test.ru";
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        passwordConfirmElement.sendKeys(password);
        buttonElement.click();
        var emailResultElement = driver.findElement(By.linkText(email));
        var emailResultElement2 = driver.findElement(By.partialLinkText(email));
        Assert.assertEquals("Неверный текст при успешной регистрации", "Спасибо за регистрацию!", headerResultElement.getText());
        Assert.assertEquals("Неверный email при успешной регистрации", email, emailResultElement.getText());
    }

    @Test
    public void testLocatorsMany()
    {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        var noteElements = driver.findElements(By.className("articlePreview"));
        Assert.assertEquals("Неверное количество записей на странице", 2, noteElements.size());
    }

    @Test
    public void testLocatorsShoes()
    {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var sizeElement = driver.findElement(By.name("check"));
        var validateElement = driver.findElement(By.id("check-size-button"));
    }

    @Test
    public void practiceTask1LocatorsShoes1()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "33";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var sizeResultElement = driver.findElement(By.id("size-error"));
        Assert.assertEquals("В нашем магазине нет обуви вашего размера", sizeResultElement.getText());
    }
    @Test
    public void practiceTask1LocatorsShoes2()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "34";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var sizeResultElement = driver.findElement(By.id("size-success"));
        Assert.assertEquals("В нашем магазине есть обувь вашего размера", sizeResultElement.getText());
    }
    @Test
    public void practiceTask1LocatorsShoes3()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "44";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var sizeResultElement = driver.findElement(By.id("size-success"));
        Assert.assertEquals("В нашем магазине есть обувь вашего размера", sizeResultElement.getText());
    }
    @Test
    public void practiceTask1LocatorsShoes4()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "45";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var sizeResultElement = driver.findElement(By.id("size-error"));
        Assert.assertEquals("В нашем магазине нет обуви вашего размера", sizeResultElement.getText());
    }
    @Test
    public void practiceTask1LocatorsShoes5()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "45";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var sizeResultElement = driver.findElement(By.id("size-error"));
        Assert.assertEquals("В нашем магазине есть обувь вашего размера", sizeResultElement.getText());
        Assert.assertEquals("Неверный текст если указан размер обуви не из диапазона", "В нашем магазине нет обуви вашего размера", sizeResultElement.getText());
    }

    @Test
    public void practiceTask2LocatorsBooks()
    {
        driver.navigate().to("http://qajava.skillbox.ru/");
        var feedbackElement = driver.findElement(By.linkText("Обратная связь"));
        var preorderElement = driver.findElement(By.linkText("Предзаказы"));
        var buttonElement = driver.findElement(By.className("book-add"));
        var cartElement = driver.findElement(By.id("cart_count"));
        var booksElement = driver.findElement(By.id("genres"));
        var searchElement = driver.findElement(By.name("search-input-form"));
    }
    @Test
    public void practiceTask3LocatorsBooks()
    {
        driver.navigate().to("http://qajava.skillbox.ru/");
        var booksElement = driver.findElements(By.className("book-info"));
        Assert.assertEquals("Неверное количество записей на странице", 15, booksElement.size());
    }

    @Test
    public void practiceTask4LocatorsCinema()
    {
    driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
    driver.findElement(By.id("films")).sendKeys("Чебурашка");
    driver.findElement(By.id("serials")).sendKeys("Друзья");
    driver.findElement(By.className("section__button")).click();
    driver.findElement(By.id("two")).click();
    driver.findElement(By.id("save")).click();
    driver.findElement(By.id("ok")).click();
    var actualTextFilm = driver.findElement(By.id("best_films")).getText();
    var expectedTextFilm = "Чебурашка";
    Assert.assertEquals(expectedTextFilm, actualTextFilm);
    var actualTextSerial = driver.findElement(By.id("best_serials")).getText();
    var expectedTextSerial = "Друзья";
    Assert.assertEquals(expectedTextSerial, actualTextSerial);
    }

}
