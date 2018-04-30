import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class HomePage  {

    public HomePage() throws IOException {
    }

    private static WebDriver driver;
    private WebDriverWait wait;

    private static Logger log = (Logger) LoggerFactory.getLogger(HomePage.class);

    String url = "http://wooordhunt.ru";


    //Кнопки в верхнем поле
    @FindBy(how = How.CSS, css = "#menu > ul > li:nth-child(2)")
    public WebElement exercises;

    @FindBy(how = How.CSS, css = "#menu > ul > li:nth-child(3)")
    public WebElement editor;

    @FindBy(how = How.CSS, css = "#menu > ul > li:nth-child(4)")
    public WebElement examples;

    @FindBy(how = How.CSS, css = "#menu > ul > li:nth-child(5)")
    public WebElement extensions;

    public void pressBtn (WebDriver driver) {
        editor.click();
//        Assert.assertEquals("Упражнения для запоминания/заучивания английский слов онлайн (online)", driver.getTitle());
        System.out.println(driver.getTitle());
        //Возврат на домашнюю страницу
        driver.get(url);
    }

    public void pressBtns (WebDriver driver, WebElement element, String title) throws IOException {

        element.click();
        Assert.assertEquals(title, driver.getTitle());

        //Запись названия страницы в файл
        FileWriter writer = new FileWriter("output.txt", true);
        writer.write(driver.getTitle() + "\n");
        writer.close();
        log.info("Title___" + driver.getTitle());

       //Возврат на домашнюю страницу
        driver.get(url);

}

}
