package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.time.Duration.ofSeconds;

public class Waiter {

    private WebDriver driver;

    public Waiter(WebDriver driver){
        this.driver = driver;
    }

    public  <T> T waitForElement(T thing, Function<T, T> function){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50).getSeconds());
        ExpectedCondition<T>  condition =(driver) -> function.apply(thing);
        return webDriverWait.withMessage("Timed out waiting for element").until(condition);
    }

    public boolean elementContainsString(WebElement element, String str){
        return element.getText().equals(str);
    }

}
