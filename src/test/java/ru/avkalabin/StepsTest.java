package ru.avkalabin;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPOSITORY = "avkalabin/allure";
    private static final int ISSUE = 1;

    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("avkalabin")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка Issue с Lambda steps")
    @Test
    public void testLambdaTest() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[placeholder='Search GitHub']").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }


    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("avkalabin")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка Issue с @Steps")
    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
