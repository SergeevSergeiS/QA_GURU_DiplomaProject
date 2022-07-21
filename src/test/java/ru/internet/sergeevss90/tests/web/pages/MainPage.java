package ru.internet.sergeevss90.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    public SelenideElement
            simpleContentFilter = $(".simple_content"),
            filterInbox = $("#filter_inbox"),
            filterToday = $("#filter_today"),
            filterUpcoming = $("#filter_upcoming"),
            filterLabels = $("#filters_labels"),
            calendar = $(".calendar"),
            monthYear = $(".upcoming_view__calendar__controls__picker"),
            dayMonth = $(".calendar__day").$(".upcoming_view__day_cell__weekday"),
            dateMonth = $(".calendar__day").$(".upcoming_view__day_cell__date__number");
    Locale locale = Locale.US;

    public MainPage checkFilterContent() {
        simpleContentFilter.shouldHave(Condition.exactOwnText("Today"));
        return this;
    }

    public MainPage checkCurrentUrl() {
        String pageType = simpleContentFilter.getOwnText();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url;
        switch (pageType) {
            case "Inbox":
                url = Configuration.baseUrl + "app/project/" + BrowserWebDriver.config.projectNumber();
                assertEquals(url, currentUrl);
                break;
            case "Today":
                url = Configuration.baseUrl + "app/today";
                assertEquals(url, currentUrl);
                break;
            case "Filters & Labels":
                url = Configuration.baseUrl + "app/filters-labels";
                assertEquals(url, currentUrl);
                break;
            default:
                assertEquals("", currentUrl);
        }
        return this;
    }

    public MainPage openPage() {
        open("app/today");
        return this;
    }

    public MainPage checkFilterAvailability() {
        simpleContentFilter.shouldNotBe(Condition.visible);
        return this;
    }

    public MainPage openFilterInbox() {
        filterInbox.click();
        return this;
    }

    public MainPage openFilterToday() {
        filterToday.click();
        return this;
    }

    public MainPage openFilterLabels() {
        filterLabels.click();
        return this;
    }

    public MainPage openFilterUpcoming() {
        filterUpcoming.click();
        return this;
    }

    public MainPage checkFilterUpcoming() {
        calendar.shouldBe(Condition.visible);
        return this;
    }

    public MainPage checkUpcomingDate() {
        String dateCheck = String.format("%s %s %s",
                monthYear.innerText(), dayMonth.innerText(), dateMonth.innerText());
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM y E d", locale);
        Date dateNow = new Date();
        try {
            Date date = formatter.parse(dateCheck);
            assertEquals(formatter.format(date), formatter.format(dateNow));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }
}