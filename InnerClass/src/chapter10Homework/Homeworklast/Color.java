// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 19:55
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homeworklast;

public enum  Color implements A_{
    RED(255,0,0),
    GREEN(0,255,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0);

    public int resValue;
    public int greenValue;
    public int blueValue;

    Color() {
    }

    private Color(int resValue, int greenValue, int blueValue) {
        this.resValue = resValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public int getResValue() {
        return resValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    @Override
    public String toString() {
        return "Color{" +
                "resValue=" + resValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                '}';
    }

    @Override
    public  void show(String a) {
        switch (a){
            case "red":
                System.out.println(RED);
                break;
            case "green":
                System.out.println(GREEN);
                break;
            default:
                System.out.println("hiahiah");
        }

    }
}
