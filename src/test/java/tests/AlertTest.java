package tests;
import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.time.Duration;

public class AlertTest extends SharedData {
    @Test
    public void metodaTest() {

        ElementHelper elementHelper=new ElementHelper(driver);
        AlertHelper alertHelper=new AlertHelper(driver);

        By alertFrameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertFrameWindowsMenu);

        By alertsSubmenu = By.xpath("//span[text()='Alerts']");
        elementHelper.clickLocator(alertsSubmenu);

        By alertOkElement=By.id("alertButton");
        elementHelper.clickLocator(alertOkElement);

//        Alert alertOk=driver.switchTo().alert();
//        System.out.println(alertOk.getText());
//        alertOk.accept();

        alertHelper.acceptAlert();

        By timerAlertElement=By.id("timerAlertButton");
        elementHelper.clickLocator(timerAlertElement);

//        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alertTimer=driver.switchTo().alert();
//        System.out.println(alertTimer.getText());
//        alertTimer.accept();
        alertHelper.acceptAlert();

        By confirmElement=By.id("confirmButton");
        elementHelper.clickLocator(confirmElement);

//        Alert alertOkCancel=driver.switchTo().alert();
//        System.out.println(alertOkCancel.getText());
//        alertOkCancel.dismiss();
        alertHelper.cancelAlert();

        By promptElement=By.id("promtButton");
        elementHelper.clickLocator(promptElement);

//        Alert alertPrompt=driver.switchTo().alert();
//        System.out.println(alertPrompt.getText());
//        String alertValue="Ceva";
//        alertPrompt.sendKeys(alertValue);
//        alertPrompt.accept();
        alertHelper.fillAlert("Ceva");

    }
}
