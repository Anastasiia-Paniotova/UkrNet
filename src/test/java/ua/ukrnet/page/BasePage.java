package ua.ukrnet.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    public boolean isClear(WebElement element){
        return element.getText().equals("");
    }

    //    @FindBy(name = "header")
//    private WebElement header;
//

}
