package Framework.Controls;

import Framework.ControlBase;
import Framework.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SelectList extends ControlBase {
    public SelectList(PageBase page, By locator) {
        super(page, locator);
    }

    public Select getSelect(){
        return new Select(this.getElement());
    }

    public void selectByText(String value){
        this.exists();
        this.getSelect().selectByVisibleText(value);
    }
}
