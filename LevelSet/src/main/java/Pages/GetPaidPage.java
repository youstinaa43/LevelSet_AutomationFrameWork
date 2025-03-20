package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetPaidPage extends BasePage {

    //Locators
    public By freeDocuments = By.xpath("//span[@class='price-amount' and text() = 'Free']");
    public By freeDocumentsNames = By.xpath("//span[@class='price-amount' and text() = 'Free']/../../div[1]");
    public By paidDocuments = By.xpath("//span[@class='price-amount' and number( substring (text(),2) )> 30 and number (substring(text(),2))<60 ]");
    public By paidDocumentsNames = By.xpath("//span[@class='price-amount' and number( substring (text(),2) )> 30 and number (substring(text(),2))<60 ]/../../div[@class='left']");

    //Create Constructor
    public GetPaidPage (WebDriver driver)
    {
        super(driver,"https://app.levelset.com/wizard/SelectDocument/");
    }

    //Create method 1
    public int getFreeDocuments()
    {
        return driver.findElements(freeDocuments).size();
    }

    //Create method 2
    public List<String> getFreeDocumentsNames()
    {
        List<String> freeDocumentsText = new java.util.ArrayList<String>();
        List<WebElement> freeDocumentsList = driver.findElements(freeDocumentsNames);

        freeDocumentsText.add(0,freeDocumentsList.get(0).getText() );
        freeDocumentsText.add(1,freeDocumentsList.get(1).getText() );


        return freeDocumentsText;
    }

    //Create method 3
    public int getPaidDocuments()
    {
        return driver.findElements(paidDocuments).size();
    }

    //Create method 4
    public String getPaidDocumentsNames()
    {
        return driver.findElement(paidDocumentsNames).getText();
    }

}
