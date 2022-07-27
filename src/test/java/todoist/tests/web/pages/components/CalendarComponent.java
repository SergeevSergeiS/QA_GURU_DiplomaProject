package todoist.tests.web.pages.components;

import com.codeborne.selenide.SelenideElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public SelenideElement
            monthYear = $(".upcoming_view__calendar__controls__picker"),
            dayMonth = $(".calendar__day").$(".upcoming_view__day_cell__weekday"),
            dateMonth = $(".calendar__day").$(".upcoming_view__day_cell__date__number");
    Locale locale = Locale.US;
    SimpleDateFormat formatter = new SimpleDateFormat("MMMM y E d", locale);

    public String getPageDate() {
        String dateCheck = String.format("%s %s %s",
                monthYear.innerText(), dayMonth.innerText(), dateMonth.innerText());
        Date date = null;
        try {
            date = formatter.parse(dateCheck);
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        return formatter.format(date);
    }

    public String getCurrentDate() {
        Date dateNow = new Date();
        return formatter.format(dateNow);
    }
}
