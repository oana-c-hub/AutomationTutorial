package tests;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.time.Duration;

public class FrameTest extends SharedData {
    @Test
    public void metodaTest(){

        ElementHelper elementHelper=new ElementHelper(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By frameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(frameWindowsMenu);

        By framesSubmenu = By.xpath("//span[text()='Frames']");
        elementHelper.clickLocator(framesSubmenu);

        driver.switchTo().frame("frame1");

        WebElement textElement= driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame2");

        WebElement textElement2= driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement2.getText());

    }
}
