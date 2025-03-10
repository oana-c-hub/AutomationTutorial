package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.awt.*;
import java.util.List;

public class WebtableTest extends SharedData {
    @Test
    public void metodaTest(){

        ElementHelper elementHelper=new ElementHelper(driver);

        By elementsMenu=By.xpath("//h5[text()='Elements']");
        elementHelper.clickLocator(elementsMenu);

        By webTable=By.xpath("//span[text()='Web Tables']");
        elementHelper.clickLocator(webTable);

        List<WebElement> tableRowsList=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),3,"Valoare de dimensiune");

        //identificam un element
        By addElement=By.id("addNewRecordButton");
        elementHelper.clickJSLocator(addElement);

        By firstNameElement=By.id("firstName");
        String firstNameValue="Calitoiu";
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        By lastNameElement=By.id("lastName");
        String lastNameValue="Oana";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement=By.id("userEmail");
        String emailValue="oana.calitoiu@yahoo.com";
        elementHelper.fillLocator(emailElement,emailValue);

        By ageElement=By.id("age");
        String ageValue="39";
        elementHelper.fillLocator(ageElement,ageValue);

        By salaryElement=By.id("salary");
        String salaryValue="10";
        elementHelper.fillLocator(salaryElement,salaryValue);

        By departamentElement=By.id("department");
        String departamentValue="IT";
        elementHelper.fillLocator(departamentElement,departamentValue);

        By submitElement=By.id("submit");
        elementHelper.clickJSLocator(submitElement);

        tableRowsList=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),4,"Valoare de continut nr randuri");
        String expectedRow=tableRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(firstNameValue));
        Assert.assertTrue(expectedRow.contains(lastNameValue));
        Assert.assertTrue(expectedRow.contains(ageValue));
        Assert.assertTrue(expectedRow.contains(emailValue));
        Assert.assertTrue(expectedRow.contains(salaryValue));
        Assert.assertTrue(expectedRow.contains(departamentValue));


        //edit functionality
        By editElement=By.id("edit-record-4");
        elementHelper.clickLocator(editElement);

        WebElement editFirstNameElement=driver.findElement(By.id("firstName"));
        String editFirstNameValue="Petre";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement=driver.findElement(By.id("lastName"));
        String editLastNameValue="Dana";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editEmailElement=driver.findElement(By.id("userEmail"));
        String editEmailValue="dana.calitoiu@yahoo.com";
        editEmailElement.clear();
        editEmailElement.sendKeys(editEmailValue);

        WebElement editAgeElement=driver.findElement(By.id("age"));
        String editAgeValue="20";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement=driver.findElement(By.id("salary"));
        String editSalaryValue="1000";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement=driver.findElement(By.id("department"));
        String editDepartmentValue="IT School";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        By submitNewElement=By.id("submit");
        elementHelper.clickJSLocator(submitNewElement);

        tableRowsList=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),4,"Valoare de continut nr randuri");
        expectedRow=tableRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(editFirstNameValue));
        Assert.assertTrue(expectedRow.contains(editLastNameValue));
        Assert.assertTrue(expectedRow.contains(editAgeValue));
        Assert.assertTrue(expectedRow.contains(editEmailValue));
        Assert.assertTrue(expectedRow.contains(editSalaryValue));
        Assert.assertTrue(expectedRow.contains(editDepartmentValue));

        By deleteElement=By.id("delete-record-4");
        elementHelper.clickLocator(deleteElement);

        tableRowsList=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),3,"Valoare dimenisune");
    }
}
