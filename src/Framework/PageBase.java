package Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {
    private WebDriver driver;


    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageBase navigate() throws Exception {
        throw new Exception("You should use a specific Page");
    }

    public boolean isTextPresent(String text){
        String locator = String.format("//*[text()='%s' or contains(text(), %s)]", text,text);
        ControlBase element = new ControlBase(this, By.xpath(locator));
        return element.exists();
    }
}
