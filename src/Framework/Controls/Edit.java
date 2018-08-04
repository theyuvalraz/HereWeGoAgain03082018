package Framework.Controls;

import Framework.ControlBase;
import Framework.PageBase;
import org.openqa.selenium.By;
public class Edit extends ControlBase {


    public Edit(PageBase page, By locator) {
        super(page, locator);
    }

    public void setText(String value ){
        this.exists();
        this.getElement().clear();
        this.getElement().sendKeys(value);
    }
}
