package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.InputCardDetails;
import ru.netology.web.page.PaymentСhoice;

import static com.codeborne.selenide.Selenide.open;

public class UITest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }

    @BeforeEach
    public void paymentСhoiceAndCleanForm() {
        var paymentСhoice = new PaymentСhoice();
        paymentСhoice.cardPayment();
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.clearFields();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldInputApprovedCard() {

        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCard());
        inputCardDetails.successMessageVisible();
        inputCardDetails.errorMessageNotVisible();
    }

    @Test
    void shouldInputDeclinedCard() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getDeclinedCard());
        inputCardDetails.errorMessageVisible();
        inputCardDetails.successMessageNotVisible();
    }

    @Test
    void shouldInputAnotherCard() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getAnotherCard());
        inputCardDetails.errorMessageVisible();
        inputCardDetails.successMessageNotVisible();
    }

    @Test
    void shouldInputInvalidCardEmptyFields() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getInvalidCardNumberEmpty());
        inputCardDetails.errorMessageCardNumberEmpty();
    }

    @Test
    void shouldInputInvalidCardNumber() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getInvalidCardNumber());
        inputCardDetails.errorMessageInvalidCardNumber();
    }

    @Test
    void shouldInputInvalidMonth00() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidMonth00());
        inputCardDetails.errorMessageInvalidMonth();
    }

    @Test
    void shouldInputInvalidMonth13() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidMonth13());
        inputCardDetails.errorMessageInvalidMonth();
    }

    @Test
    void shouldInputInvalidMonthEmptyField() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidMonthEmpty());
        inputCardDetails.errorMessageInvalidMonthEmpty();
    }

    @Test
    void shouldInputInvalidMonth1Symbol() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidMonth1Symbol());
        inputCardDetails.errorMessageInvalidMonth1Symbol();
    }

    @Test
    void shouldInputInvalidLastYear() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidLastYear());
        inputCardDetails.errorMessageInvalidLastYear();
    }

    @Test
    void shouldInputInvalidOwnerRu() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidOwnerRu());
        inputCardDetails.errorMessageInvalidOwner();
    }

    @Test
    void shouldInputInvalidOwnerSpcSymbolNmb() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidOwnerSpcSymbolNmb());
        inputCardDetails.errorMessageInvalidOwner();
    }

    @Test
    void shouldInputInvalidOwnerEmptyField() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidOwnerSpcEmpty());
        inputCardDetails.errorMessageInvalidOwnerEmpty();
    }

    @Test
    void shouldInputInvalidCVC1Symbol() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidCVC1Symbol());
        inputCardDetails.errorMessageInvalidCVC();
    }

    @Test
    void shouldInputInvalidCVCSpcSymbolLetter() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidCVCSpcSymbolLetter());
        inputCardDetails.errorMessageInvalidCVC();
    }

    @Test
    void shouldInputInvalidCVCEmptyField() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCardInvalidCVCEmpty());
        inputCardDetails.errorMessageInvalidCVCEmpty();
    }
}
