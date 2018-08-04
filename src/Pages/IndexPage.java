package Pages;

import Framework.Config;
import Framework.ControlBase;
import Framework.Controls.Edit;
import Framework.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends PageBase {
    private Edit destinationSearchField;
    private ControlBase submitSearchButton;


    public IndexPage(WebDriver driver) {
        super(driver);
        destinationSearchField = new Edit(this, By.xpath("//*[@id=\"taplc_trip_search_home_default_0\"]//input"));
        submitSearchButton = new ControlBase(this, By.id("SUBMIT_HOTELS"));
    }

    public void destinationSearch(String value){
        destinationSearchField.setText(value);
        submitSearchButton.Click();
    }

    @Override
    public PageBase navigate(){
        this.getDriver().get(Config.get("url"));
        return this;
    }
}
