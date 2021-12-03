// -*- coding: utf-8 -*- 
/**
 * Project: Collection
 * Creator: yanking
 * Create time: 2021-09-08 17:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package ClassWork.ClassWork01;

public class Staff {
    private String name;
    private String job;
    private  Double saraly;

    public Staff(String name, String job, Double saraly) {
        this.name = name;
        this.job = job;
        this.saraly = saraly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSaraly() {
        return saraly;
    }

    public void setSaraly(Double saraly) {
        this.saraly = saraly;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", saraly=" + saraly +
                '}';
    }
}
