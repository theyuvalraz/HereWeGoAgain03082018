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
    private Edit originSearchField;
    private ControlBase submitButton;

    public IndexPage(WebDriver driver) {
        super(driver);
        destinationSearchField = new Edit(this, By.id("destination-fsc-search"));
        originSearchField = new Edit(this, By.id("origin-fsc-search"));
        submitButton = new ControlBase(this, By.xpath("//form/div[3]/button"));
    }

    public void destinationSearch(String value){
        originSearchField.setText("Israel");
        destinationSearchField.setText(value);
        Actions actions = new Actions(getDriver())
                .sendKeys(Keys.RETURN);
        actions.moveToElement(destinationSearchField.getElement()).perform();
        Waiter waiter = new Waiter(getDriver());
        waiter.waitForElement(submitButton, (x)-> x.exists() ? x : null);
        waiter.waitForElement(submitButton.getElement(), (x) -> x.getText().equals("Search flights") ? x:null);
        submitButton.Click();
    }

    @Override
    public PageBase navigate(){
        this.getDriver().get(Config.get("url"));
        return this;
    }
}
