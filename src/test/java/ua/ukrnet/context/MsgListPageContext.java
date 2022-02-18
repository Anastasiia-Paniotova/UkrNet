package test.java.ua.ukrnet.context;

import org.apache.log4j.Logger;
import test.java.ua.ukrnet.page.MsgListPage;

import java.util.ArrayList;

import static test.java.ua.ukrnet.test.BaseTest.driver;

public class MsgListPageContext {
    public static MsgListPage msgListPage = new MsgListPage(driver);
    public static Logger log = Logger.getLogger("logger");

    public static void switchWindow(){
        msgListPage.switchWindow();
        driver.switchTo().frame("mail widget");
        log.info("the window was switched");
    }

    /**
     * navigate to the Message List Page upon clicking 'Вхідні'
     */
    public static void navigateMessageListLink(){
        msgListPage.clickMessageListLink();
        msgListPage.switchTab();
        log.info("the window was switched");
    }

    /**
     * get URL
     */
    public static String getURL(){
        log.info("the current URL is " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    /**
     * check components on left panel
     */
    public static int getSizeList(){
        return msgListPage.getSizeOfComponentsList();
    }

    public static ArrayList getListOfTitles(){
       return msgListPage.listComponents();
    }

    /**
     * click on 'Надіслати листа'
     */
    public static void clickSendLetter(){
        log.info("the send letter panel is opening");
        msgListPage.clickSendLetter();
    }

    public static Boolean isDisplayedScreenContent(){
        return msgListPage.isDisplayedScreenContent();
    }

    public static Boolean isNotDisplayedScreenContent(){
        return msgListPage.isNotDisplayedScreenContent();
    }

    public static void clickCancel(){
        msgListPage.clickCancel();
    }

    /**
     * send letter
     */
    public static void sendLetter(String recipient,String subject){
        msgListPage.clickSendLetter();
        log.info("the send letter panel is opening");
        msgListPage.inputRecipient(recipient);
        msgListPage.inputSubject(subject);
        msgListPage.clickSendButton();
        log.info("the letter is send");
    }

    /**
     * check confirm message
     */
    public static Boolean checkConfirmMessage(){
        return msgListPage.isDisplayedConfirmMessage();
    }

    /**
     * verify that the letter moves to 'Надіслані' and has the correct email
     */
    public static String getDataNameSentLetter(){
        msgListPage.clickSentLettersSubMenu();
        log.info("the email is " + msgListPage.getDataName());
        return msgListPage.getDataName();
    }

    public static String getSubjectDataSentLetter(){
        return msgListPage.getDataSubject();
    }

    /**
     * send letter without recipient
     */
    public static void sendLetterWithoutRecipient(String subject){
        msgListPage.clickSendLetter();
        msgListPage.inputSubject(subject);
        msgListPage.clickSendButton();
        log.info("the letter is sent");
    }

    public static String getAlertWithoutRecipientText(){ return msgListPage.getAlertWithoutRecipientText(); }

    public static void clickCancelAlert(){
        msgListPage.clickCancelAlert();
    }

    /**
     * verify that the not sent letter moves to 'Чернетки' and has the correct subject
     */
    public static String getSubjectFromDrafts(){
        msgListPage.clickDrafts();
        log.info("the subject is " + msgListPage.getDataSubject());
        return msgListPage.getDataSubject();
    }

    /**
     * send letter without subject with recipient
     */
    public static void sendLetterWithoutSubject(String recipient) {
        msgListPage.clickSendLetter();
        msgListPage.inputRecipient(recipient);
        msgListPage.clickSendButton();
        log.info("the letter without subject is sent");
    }

    public static String getTextAlertWithoutSubject(){
        return msgListPage.getTextAlertWithoutSubject();
    }


    /**
     * methods for right sidebar
     */
    public static Boolean isPresentsOfCollapseExpand() {
        return msgListPage.collapseAndExpandedIsDisplayed();
    }

    public static String getTextContacts() { return msgListPage.getTextContactsTitle();}

    public static String getTypeContacts() { return msgListPage.getTypeContactToggle();}

    public static String getTextGroups() { return msgListPage.getTextGroupsTitle();}

    public static String getTypeGroups() { return msgListPage.getTypeGroupsToggle();}

    /**
     * methods for verifying that header option are disabled for 'Вхідні' by default
     */
    public static Boolean isDisableForward(){ return msgListPage.isDisplayedForward();}

    public static Boolean isDisableRemove(){ return msgListPage.isDisplayedRemove();}

    public static Boolean isDisableSpam(){return msgListPage.isDisplayedSpam();}

    public static Boolean isDisableMove() {return msgListPage.isDisplayedMove();}

    public static Boolean isDisableMore() {return msgListPage.isDisplayedMore();}

    /**
     * method to select checkbox
     */
    public static void selectCheckbox(){
        msgListPage.selectCheckbox();
    }

    /**
     * methods for verifying that header option are enabled for 'Вхідні' upon selection checkbox
     */
    public static Boolean isEnabledForward() {return msgListPage.isEnabledForward();}

    public static Boolean isEnabledRemove() {return msgListPage.isEnabledRemove();}

    public static Boolean isEnabledSpam() {return msgListPage.isEnabledSpam();}

    public static Boolean isEnabledMove() {return msgListPage.isEnabledMove();}

    public static Boolean isEnabledMore() {return msgListPage.isEnabledMore();}

}
