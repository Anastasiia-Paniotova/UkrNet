package ua.ukrnet.context;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.ukrnet.page.MainPage;
import ua.ukrnet.test.BaseTest;

import java.time.Duration;

import static ua.ukrnet.test.BaseTest.driver;

public class MainPageContext {
    public static MainPage mainPage = new MainPage(driver);

    /**
     * full login and check the text in the fields
     */
    public static void login(String login, String password){
        if(mainPage.inputLoginIsClear() && mainPage.inputPasswordIsClear()) {
            mainPage.inputLogin(login);
            mainPage.inputPassword(password);
            mainPage.submitLogin();
        }
    }
    /**
     * clear login and password fields
     */
    public static void clear() {
        mainPage.clearLogin();
        mainPage.clearPassword();
    }

    /**
     * get text upon entering valid login/password
     * verification that user's email is displayed
     */
    public static String getTextValidEmail() {
        return mainPage.getTextUserEmail();
    }

    /**
     * get error message upon failed login
     */
    public static String getTextInvalidEmail() {
        return mainPage.getTextErrorMessage();
    }

    /**
     * get error message upon empty fields
     */
    public static String loginByEmptyFields() {
        mainPage.submitLogin();
        return mainPage.getTextErrorMessageEmptyFields();
    }


    /**
     * leave email field empty
     */
    public static void loginWithEmptyEmail(String password) {
        if (mainPage.inputLoginIsClear() && mainPage.inputPasswordIsClear()) {
            mainPage.inputPassword(password);
            mainPage.submitLogin();
        }
    }

    /**
     * get error message upon empty login
     */
    public static String loginByEmptyEmail() {
        return mainPage.getTextErrorMessageEmptyLogin();
        }

    /**
     * leave password field empty
     */
    public static void loginWithEmptyPassword(String login) {
        if (mainPage.inputLoginIsClear() && mainPage.inputPasswordIsClear()) {
            mainPage.inputLogin(login);
            mainPage.submitLogin();
        }
    }

    /**
     * get error message upon empty password
     */
    public static String loginByEmptyPassword() {
        return mainPage.getTextErrorMessageEmptyPassword();
    }

    /**
     * verification page by clickin on logo icon
     */
    public static String navigateByClickingLogo(){
        mainPage.clickOnLogo();
       return driver.getCurrentUrl();
    }

    /**
     * find max characters for login
     */
    public static String findMaxCharactersLoginField() {
       clear();
       return mainPage.finMaxCharactersLogin();
    }

    /**
     * find max characters for password
     */
    public static String findMaxCharactersPasswordField(){
        clear();
        return mainPage.finMaxCharactersPassword();
    }


}




