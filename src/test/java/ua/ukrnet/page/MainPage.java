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


public class MainPage extends BasePage {
    public WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);

    }
    /**
     * search login
     */
    @FindBy(name = "login")
    private WebElement loginField;

    /**
     * search password
     */
    @FindBy(name = "password")
    private WebElement passwordField;

    /**
     * search submit
     */
    @FindBy(className = "form__submit")
    private WebElement submitButton;

    /**
     * method input login string
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * method input password string
     */
    public void inputPassword(String login) {
        passwordField.sendKeys(login);
    }

    /**
     * method submit login
     */
    public void submitLogin() {
        submitButton.click();
    }

    /**
     * method clear login field
     */
    public void clearLogin() {
        loginField.clear();
    }
    /**
     * method clear password field
     */
    public void clearPassword() {
        passwordField.clear();
    }

    /**
     * method checked cleared login
     */
    public boolean inputLoginIsClear() {
        return this.isClear(loginField);
    }

    /**
     * method checked cleared password
     */
    public boolean inputPasswordIsClear() {
        return this.isClear(passwordField);
    }

    /**
     * search user email on mail panel
     */
    @FindBy(id = "id-user-email")
    private WebElement userEmail;

    /**
     * method get text from user email
     */
    public String getTextUserEmail(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-user-email")));
        return userEmail.getText();
    }

    /**
     * error message upon failed login
     */
    @FindBy(xpath = "//*[@class='form__error form__error_wrong form__error_visible']")
    private WebElement errorMessage;

    /**
     * method get Error Message
     */
    public String getTextErrorMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form__error form__error_wrong form__error_visible']")));
        return errorMessage.getText();
    }


    /**
     * error message upon empty fields
     */
    @FindBy(xpath = "//*[@class='form__error form__error_emptyBoth form__error_visible']")
    private WebElement errorMessageEmptyFields;

    /**
     * method get Error Message upon empty fields
     */
    public String getTextErrorMessageEmptyFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form__error form__error_emptyBoth form__error_visible']")));
        return errorMessageEmptyFields.getText();
    }

    /**
     * error message upon empty login
     */
    @FindBy(xpath = "//*[@class='form__error form__error_emptyLogin form__error_visible']")
    private WebElement errorMessageEmptyLogin;

    /**
     * method get Error Message
     */
    public String getTextErrorMessageEmptyLogin() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form__error form__error_emptyLogin form__error_visible']")));
        return errorMessageEmptyLogin.getText();
    }

    /**
     * error message upon empty password
     */
    @FindBy(xpath = "//*[@class='form__error form__error_emptyPassword form__error_visible']")
    private WebElement errorMessageEmptyPassword;

    /**
     * method get Error Message
     */
    public String getTextErrorMessageEmptyPassword() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form__error form__error_emptyPassword form__error_visible']")));
        return errorMessageEmptyPassword.getText();
    }

    /**
     * search LOGO
     */
    @FindBy(xpath = "//img[@alt='новини']")
    private WebElement logo;

    /**
     * method to navigate by clicking on Logo
     */
    public void clickOnLogo(){
        logo.click();
    }

    /**
     * find max characters for login field
     */
    public String finMaxCharactersLogin(){
        return loginField.getAttribute("maxlength");
    }

    /**
     * find max characters for password field
     */
    public String finMaxCharactersPassword(){
        return passwordField.getAttribute("maxlength");
    }


    /**
     * search create new email link
     */
    @FindBy(xpath = "//*[text()='Створити скриньку']")
    private WebElement createEmailLink;

    public void clickEmailLink(){
        createEmailLink.click();
    }

    /**
     * search title 'Реєстрація поштової скриньки'
     */
    @FindBy(xpath = "//*[@class='header-title']")
    private WebElement title;

    /**
     * method get text from title
     */
    public String getTextFromTitle() {
        return title.getText();
    }
    /**
     * method switch tabs
     */
    public void switchTab(){
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
    }

    /**
     * search 'Не вда'ється ввійти?' link
     */
    @FindBy(xpath = "//*[text()='Не вдається увійти?']")
    private WebElement cannotLogInLink;

    public void clickOnCannotLogInLink(){
        cannotLogInLink.click();
    }

    /**
     * search title 'Не вдається увійти?' link
     */
    @FindBy(xpath = "//*[@class='GbvW5ssD']")
    private WebElement titleCannotLogIn;

    public String getTitleCannotLogIn(){
        return titleCannotLogIn.getText();
    }

    /**
     * search 'Пошта' link
     */
    @FindBy(xpath = "//*[@class='form__mail-link']")
    private WebElement emailLink;

    public void clickOnEmailLink(){
        emailLink.click();
    }

    /**
     * search title 'Пошта' link
     */
    @FindBy(xpath = "//*[@class='_1azB1YgZ']")
    private WebElement titleEmail;

    public String getTitleEmailLink(){
        return titleEmail.getText();
    }

    /**
     * search 'Вийти' link
     */
    @FindBy(xpath = "//*[@id='id-logout']")
    private WebElement logOut;

    public void clickLogOut(){
        logOut.click();
    }
    /**
     * method switch tab
     */
    public void switchWindow(){
        String window = driver.getWindowHandle();
        driver.switchTo().window(window);
    }
}
