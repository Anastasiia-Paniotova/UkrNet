package test.java.ua.ukrnet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MsgListPage extends BasePage{
    public WebDriver driver;
    private WebDriverWait wait;

    public MsgListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    /**
     * search 'Вхід' link
     */
    @FindBy(xpath = "//*[text()='Вхідні']")
    private WebElement messageListLink;

    public void clickMessageListLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Вхідні']"))).click();
    }
    /**
     * method to switch tabs
     */
    public void switchTab(){
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
    }
    /**
     * method switch window
     */
    public void switchWindow(){
        String window = driver.getWindowHandle();
        driver.switchTo().window(window);
    }

    /**
     * method to find all components on left panel
     */
    @FindBy(xpath = "//*[@class='sidebar__list-link-name']")
    private List<WebElement> allElements;

    public int getSizeOfComponentsList(){
        return allElements.size();
    }

    public ArrayList listComponents(){
        ArrayList<String> allElementsText= new ArrayList<String>();
        for(WebElement element : allElements) {
            allElementsText.add(element.getText());
        }
        return allElementsText;
    }

    /**
     * search components on left panel
     */
    @FindBy(xpath = "//*[text()='Вхідні']")
    private WebElement inputEmail;

    public String getTextInputEmail(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Вхідні']"))).getText();
    }

    /**
     * search 'Надіслати листа' button
     */
    @FindBy(xpath = "//*[@class='button primary compose']")
    private WebElement sendLetter;

    public void clickSendLetter(){
        sendLetter.click();
    }

    /**
     * search send email screen panel
     */
    @FindBy(xpath = "//*[@class='sendmsg screen']")
    private WebElement screenContent;

    public Boolean isDisplayedScreenContent(){
        return screenContent.isDisplayed();
    }

    public Boolean isNotDisplayedScreenContent() {
        try {
            return (!screenContent.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * search Cancel button
     */
    @FindBy(xpath = "//*[@class='text-button action']")
    private WebElement cancel;

    public void clickCancel(){
        cancel.click();
    }

    /**
     * search Recipient field
     */
    @FindBy(xpath = "//*[@name='toFieldInput']")
    private WebElement recipient;

    public void inputRecipient(String toRecipient){
        recipient.sendKeys(toRecipient);
    }

    /**
     * search Subject input
     */
    @FindBy(xpath = "//*[@name='subject']")
    private WebElement subject;

    public void inputSubject(String topic){
        subject.sendKeys(topic);
    }

    /**
     * search 'Надіслати' button
     */
    @FindBy(xpath = "//div[@class='controls']/button[@class='button primary send']")
    private WebElement sendButton;

    public void clickSendButton(){
        sendButton.click();
    }

    /**
     * search Confirmation message upon sending email
     */
    @FindBy(xpath = "//*[@class='sendmsg__ads-ready']")
    private WebElement confirmMessage;

    public Boolean isDisplayedConfirmMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sendmsg__ads-ready']")));
        return confirmMessage.isDisplayed();
    }

    /**
     * search 'Надіслані' submenu
     */
    @FindBy(xpath = "//*[text()='Надіслані']")
    private WebElement sentLetters;

    public void clickSentLettersSubMenu(){
        sentLetters.click();
    }

    /**
     * search the email of sent letter
     */
    @FindBy(xpath = "//*[@class='msglist__row-address-wrap msglist__row-address-wrap_grow']")
    private WebElement emailData;

    public String getDataName(){
        return emailData.getText();
    }

    /**
     * search the subject of sent letter
     */
    @FindBy(xpath = "//*[@class='msglist__row_href']")
    private WebElement subjectData;

    public String getDataSubject(){
        return subjectData.getText();
    }

    /**
     * search the alert 'Потрібно вказати хоча б одного отримувача в полі 'Кому' '
     */
    @FindBy(xpath = "//div[@class='modal show']/div[@class='modal__wrap']/div[@class='alert']/div[@class='alert__content']")
    private WebElement alertWithoutRecipient;

    public String getAlertWithoutRecipientText(){
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='modal show']/div[@class='modal__wrap']/div[@class='alert']/div[@class='alert__content']")))
                .getText();
    }

    /**
     * search Cancel button on the alert
     */
    @FindBy(xpath = "//div[@class='modal show']/div[@class='modal__wrap']/div[@class='alert']/div[@class='alert__buttons']/button[@class='button secondary cancel']")
    private WebElement cancelAlert;

    public void clickCancelAlert(){cancelAlert.click();}

    /**
     * search 'Чернетки' submenu
     */
    @FindBy(xpath = "//*[text()='Чернетки']")
    private WebElement drafts;

    public void clickDrafts(){drafts.click();}

    /**
     * search alert content
     */
    @FindBy(xpath = "//div[@class='modal show']/div[@class='modal__wrap']/div[@class='alert']/div[@class='alert__content']")
    private WebElement alertWithoutSubject;

    public String getTextAlertWithoutSubject(){
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='modal show']/div[@class='modal__wrap']/div[@class='alert']/div[@class='alert__content']"))).getText();
    }

    /**
     * search collapse/expand button
     */
    @FindBy(xpath = "//*[@class='_2emrRO46']")
    private WebElement collapseAndExpand;

    public Boolean collapseAndExpandedIsDisplayed(){
        return collapseAndExpand.isDisplayed();
    }

    /**
     * search 'Контакти'
     */
    @FindBy(xpath = "//*[@class='_3_hVXsfO _1ArcnVT-']")
    private WebElement contacts;

    public String getTextContactsTitle(){
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@class='_3_hVXsfO _1ArcnVT-']"))).getText();
    }

    public String getTypeContactToggle(){
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@class='_3_hVXsfO _1ArcnVT-']"))).getAttribute("type");
    }

    /**
     * search 'Групи'
     */
    @FindBy(xpath = "//*[@class='_3_hVXsfO']")
    private WebElement groups;

    public String getTextGroupsTitle(){
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@class='_3_hVXsfO']"))).getText();
    }

    public String getTypeGroupsToggle(){
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@class='_3_hVXsfO']"))).getAttribute("type");
    }

    /**
     * search disabled header options for 'Вхідні'
     */
    @FindBy(xpath = "//*[@class='controls-link mforward disabled']")
    private WebElement disabledForward;

    public Boolean isDisplayedForward(){ return disabledForward.isDisplayed();}

    @FindBy(xpath = "//*[@class='controls-link remove disabled']")
    private WebElement disabledRemove;

    public Boolean isDisplayedRemove() { return disabledRemove.isDisplayed();}

    @FindBy(xpath = "//*[@class='controls-link spam disabled']")
    private WebElement disabledSpam;

    public Boolean isDisplayedSpam(){ return disabledSpam.isDisplayed();}

    @FindBy(xpath = "//*[@class='controls-link move disabled']")
    private WebElement disabledMove;

    public Boolean isDisplayedMove() { return disabledMove.isDisplayed();}

    @FindBy(xpath = "//*[@class='controls-link more disabled']")
    private WebElement disabledMore;

    public Boolean isDisplayedMore() { return disabledMore.isDisplayed();}

    /**
     * search enabled header options for 'Вхідні'
     */

    @FindBy(xpath = "//*[@class='controls-link mforward']")
    private WebElement enabledForward;

    public Boolean isEnabledForward(){ return enabledForward.isEnabled();}

    @FindBy(xpath = "//*[@class='controls-link remove']")
    private WebElement enabledRemove;

    public Boolean isEnabledRemove() { return enabledRemove.isEnabled();}

    @FindBy(xpath = "//*[@class='controls-link spam']")
    private WebElement enabledSpam;

    public Boolean isEnabledSpam(){ return enabledSpam.isEnabled();}

    @FindBy(xpath = "//*[@class='controls-link move']")
    private WebElement enabledMove;

    public Boolean isEnabledMove() { return enabledMove.isEnabled();}

    @FindBy(xpath = "//*[@class='controls-link more']")
    private WebElement enabledMore;

    public Boolean isEnabledMore() { return enabledMore.isEnabled();}

    /**
     * search checkbox
     */
    @FindBy(xpath = "//*[@class='checkbox noselect']")
    private WebElement checkbox;

    public void selectCheckbox(){ checkbox.click();}















}
