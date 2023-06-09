package ru.avkalabin;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[placeholder='Search GitHub']").setValue(repo).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(byLinkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }


}
