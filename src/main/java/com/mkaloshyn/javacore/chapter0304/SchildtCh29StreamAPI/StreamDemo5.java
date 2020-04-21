package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh29StreamAPI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> npe = new ArrayList<>();
        npe.add(new NamePhoneEmail("Mike", "555", "e-mail_1"));
        npe.add(new NamePhoneEmail("Larry", "567", "e-mail_2"));
        npe.add(new NamePhoneEmail("Donna", "777", "e-mail_3"));
        npe.add(new NamePhoneEmail("Orest", "888", "e-mail_4"));
        npe.add(new NamePhoneEmail("Orest", "917", "e-mail_5"));

        System.out.println("Initial elements from list: ");
        npe.stream()
                .forEach((a) -> System.out.println(a.name + " " + a.phonenum + " " + a.email));

        List<NamePhoneM> listNameAndPhone = npe.stream()
                .map((a) -> new NamePhoneM(a.name, a.phonenum))
                .collect(Collectors.toList());

        System.out.println(listNameAndPhone);

        LinkedList<NamePhoneM> llNamePhone = npe.stream()
                .map((a) -> new NamePhoneM(a.name, a.phonenum))
                .collect(() -> new LinkedList<>(),
                        (list, element) -> list.add(element),
                        (list1, list2) -> list1.addAll(list2));

       /* LinkedList<NamePhoneM> llNamePhoneSame = npe.stream()
                .map((a) -> new NamePhoneM(a.name, a.phonenum))
                .collect(LinkedList::new,
                        LinkedList::add,
                        LinkedList::addAll); //the same realization but with method reference*/
    }
}

class NamePhoneEmailM {
    String name;
    String phonenum;
    String email;

    NamePhoneEmailM(String n, String p, String e) {
        this.name = n;
        this.phonenum = p;
        this.email = e;
    }
}

class NamePhoneM {
    String name;
    String phonenum;

    NamePhoneM(String n, String p) {
        this.name = n;
        this.phonenum = p;
    }

    @Override
    public String toString() {
        return "NamePhoneM{" +
                "name='" + name + '\'' +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}
