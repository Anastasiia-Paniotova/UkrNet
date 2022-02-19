package test.java.ua.ukrnet.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.ua.ukrnet.configuration.ConfProperties;
import test.java.ua.ukrnet.configuration.DataProperties;
import test.java.ua.ukrnet.context.MainPageContext;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class MainPageMailPanelTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public static void precondition(){
        driver.get(ConfProperties.getProperty("homePage"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test(groups = {"mail-panel"},priority = 12)
    public void loginEmail() {
        driver.switchTo().frame("mail widget");
        String login = DataProperties.getProperty("validEmail");
        String password = DataProperties.getProperty("validPassword");

        MainPageContext.login(login, password);
        assertThat(MainPageContext.getTextValidEmail(), containsString(login));

    }
    //can be failed because of Captha
    @Test (groups = {"mail-panel"},priority = 9)
    public void loginByInvalidEmail() {
        driver.switchTo().frame("mail widget");

        String password = DataProperties.getProperty("validPassword");
        String invalidLogin = DataProperties.getProperty("invalidEmail");
        String expectedMessage = "Неправильні дані";

        MainPageContext.login(invalidLogin, password);
        assertThat(MainPageContext.getTextInvalidEmail(), containsString(expectedMessage));
    }

    @Test (groups = {"mail-panel"},priority = 10)
    public void loginByInvalidPassword(){
        driver.switchTo().frame("mail widget");
        String login = DataProperties.getProperty("validEmail");
        String invalidPassword = DataProperties.getProperty("invalidPassword");
        String expectedMessage = "Неправильні дані";

        MainPageContext.login(login,invalidPassword);
        assertThat(MainPageContext.getTextInvalidEmail(), containsString(expectedMessage));
    }

    @Test (groups = {"mail-panel"},priority = 1)
    public void leaveEmptyFields() {
        driver.switchTo().frame("mail widget");


        String expectedMessageEmptyFields = "Поля мають бути заповнені";

        assertThat(MainPageContext.loginByEmptyFields(),containsString(expectedMessageEmptyFields));

    }

    @Test (groups = {"mail-panel"},priority = 2)
    public void leaveEmptyLoginField() {

        driver.switchTo().frame("mail widget");

        String password = DataProperties.getProperty("validPassword");
        String expectedMessage = "Поле має бути заповнене";

        MainPageContext.loginWithEmptyEmail(password);
        assertThat(MainPageContext.loginByEmptyEmail(),containsString(expectedMessage));

    }

    @Test (groups = {"mail-panel"},priority = 3)
    public void leaveEmptyPasswordField() {

        driver.switchTo().frame("mail widget");

        String login = DataProperties.getProperty("validEmail");
        String expectedMessage = "Поле має бути заповнене";

        MainPageContext.loginWithEmptyPassword(login);
        assertThat(MainPageContext.loginByEmptyPassword(),containsString(expectedMessage));

    }

    @Test (groups = {"mail-panel"},priority = 4)
    public void navigateFromLogoToMainPage() {
        String expectedURL = DataProperties.getProperty("expectedURL");

        assertThat(MainPageContext.navigateByClickingLogo(),equalTo(expectedURL));
    }

    @Test (groups = {"mail-panel"},priority = 5)
    public void checkValidationMaxCharacters() {
        driver.switchTo().frame("mail widget");

        String maxLogin = DataProperties.getProperty("maxLogin");
        String maxPassword = DataProperties.getProperty("maxPassword");

        assertThat(MainPageContext.findMaxCharactersLoginField(),equalTo(maxLogin));
        assertThat(MainPageContext.findMaxCharactersPasswordField(),equalTo(maxPassword));
    }

    @Test (groups = {"mail-panel"},priority = 6)
    public void navigateUponClickCreateEmail(){

        driver.switchTo().frame("mail widget");
        String title = "Реєстрація поштової скриньки";
        String URL = DataProperties.getProperty("accountURL");

        assertThat(MainPageContext.getTextFromEmailTitle(),equalTo(title));
        assertThat(MainPageContext.getURLFromEmailLink(),equalTo(URL));

    }

    @Test (groups = {"mail-panel"},priority = 7)
    public void navigateUponClickCannotLogIn(){

        driver.switchTo().frame("mail widget");
        String title = "Відновлення доступу";
        String URL = DataProperties.getProperty("accessURL");

        assertThat(MainPageContext.getTextFromCannotLogInTitle(),equalTo(title));
        assertThat(MainPageContext.getURLFromCannotLogInLink(),equalTo(URL));
    }

    @Test (groups = {"mail-panel"},priority = 8)
    public void navigateUponClickEmailLink(){

        driver.switchTo().frame("mail widget");
        String title = "Пошта";
        String URL = DataProperties.getProperty("emailURL");

        assertThat(MainPageContext.getTextFromEmailLinkTitle(),equalTo(title));
        assertThat(MainPageContext.getURLFromAllEmailLink(),equalTo(URL));
    }

    @Test (groups = {"mail-panel"},priority = 11)
    public void logOut(){
        driver.switchTo().frame("mail widget");
        String login = DataProperties.getProperty("validEmail");
        String password = DataProperties.getProperty("validPassword");

        MainPageContext.login(login, password);
        assertThat(MainPageContext.getTextValidEmail(), containsString(login));

        Assert.assertTrue(MainPageContext.checkLogOut());
    }
    /**
     * 12 tests
     */
}
