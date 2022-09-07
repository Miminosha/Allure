package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsSelenideTest {
    private static final String REPO = "selenide/selenide-appium";
    private static final int ISSUE = 75;

    @Test
    public void issueSearchLambdaStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу GitHub", () -> {
            open("https://github.com/");
        });

        step("Ищем нужный репозиторий" + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPO).pressEnter();
        });

        step("Переходим в репозиторий" + REPO, () -> {
            $(linkText("selenide/selenide-appium")).click();
        });

        step("Переходим во вкладку Issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие нужного элемента Issue с номером" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void issueSearchStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebStepsTest steps = new WebStepsTest();
        steps.openMainPage();
        steps.findRepo(REPO);
        steps.goToRepo(REPO);
        steps.goToIssue();
        steps.chekingIssue(ISSUE);
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLigs();

    }
}


