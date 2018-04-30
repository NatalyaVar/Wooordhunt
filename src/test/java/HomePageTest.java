import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    String url = "http://wooordhunt.ru";


    String titleExersise = "Упражнения для запоминания/заучивания английский слов онлайн (online)";
    String titleEditor = "WooordHunt-редактор. Онлайн редактор для тех, кто пишет на английском";
    String titleExample = "Перевод примеров";
    String titleExtension = "Дополнения";

    public HomePageTest() throws IOException {
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Menu_box () throws IOException {
        driver.get(url);

        HomePage homePage = new HomePage();
        PageFactory.initElements(driver, homePage);

        WebElement exercises = homePage.exercises;
        homePage.pressBtns(driver, exercises, titleExersise);

        WebElement editor = homePage.editor;
        homePage.pressBtns(driver, editor, titleEditor);

        WebElement examples = homePage.examples;
        homePage.pressBtns(driver, examples, titleExample);

        WebElement extensions = homePage.extensions;
        homePage.pressBtns(driver, extensions, titleExtension);
    }
}

