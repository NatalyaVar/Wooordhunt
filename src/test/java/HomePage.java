import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {


    private static WebDriver driver;
    private WebDriverWait wait;

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

    public void pressBtns (WebDriver driver, WebElement element, String title) {

        element.click();
        Assert.assertEquals(title, driver.getTitle());
        System.out.println(driver.getTitle());
        //Возврат на домашнюю страницу
        driver.get(url);

    }

}
