package todoist.helpers.web;

public enum PartialLinks {
    LOGIN("/auth/login"),
    REDIRECTEDLOGIN("auth/login?success_page=%2Fapp%2Ftoday"),
    INBOXFILTER("app/project/"),
    TODAYFILTER("app/today"),
    LABELSFILTER("app/filters-labels");
    private String link;

    PartialLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}