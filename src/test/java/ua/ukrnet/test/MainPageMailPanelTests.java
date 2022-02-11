package ua.ukrnet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.ukrnet.context.MainPageContext;
import ua.ukrnet.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MainPageMailPanelTests extends BaseTest {
    @Test
    public void loginEmail() {
        driver.switchTo().frame("mail widget");
        String login = "anastasiia.paniotova@ukr.net";
        String password = "135//79.";

        MainPageContext.login(login, password);
        assertThat(MainPageContext.getTextValidEmail(), anyOf(containsString(login)));

    }
    @Test
    public void loginByInvalidEmail() {
        driver.switchTo().frame("mail widget");

        String password = "135//79";
        String invalidLogin = "invalid@ukr.net";
        String expectedMessage = "Неправильні дані";

        MainPageContext.login(invalidLogin, password);
        assertThat(MainPageContext.getTextInvalidEmail(), containsString(expectedMessage));

    }

    @Test
    public void loginByInvalidPassword(){
        driver.switchTo().frame("mail widget");
        String login = "anastasiia.paniotova@ukr.net";
        String invalidPassword = "invalid";
        String expectedMessage = "Неправильні дані";

        MainPageContext.login(login,invalidPassword);
        assertThat(MainPageContext.getTextInvalidEmail(), containsString(expectedMessage));
    }

    @Test
    public void leaveEmptyFields() {
        driver.switchTo().frame("mail widget");

        String expectedMessageEmptyFields = "Поля мають бути заповнені";

        assertThat(MainPageContext.loginByEmptyFields(),containsString(expectedMessageEmptyFields));

    }

    @Test
    public void leaveEmptyLoginField() {
        driver.switchTo().frame("mail widget");

        String password = "135//79";
        String expectedMessage = "Поле має бути заповнене";

        MainPageContext.loginWithEmptyEmail(password);
        assertThat(MainPageContext.loginByEmptyEmail(),containsString(expectedMessage));
    }

    @Test
    public void leaveEmptyPasswordField() {
        driver.switchTo().frame("mail widget");

        String login = "anastasiia.paniotova@ukr.net";
        String expectedMessage = "Поле має бути заповнене";

        MainPageContext.loginWithEmptyPassword(login);
        assertThat(MainPageContext.loginByEmptyPassword(),containsString(expectedMessage));

    }

    @Test
    public void navigateFromLogoToMainPage() {
        String expectedURL = "https://www.ukr.net/";

        assertThat(MainPageContext.navigateByClickingLogo(),equalTo(expectedURL));
    }

    @Test
    public void checkValidationMaxCharacters() {
        driver.switchTo().frame("mail widget");
        String maxLogin = "32";
        String maxPassword = "128";

        assertThat(MainPageContext.findMaxCharactersLoginField(),equalTo(maxLogin));
        assertThat(MainPageContext.findMaxCharactersPasswordField(),equalTo(maxPassword));
    }

    @Test
    public void navigateUponClickCreateEmail(){
        driver.switchTo().frame("mail widget");
        String title = "Реєстрація поштової скриньки";
        String URL = "https://accounts.ukr.net/registration?client_id=9TFMHJACHt5KxBm2sQWS&lang=uk";

        assertThat(MainPageContext.getTextFromEmailTitle(),equalTo(title));
        assertThat(MainPageContext.getURLFromEmailLink(),equalTo(URL));

    }

    @Test
    public void navigateUponClickCannotLogIn(){
        driver.switchTo().frame("mail widget");
        String title = "Відновлення доступу";
        String URL = "https://accounts.ukr.net/recovery?client_id=9TFMHJACHt5KxBm2sQWS&lang=uk";

        assertThat(MainPageContext.getTextFromCannotLogInTitle(),equalTo(title));
        assertThat(MainPageContext.getURLFromCannotLogInLink(),equalTo(URL));
    }

    @Test
    public void navigateUponClickEmailLink(){
        driver.switchTo().frame("mail widget");
        String title = "Пошта";
        String URL = "https://accounts.ukr.net/login?client_id=9GLooZH9KjbBlWnuLkVX";

        assertThat(MainPageContext.getTextFromEmailLinkTitle(),equalTo(title));
        assertThat(MainPageContext.getURLFromAllEmailLink(),equalTo(URL));


    }







}
