package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;
    public String url;

    //Create constructor

    public BasePage (WebDriver driver, String url)
    {
        this.driver = driver;
        this.url = url;
    }

    public void openPage()
    {
        driver.get(url);
    }
}
