// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-26 14:34
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.Collection;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"all"})
public class Collection_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Student("小王",21,
                "student","computer"));
        list.add(new Student("小李",22,
                "student","computer"));
        list.add(new Teacher("小宋",21,
                "teacher","computer"));
        System.out.println(list);


    }

}
