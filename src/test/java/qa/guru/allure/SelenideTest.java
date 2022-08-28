package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    @Feature("Поиск")
    @Story("Поиск Issue")
    @Owner("AnnaMemikova")
    @DisplayName("Поиск конкретного Issue в репозитории")
    public void IssueSearchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").setValue("Selenide").pressEnter();

        $(linkText("selenide/selenide-appium")).click();

        $("#issues-tab").click();

        $(withText("#75")).should(Condition.exist);
    }
}
