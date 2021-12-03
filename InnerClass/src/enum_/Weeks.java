// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 18:29
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package enum_;

public enum Weeks {
    MONDAY("monday","周一"),TUESDAY("tuesday","周二"),
    WEDSDAY("wedsday","周三");

    private String week;
    private String cweek;

    private Weeks(String week, String cweek) {
        this.week = week;
        this.cweek = cweek;
    }

    public String getWeek() {
        return week;
    }

    public String getCweek() {
        return cweek;
    }

    @Override
    public String toString() {
        return "Weeks{" +
                "week='" + week + '\'' +
                ", cweek='" + cweek + '\'' +
                '}';
    }
}
