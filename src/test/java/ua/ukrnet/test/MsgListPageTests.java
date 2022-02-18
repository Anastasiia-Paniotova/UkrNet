package test.java.ua.ukrnet.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.ua.ukrnet.configuration.DataProperties;
import test.java.ua.ukrnet.context.MainPageContext;
import test.java.ua.ukrnet.context.MsgListPageContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MsgListPageTests extends BaseTest{
    @BeforeMethod
    public static void setUpLogin(){
        driver.switchTo().frame("mail widget");
        String login = DataProperties.getProperty("validEmail");
        String password = DataProperties.getProperty("validPassword");

        MainPageContext.login(login,password);
        MsgListPageContext.switchWindow();
        MsgListPageContext.navigateMessageListLink();
    }

    @Test
    public void checkURL() {
        String expectedURL = "https://mail.ukr.net/desktop#msglist/f0/p0";
        assertThat(MsgListPageContext.getURL(),equalTo(expectedURL));
    }

    @Test
    public void checkComponents(){
        String componentCount = "8";
        ArrayList<String> titles =new ArrayList<>(Arrays.asList
                ("Вхідні", "Чернетки", "Надіслані", "Спам", "Видалені", "Непрочитані", "Відмічені", "Вкладення"));

        assertThat(String.valueOf(MsgListPageContext.getSizeList()), equalTo(componentCount));
        assertThat(MsgListPageContext.getListOfTitles(),equalTo(titles));
    }

    @Test
    public void cancelTheLetter(){
        MsgListPageContext.clickSendLetter();
        Assert.assertTrue(MsgListPageContext.isDisplayedScreenContent());

        MsgListPageContext.clickCancel();
        Assert.assertFalse(MsgListPageContext.isNotDisplayedScreenContent());
    }

    @Test
    public void sendTheLetterAndVerify() {
        String recipient = DataProperties.getProperty("recipient");
        String subject = DataProperties.getProperty("subject");

        MsgListPageContext.sendLetter(recipient,subject);
        Assert.assertTrue(MsgListPageContext.checkConfirmMessage());

        assertThat(MsgListPageContext.getDataNameSentLetter(), equalTo(recipient));
        assertThat(MsgListPageContext.getSubjectDataSentLetter(),equalTo(subject));
    }

    @Test
    public void getAlertSendTheLetterWithoutRecipient(){
        String subject = DataProperties.getProperty("subject");
        String alert = "Потрібно вказати хоча б одного отримувача в полі 'Кому'";

        MsgListPageContext.sendLetterWithoutRecipient(subject);
        assertThat(MsgListPageContext.getAlertWithoutRecipientText(),containsString(alert));
    }

    @Test
    public void sendLetterWithoutRecipient(){
        String subject = DataProperties.getProperty("subject");

        MsgListPageContext.sendLetterWithoutRecipient(subject);
        MsgListPageContext.clickCancelAlert();

        assertThat(MsgListPageContext.getSubjectFromDrafts(),equalTo(subject));
    }

    @Test
    public void sendLetterWithoutSubject(){
        String recipient = DataProperties.getProperty("recipient");
        String alertTitle = "Увага";
        String alertTopic = "Тема листа не вказана";
        String alertList = "Порожній лист";

        MsgListPageContext.sendLetterWithoutSubject(recipient);

        assertThat(MsgListPageContext.getTextAlertWithoutSubject(),
                allOf(containsString(alertTitle),containsString(alertTopic),containsString(alertList)));

    }

    @Test
    public void checkRightSideComponents(){
        String contacts = "Контакти";
        String groups = "Групи";
        String type = "button";

        Assert.assertTrue(MsgListPageContext.isPresentsOfCollapseExpand());
        assertThat(MsgListPageContext.getTextContacts(),equalTo(contacts));
        assertThat(MsgListPageContext.getTextGroups(),equalTo(groups));

        assertThat(MsgListPageContext.getTypeContacts(),equalTo(type));
        assertThat(MsgListPageContext.getTypeGroups(),equalTo(type));
    }

    @Test
    public void isDisabledHeaderOptionsByDefault(){
        Assert.assertTrue(MsgListPageContext.isDisableForward());
        Assert.assertTrue(MsgListPageContext.isDisableRemove());
        Assert.assertTrue(MsgListPageContext.isDisableSpam());
        Assert.assertTrue(MsgListPageContext.isDisableMove());
        Assert.assertTrue(MsgListPageContext.isDisableMore());
    }


    @Test
    public void isEnabledHeaderOptions(){
        String recipient = DataProperties.getProperty("recipient");
        String subject = DataProperties.getProperty("subject");

        MsgListPageContext.sendLetter(recipient,subject);
        MsgListPageContext.navigateMessageListLink();
        MsgListPageContext.selectCheckbox();

        Assert.assertTrue(MsgListPageContext.isEnabledForward());
        Assert.assertTrue(MsgListPageContext.isEnabledRemove());
        Assert.assertTrue(MsgListPageContext.isEnabledSpam());
        Assert.assertTrue(MsgListPageContext.isEnabledMove());
        Assert.assertTrue(MsgListPageContext.isEnabledMore());

    }

    /**
     * 10 tests
     */


}
