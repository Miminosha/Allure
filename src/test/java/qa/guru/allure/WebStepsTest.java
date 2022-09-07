package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest extends TestBase {

    @Step("Открываем главную страницу GitHub")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void findRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo).pressEnter();
    }

    @Step("Переходим в репозиторий {repo}")
    public void goToRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Переходим во вкладку Issue")
    public void goToIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие нужного элемента Issue с номером {issue}")
    public void chekingIssue(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
