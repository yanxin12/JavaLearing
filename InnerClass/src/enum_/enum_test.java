// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 17:33
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package enum_;

public enum enum_test {
    SPRING("春天","温暖"),SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");
    private String seasons;
    private String desc;

   private enum_test(String seasons, String desc) {
        this.seasons = seasons;
        this.desc = desc;
    }

    public String getSeasons() {
        return seasons;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasons='" + seasons + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
