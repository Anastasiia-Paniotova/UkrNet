package test.java.ua.ukrnet.context;

import org.apache.log4j.Logger;
import test.java.ua.ukrnet.page.MainPage;

import static test.java.ua.ukrnet.test.BaseTest.driver;

public class MainPageContext {
    public static MainPage mainPage = new MainPage(driver);
    public static Logger log = Logger.getLogger("logger");

    /**
     * full login and check the text in the fields
     */
    public static void login(String login, String password){
        log.info("login is started");
        if(mainPage.inputLoginIsClear() && mainPage.inputPasswordIsClear()) {
            mainPage.inputLogin(login);
            mainPage.inputPassword(password);
            mainPage.submitLogin();
        }
        log.info("login is finished");
    }

    /**
     * method to clear login and password fields
     */
    public static void clear() {
        log.info("clear the fields");
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
        log.info("login with empty email is staring");
        if (mainPage.inputLoginIsClear() && mainPage.inputPasswordIsClear()) {
            mainPage.inputPassword(password);
            mainPage.submitLogin();
        }
        log.info("login with empty email is finished");

    }

    /**
     * get error message upon entering empty login
     */
    public static String loginByEmptyEmail() {
        return mainPage.getTextErrorMessageEmptyLogin();
        }

    /**
     * leave password field empty
     */
    public static void loginWithEmptyPassword(String login) {
        log.info("login with empty password is starting");
        if (mainPage.inputLoginIsClear() && mainPage.inputPasswordIsClear()) {
            mainPage.inputLogin(login);
            mainPage.submitLogin();
        }
        log.info("login with empty password is finished");
    }

    /**
     * get error message upon entering empty password
     */
    public static String loginByEmptyPassword() {
        return mainPage.getTextErrorMessageEmptyPassword();
    }

    /**
     * verification the current page by clicking on LOGO icon
     */
    public static String navigateByClickingLogo(){
        mainPage.clickOnLogo();
        log.info("return the current URL is " + driver.getCurrentUrl());
       return driver.getCurrentUrl();
    }

    /**
     * find max characters for login
     */
    public static String findMaxCharactersLoginField() {
       clear();
       log.info("the max characters for login field is " + mainPage.finMaxCharactersLogin());
       return mainPage.finMaxCharactersLogin();
    }

    /**
     * find max characters for password
     */
    public static String findMaxCharactersPasswordField(){
        clear();
        log.info("the max characters for password is " + mainPage.finMaxCharactersPassword()) ;
        return mainPage.finMaxCharactersPassword();
    }

    /**
     * get text from 'Реєстрація поштової скриньки' title
     */
    public static String getTextFromEmailTitle() {
        mainPage.clickEmailLink();
        mainPage.switchTab();
        log.info("the tab was switched");
        return mainPage.getTextFromTitle();
    }
    /**
     * get URL after click on Email link
     */
    public static String getURLFromEmailLink(){
        return driver.getCurrentUrl();
    }

    /**
     * get text from 'Не вдається увійти?' title
     */
    public static String getTextFromCannotLogInTitle(){
        mainPage.clickOnCannotLogInLink();
        mainPage.switchTab();
        log.info("the tab was switched");
        return mainPage.getTitleCannotLogIn();
    }

    public static String getURLFromCannotLogInLink(){
        return driver.getCurrentUrl();
    }

    /**
     * get text from 'Пошта' title
     */
    public static String getTextFromEmailLinkTitle(){
        mainPage.clickOnEmailLink();
        mainPage.switchTab();
        log.info("the tab was switched");
        return mainPage.getTitleEmailLink();
    }

    public static String getURLFromAllEmailLink(){
        return driver.getCurrentUrl();
    }

    /**
     * check log out option
     */
    public static Boolean checkLogOut(){
        mainPage.clickLogOut();
        mainPage.switchWindow();
        log.info("the window was switched");
        driver.switchTo().frame("mail widget");
        return mainPage.inputPasswordIsClear() && mainPage.inputLoginIsClear();
    }








}




