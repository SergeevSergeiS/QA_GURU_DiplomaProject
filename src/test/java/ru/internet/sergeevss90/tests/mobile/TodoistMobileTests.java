package ru.internet.sergeevss90.tests.mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


;
import static com.codeborne.selenide.Selenide.*;
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
            $(AppiumBy.id("com.todoist:id/email_exists_input")).sendKeys("Kast666xxx@mail.ru");
            $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
        });
        step("Вводим пароль", () -> {
            $(AppiumBy.id("com.todoist:id/log_in_password")).sendKeys("Maestro6789");
            $(AppiumBy.id("com.todoist:id/btn_log_in")).click();
        });
        step("Проверяем авторизацию", () -> {
            $(AppiumBy.id("com.todoist:id/fab")).shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Авторизация с невалидным email")
    void loginInvalidEmailTest() {
        step("Выбираем войти через email", () ->
                $(AppiumBy.id("com.todoist:id/btn_welcome_email")).click());
        step("Вводим невалидный email", () -> {
            $(AppiumBy.id("com.todoist:id/email_exists_input")).sendKeys("tak25047");
            $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
        });
        step("Проверяем наличие ошибки", () ->
                $(AppiumBy.id("com.todoist:id/textinput_error")).shouldHave(Condition.text("Email is invalid")));
    }

    @Test
    @DisplayName("Авторизация с незарегистрированным email")
    void loginUnEmailTest() {
        step("Выбираем войти через email", () ->
                $(AppiumBy.id("com.todoist:id/btn_welcome_email")).click());
        step("Вводим незарегистрированный ранее email", () -> {
            $(AppiumBy.id("com.todoist:id/email_exists_input")).sendKeys("tak250445464@yuoia.com");
            $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
        });
        step("Проверяем открытие страницы регистрации", () ->
                $(AppiumBy.id("com.todoist:id/sign_up_container")).$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(Condition.text("Sign up")));
    }

    @Test
    @DisplayName("Создание новой задачи")
    void createTaskTest() {
        step("Авторизуемся", () -> {
            $(AppiumBy.id("com.todoist:id/btn_welcome_email")).click();
            $(AppiumBy.id("com.todoist:id/email_exists_input")).sendKeys("Kast666xxx@mail.ru");
            $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
            $(AppiumBy.id("com.todoist:id/log_in_password")).sendKeys("Maestro6789");
            $(AppiumBy.id("com.todoist:id/btn_log_in")).click();
        });
        step("Нажимаем создать задачу", () ->
                $(AppiumBy.id("com.todoist:id/fab")).click());
        step("Вводим имя и описание задачи", () -> {
            $(AppiumBy.id("android:id/message")).sendKeys("New Task");
        });
        step("Нажимаем Создать задачу", () ->
                $$(AppiumBy.id("android:id/button1")).last().click());
        back();
        step("Проверяем создание задачи", () -> {
            $$(AppiumBy.id("com.todoist:id/text")).last().shouldHave(Condition.text("New Task"));
        });
    }

    @Test
    @DisplayName("Создание нового проекта")
    void createProjectTest() {
        step("Авторизуемся", () -> {
            $(AppiumBy.id("com.todoist:id/btn_welcome_email")).click();
            $(AppiumBy.id("com.todoist:id/email_exists_input")).sendKeys("Kast666xxx@mail.ru");
            $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
            $(AppiumBy.id("com.todoist:id/log_in_password")).sendKeys("Maestro6789");
            $(AppiumBy.id("com.todoist:id/btn_log_in")).click();
        });
        step("Открываем меню", () ->
                $(AppiumBy.className("android.widget.ImageButton")).click());
        step("Нажимаем Создать проект", () ->
                $(AppiumBy.id("com.todoist:id/add")).click());
        step("Вводим имя проекта", () ->
                $(AppiumBy.id("com.todoist:id/name")).sendKeys("New Project"));
        step("Нажимаем Добавить в избранное", () ->
                $(AppiumBy.id("com.todoist:id/favorite")).click());
        step("Нажимаем Создать проект", () ->
                $(AppiumBy.id("com.todoist:id/menu_form_submit")).click());
        step("Проверяем создание проекта", () ->
                $(AppiumBy.id("com.todoist:id/toolbar")).$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(Condition.text("New Project")));
    }

    @Test
    @DisplayName("Поиск проекта")
    void searchProjectTest() {
        step("Авторизуемся", () -> {
            $(AppiumBy.id("com.todoist:id/btn_welcome_email")).click();
            $(AppiumBy.id("com.todoist:id/email_exists_input")).sendKeys("Kast666xxx@mail.ru");
            $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
            $(AppiumBy.id("com.todoist:id/log_in_password")).sendKeys("Maestro6789");
            $(AppiumBy.id("com.todoist:id/btn_log_in")).click();
        });
        step("Нажимаем кнопку поиска", () ->
                $(AppiumBy.id("com.todoist:id/menu_content_search")).click());
        step("Вводим поисковый запрос", () ->
                $(AppiumBy.id("com.todoist:id/search_edit_text")).sendKeys("For Search Test"));
        step("Проверяем наличие запроса в поисковой выдаче", () -> {
            $(AppiumBy.id("com.todoist:id/search_results")).$(AppiumBy.id("android:id/title"))
                    .shouldHave(Condition.text("Projects"));
            $(AppiumBy.id("com.todoist:id/search_results")).$(AppiumBy.id("com.todoist:id/content"))
                    .shouldHave(Condition.text("For Search Test"));
        });
    }
}
