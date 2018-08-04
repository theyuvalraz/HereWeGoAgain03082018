package Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ControlBase {
    public PageBase Page;
    private By Locator;

    public ControlBase(PageBase page, By locator) {
        Page = page;
        Locator = locator;
    }

    public WebElement getElement(){
        return Page.getDriver().findElement(Locator);
    }

    public boolean exists(int timeout){
        WebDriverWait wait = new WebDriverWait(Page.getDriver(),timeout);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
        }
        catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean exists(){
        return exists(30);
    }

    public void Click(){
        exists();
        this.getElement().click();
    }
}
