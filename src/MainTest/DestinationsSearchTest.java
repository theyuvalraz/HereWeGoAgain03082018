package MainTest;

import Framework.Config;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Framework.PageBase;
import Pages.IndexPage;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class DestinationsSearchTest {
    private WebDriver newDriver;
    private String destination;

    public DestinationsSearchTest(String destination) {
        this.destination = destination;
    }

    @Parameterized.Parameters
    public static Collection<Object> getParameters(){
        return Arrays.asList(new Object[][]{
                {"japan"},
                {"israel"},
                {"italy"},
                {"korea"}
        });
    }


    @Before
    public void setUp() throws Exception{
        Config.load();
        newDriver = new ChromeDriver();
        newDriver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        newDriver.quit();
    }

    @Test
    public void SearchingDestination(){
        IndexPage indexPage = new IndexPage(newDriver);
        indexPage.navigate();
        indexPage.destinationSearch(this.destination);
        String Capital = this.destination.substring(0, 1).toUpperCase() + this.destination.substring(1);

        Assert.assertTrue(indexPage.isTextPresent(Capital));
    }

}
