package ua.ukrnet.test;

import org.openqa.selenium.By;
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
    public void loginByInvalidValues() {
        driver.switchTo().frame("mail widget");
        String login = "anastasiia.paniotova@ukr.net";
        String password = "135//79";

        String invalidLogin = "invalid@ukr.net";
        String invalidPassword = "invalid";

        String expectedMessage = "Неправильні дані";

        MainPageContext.login(invalidLogin, password);
        assertThat(MainPageContext.getTextInvalidEmail(), anyOf(containsString(expectedMessage)));

        MainPageContext.clear();
        MainPageContext.login(login,invalidPassword);
        assertThat(MainPageContext.getTextInvalidEmail(), anyOf(containsString(expectedMessage)));

    }

    @Test
    public void leaveEmptyFields() {
        driver.switchTo().frame("mail widget");
        String login = "anastasiia.paniotova@ukr.net";
        String password = "135//79";
        String expectedMessage = "Поле має бути заповнене";
        String expectedMessageEmptyFields = "Поля мають бути заповнені";

        assertThat(MainPageContext.loginByEmptyFields(),containsString(expectedMessageEmptyFields));
        MainPageContext.clear();

        MainPageContext.loginWithEmptyEmail(password);
        assertThat(MainPageContext.loginByEmptyEmail(),containsString(expectedMessage));
        MainPageContext.clear();

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
}
