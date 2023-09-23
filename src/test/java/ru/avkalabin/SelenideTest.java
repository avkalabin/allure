package ru.avkalabin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {


    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("avkalabin")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка Issue с Чистый Selenide (с Listener)")
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("avkalabin/allure").pressEnter();
        $(byLinkText("avkalabin/allure")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);


    }
}
