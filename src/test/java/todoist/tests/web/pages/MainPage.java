package todoist.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import todoist.tests.web.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static todoist.tests.web.TestData.*;

public class MainPage {

    CalendarComponent calendar = new CalendarComponent();
    public SelenideElement
            simpleContentFilter = $(".simple_content"),
            filterInbox = $("#filter_inbox"),
            filterToday = $("#filter_today"),
            filterUpcoming = $("#filter_upcoming"),
            filterLabels = $("#filters_labels"),
            calendarLocator = $(".calendar");

    public MainPage checkFilterContent() {
        simpleContentFilter.shouldHave(Condition.exactOwnText("Today"));
        return this;
    }

    public MainPage openPage() {
        open(todayUrl);
        return this;
    }

    public MainPage checkCurrentUrl() {
        String pageType = simpleContentFilter.getOwnText();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url;
        switch (pageType) {
            case "Inbox":
                url = inboxUrl;
                assertEquals(url, currentUrl);
                break;
            case "Today":
                url = todayUrl;
                assertEquals(url, currentUrl);
                break;
            case "Filters & Labels":
                url = labelsUrl;
                assertEquals(url, currentUrl);
                break;
            default:
                assertEquals("", currentUrl);
        }
        return this;
    }

    public MainPage checkFilterAvailability() {
        simpleContentFilter.shouldNotBe(visible);
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
        calendarLocator.shouldBe(visible);
        return this;
    }

    public MainPage checkUpcomingDate() {
        assertEquals(calendar.getPageDate(), calendar.getCurrentDate());
        return this;
    }
}