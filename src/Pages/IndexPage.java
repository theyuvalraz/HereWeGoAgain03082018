package Pages;

import Framework.Config;
import Framework.ControlBase;
import Framework.Controls.Edit;
import Framework.PageBase;
import Framework.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends PageBase {
    private Edit destinationSearchField;
    private ControlBase submitButton;



    public IndexPage(WebDriver driver) {
        super(driver);
        destinationSearchField = new Edit(this, By.id("destination-fsc-search"));
        submitButton = new ControlBase(this, By.xpath("//*[@id=\"flights-search-controls-root\"]/div/div/form/div[3]/button"));
    }

    public void destinationSearch(String value) throws Exception{
        destinationSearchField.setText(value);
        Actions actions = new Actions(getDriver())
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.RETURN);
        actions.moveToElement(destinationSearchField.getElement()).perform();
        new Waiter(getDriver()).WaitForElement((t,y)-> submitButton.exists());
        submitButton.Click();
        Thread.sleep(5000);
    }

    @Override
    public PageBase navigate(){
        this.getDriver().get(Config.get("url"));
        return this;
    }
}
