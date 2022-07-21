package ru.internet.sergeevss90.tests.mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("MOBILE")
@Tag("ALL")
public class TodoistMobileTests extends TestBase {
    @Test
    @DisplayName("Авторизация зарегистрированного пользователя")
    void loginTest() {
        step("Выбираем войти через email", () ->
                $(AppiumBy.id("com.todoist:id/btn_welcome_email")).click());
        step("Вводим email", () -> {
            $(AppiumBy.id("com.todoist:id/email_exists_input")).setValue("tak25047@yuoia.com");
            $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
        });
        step("Вводим пароль", () -> {
            $(AppiumBy.id("com.todoist:id/log_in_password")).setValue("tak250471");
            $(AppiumBy.id("com.todoist:id/btn_log_in")).click();
        });
        step("Проверяем авторизацию", () ->
                $(AppiumBy.id("com.todoist:id/toolbar")).$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(Condition.text("Inbox")));
    }
}
