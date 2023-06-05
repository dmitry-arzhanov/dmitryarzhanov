/*
Приветствие Васи на простом сайте-приветствии
Создайте тест, который вводит имя «Вася» и получает текст «Привет, Вася!».
 */

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class helloVasya {
    @Test
    public void TestHelloVasya() {
        System.setProperty ( "webdriver.chrome.driver", "drivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ();
        driver.navigate ().to ( "https://lm.skillbox.ru/qa_tester/module01/" );
        driver.findElement ( By.name ( "name" ) ).sendKeys ( "Вася" );
        driver.findElement ( By.className ( "button" ) ).click ();
        var actualResult = driver.findElement ( By.className ( "start-screen__res" ) ).getText ();
        var expectedResult = "Привет, Вася!";
        Assert.assertEquals ( expectedResult, actualResult );
        driver.quit ();
    }

}
