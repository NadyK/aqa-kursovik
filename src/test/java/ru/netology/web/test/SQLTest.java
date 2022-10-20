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
import ru.netology.web.page.SQLRequest;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SQLTest {

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
    void shouldCheckStatusDBApprovedCard() {
        SQLRequest.clearDB();
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getApprovedCard());
        inputCardDetails.successMessageVisible();
        String actual = SQLRequest.getStatus();
        assertEquals("APPROVED", actual);
    }
    @Test
    void shouldCheckStatusDBDeclinedCard() {
        SQLRequest.clearDB();
        var inputCardDetails = new InputCardDetails();
        inputCardDetails.fillingInFields(DataHelper.CardDetails.getDeclinedCard());
      //inputCardDetails.errorMessageVisible();
        inputCardDetails.successMessageVisible();
        String actual = SQLRequest.getStatus();
        assertEquals("DECLINED", actual);
    }
}
