// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-06 20:04
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package DomainSortTrain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class DomainSortTrain {
    @Test
    public void testDomainSort() {
        Student s1 = new Student("jacky", 12);
        Student s2 = new Student("jac", 12);
        Student s3 = new Student("ja", 13);
        Student s4 = new Student("j", 12);
        //  List<Student> students = Arrays.asList(s1, s2, s3, s4, null);
        //Student[] students = {s1, null,s2, s3, s4};
        Student[] students = {s1, s2, s3, s4};
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.compareTo(o2);
//            }
//        });
        //Arrays.sort(students, Comparator.comparing(Student::getAge).reversed());
        //Arrays.sort(students, Comparator.comparing(Student::getAge).reversed());
        Arrays.sort(students, Comparator.naturalOrder());

        for (Student student : students) {
            System.out.println(student);
        }


    }
}
