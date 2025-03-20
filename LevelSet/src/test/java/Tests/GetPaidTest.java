package Tests;

import Pages.GetPaidPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetPaidTest {
    private WebDriver driver;
    private GetPaidPage getPaidPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        getPaidPage = new GetPaidPage(driver);
        getPaidPage.openPage();
    }

    @Test(priority = 1)
    public void testFreeDocumentsCount() {
        int freeDocsCount = getPaidPage.getFreeDocuments();
        Assert.assertEquals(freeDocsCount, 2);
    }

    @Test(priority = 2)
    public void testFreeDocumentsNames() {
        List<String> expectedFreeDocsNames = List.of("Exchange a Waiver", "Send a Payment Document");
        List<String> actualFreeDocsNames = getPaidPage.getFreeDocumentsNames();
        Assert.assertEquals(actualFreeDocsNames, expectedFreeDocsNames);
    }


    @Test(priority = 3)
    public void testPaidDocumentsCount() {
        int paidDocsCount = getPaidPage.getPaidDocuments();
        Assert.assertEquals(paidDocsCount,1);
    }

    @Test(priority = 4)
    public void testPaidDocumentsNames() {
        String paidDocName = getPaidPage.getPaidDocumentsNames();
        Assert.assertEquals(paidDocName, "Send a Warning");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
