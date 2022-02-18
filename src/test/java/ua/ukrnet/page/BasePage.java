package test.java.ua.ukrnet.page;

import org.openqa.selenium.WebElement;

public abstract class BasePage {

    public boolean isClear(WebElement element){
        return element.getText().equals("");
    }


}
