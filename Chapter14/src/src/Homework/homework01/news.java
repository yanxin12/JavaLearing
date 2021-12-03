// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-26 23:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.Homework.homework01;

public class news {
    private String title;
    private  String content;

    public news(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  title;
    }

}
