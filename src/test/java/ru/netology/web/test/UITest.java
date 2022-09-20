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

import static com.codeborne.selenide.Selenide.open;

public class UITest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }
    @BeforeEach
    public void cleanForm() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.paymentСhoice();
        inputCardDetails.clearFields();
    }
    //public void cleanBase() {
        //DatabaseHelper.clearDB();}

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @Test
    void shouldApprovedCard() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCard());
        inputCardDetails.successMessage();
    }
    @Test
    void shouldDeclinedCard() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getDeclinedCard());
        inputCardDetails.errorMessage();
    }
    @Test
    void shouldAnotherCard() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getAnotherCard());
        inputCardDetails.errorMessage();
    }

    @Test
    void shouldInvalidCardEmpty() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getInvalidCardNumberEmpty());
        inputCardDetails.errorMessageCardNumberEmpty();
    }

    @Test
    void shouldInvalidCardNumber() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getInvalidCardNumber());
        inputCardDetails.errorMessageInvalidCardNumber();
    }

    @Test
    void shouldInvalidMonth00() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidMonth00());
        inputCardDetails.errorMessageInvalidMonth();
    }

    @Test
    void shouldInvalidMonth13() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidMonth13());
        inputCardDetails.errorMessageInvalidMonth();
    }

    @Test
    void shouldInvalidMonthEmpty() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidMonthEmpty());
        inputCardDetails.errorMessageInvalidMonthEmpty();
    }

    @Test
    void shouldInvalidMonth1Symbol() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidMonth1Symbol());
        inputCardDetails.errorMessageInvalidMonth1Symbol();
    }

    @Test
    void shouldInvalidLastYear() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidLastYear());
        inputCardDetails.errorMessageInvalidLastYear();
    }
    @Test
    void shouldInvalidOwnerRu() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidOwnerRu());
        inputCardDetails.errorMessageInvalidOwner();
    }
    @Test
    void shouldInvalidOwnerSpcSymbolNmb() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidOwnerSpcSymbolNmb());
        inputCardDetails.errorMessageInvalidOwner();
    }
    @Test
    void shouldInvalidOwnerEmpty() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidOwnerSpcEmpty());
        inputCardDetails.errorMessageInvalidOwnerEmpty();
    }
    @Test
    void shouldInvalidCVC1Symbol() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidCVC1Symbol());
        inputCardDetails.errorMessageInvalidCVC();
    }
    @Test
    void shouldInvalidCVCSpcSymbolLetter() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidCVCSpcSymbolLetter());
        inputCardDetails.errorMessageInvalidCVC();
    }
    @Test
    void shouldInvalidCVCEmpty() {
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.card(DataHelper.CardDetails.getApprovedCardInvalidCVCEmpty());
        inputCardDetails.errorMessageInvalidCVCEmpty();
    }
}
