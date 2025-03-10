package helpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabWindowHelper {
    public WebDriver driver;

    public TabWindowHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificTabWindow(int index){
        List<String> tab= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(index));
    }
    public void closeCurrentTabWindow(){
        driver.close();
    }
}
