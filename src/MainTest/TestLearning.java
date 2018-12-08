package MainTest;

import Framework.Config;
import Framework.PageBase;
import Pages.IndexPage;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestLearning {
    private WebDriver newDriver;

    @Before
    public void setUp() throws Exception{
        Config.load();
        Config.print();
        newDriver = new ChromeDriver();
        newDriver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        newDriver.quit();
    }

    @Test
    public void testMe(){
        IndexPage indexPage = new IndexPage(newDriver);
        indexPage.navigate();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void usingBasePageShouldThrowAnException() throws Exception {
        PageBase Base = new PageBase(newDriver);
        thrown.expectMessage("specific Page");
        Base.navigate();
    }

    @Test
    public void SearchingDestination() throws Exception{
        IndexPage indexPage = new IndexPage(newDriver);
        indexPage.navigate();
        indexPage.destinationSearch("japan");
        Assert.assertTrue(indexPage.isTextPresent("Japan"));
    }
}
