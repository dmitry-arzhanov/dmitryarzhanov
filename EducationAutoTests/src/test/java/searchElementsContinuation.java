import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchElementsContinuation {

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

    private By emailLocator = By.className("email");
    private By writeToMeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("result-email");

    @Test
    public void testKittens()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        Assert.assertTrue("Не отобразился текст про email", driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст про email", email, driver.findElement(resultEmailLocator).getText());
    }

    @Test
    public void testKittensEmptyEmail()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(writeToMeLocator).click();
        Assert.assertEquals("Неправильный текст про email", "", driver.findElement(resultEmailLocator).getText());
    }
    private By chooseNameLocator = By.id("sendMe");
    private By chooseEmailLocator = By.name("email");
    private By chooseResultEmailLocator = By.className("your-email");

    @Test
    public void testPuppies()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        var email = "test@test.ru";
        driver.findElement(chooseEmailLocator).sendKeys(email);
        driver.findElement(chooseNameLocator).click();
        Assert.assertTrue("Не отобразился текст про email", driver.findElement(chooseResultEmailLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст про email", email, driver.findElement(chooseResultEmailLocator).getText());
    }
    @Test
    public void testPuppiesEmptyEmail()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(chooseNameLocator).click();
        Assert.assertEquals("Неправильный текст про email", "", driver.findElement(chooseResultEmailLocator).getText());
    }

    @Test
    public void testFeedBack()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var nameLocator = By.cssSelector(".data.text");
        var buttonLocator = By.id("comment");
        var messageLocator = By.className("message-header");
        driver.findElement(nameLocator).sendKeys("Вася");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Не отобразился текст про спасибо", driver.findElement(messageLocator).isDisplayed());
    }

    @Test
    public void testCallExpert()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        var fioLocator = By.cssSelector("input.form-input.fio#fio");
        var streetLocator = By.cssSelector("input.data.form-input.street#street");
        var houseLocator = By.cssSelector("input.form-input.house#house");
        var flatLocator = By.cssSelector("input.form-input.flat#flat");
        var dateLocator = By.cssSelector("input.form-input.date#date");
        var buttonLocator = By.cssSelector("button.form-submit");
        driver.findElement(fioLocator).sendKeys("Иванов Иван Иванович");
        driver.findElement(streetLocator).sendKeys("Садовая");
        driver.findElement(houseLocator).sendKeys("25");
        driver.findElement(flatLocator).sendKeys("128");
        driver.findElement(dateLocator).sendKeys("завтра");
        driver.findElement(buttonLocator).click();
    }

    private By socksEmailLocator = By.name("email");
    private By socksPasswordLocator = By.className("form-input");

    @Test
    public void practiceTask1Socks()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        var email = "@";
        var password = "123";
        var buttonSocksLocator = By.className("form-submit");
        var messageSocksLocator = By.id("error");
        driver.findElement(buttonSocksLocator).click();
        var messageTextError = driver.findElement(By.className("form-error-password-email"));
        Assert.assertTrue("Не отобразился текст про некорректный email или пароль", driver.findElement(messageSocksLocator).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", messageTextError .getText());
    }

    @Test
    public void practiceTask2Socks()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var socksEmailNewLocator = By.cssSelector(".form-input.input-data");
        var socksPasswordLocator = By.cssSelector(".form-input.password");
        var buttonSocksLocator = By.cssSelector(".form-submit");
        var messageSocksLocator = By.cssSelector(".form-error-password-email");
        driver.findElement(buttonSocksLocator).click();
        var messageTextError = driver.findElement(By.cssSelector(".form-error-password-email"));
        Assert.assertTrue("Не отобразился текст про некорректный email или пароль", driver.findElement(messageSocksLocator).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", messageTextError .getText());
    }
    @Test
    public void practiceTask3Socks()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var socksEmailNewLocator = By.cssSelector("input.form-input.input-data");
        var socksPasswordLocator = By.cssSelector("input.form-input.password");
        var buttonSocksLocator = By.cssSelector("button.form-submit");
        var messageSocksLocator = By.cssSelector("pre.form-error-password-email");
        driver.findElement(buttonSocksLocator).click();
        var messageTextError = driver.findElement(By.cssSelector("pre.form-error-password-email"));
        Assert.assertTrue("Не отобразился текст про некорректный email или пароль", driver.findElement(messageSocksLocator).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", messageTextError .getText());
    }
    @Test
    public void practiceTask4Socks()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var socksEmailNewLocator = By.cssSelector("#email");
        var socksPasswordLocator = By.cssSelector("#password");
        var buttonSocksLocator = By.cssSelector("#submit");
        var messageSocksLocator = By.cssSelector("#error");
        driver.findElement(buttonSocksLocator).click();
        var messageTextError = driver.findElement(By.cssSelector("#error"));
        Assert.assertTrue("Не отобразился текст про некорректный email или пароль", driver.findElement(messageSocksLocator).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", messageTextError .getText());
    }
    @Test
    public void practiceTask5Socks()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var socksEmailNewLocator = By.cssSelector("input.form-input.input-data#email");
        var socksPasswordLocator = By.cssSelector("input.form-input.password#password");
        var buttonSocksLocator = By.cssSelector("button.form-submit#submit");
        var messageSocksLocator = By.cssSelector("pre.form-error-password-email#error");
        driver.findElement(buttonSocksLocator).click();
        var messageTextError = driver.findElement(By.cssSelector("pre.form-error-password-email#error"));
        Assert.assertTrue("Не отобразился текст про некорректный email или пароль", driver.findElement(messageSocksLocator).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", messageTextError .getText());
    }
}


