package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh29StreamAPI;

import java.util.ArrayList;

public class StreamDemo3 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> npe = new ArrayList<>();
        npe.add(new NamePhoneEmail("Mike", "555", "e-mail_1"));
        npe.add(new NamePhoneEmail("Larry", "567", "e-mail_2"));
        npe.add(new NamePhoneEmail("Donna", "777", "e-mail_3"));
        npe.add(new NamePhoneEmail("Orest", "888", "e-mail_4"));
        npe.add(new NamePhoneEmail("Orest", "917", "e-mail_5"));

        System.out.println("Initial elements from list: ");
        npe.stream()
                .forEach((a)-> System.out.println(a.name + " " + a.phonenum + " " + a.email));

        System.out.println("\nJust name and phone: ");
        npe.stream()
                .map((a)->new NamePhone(a.name, a.phonenum))
                .forEach((a)-> System.out.println(a.name + " " + a.phonenum));

        System.out.println();
        npe.stream()
                .filter((a)->a.name =="Orest")
                .map((a)->new NamePhone(a.name, a.phonenum))
                .forEach((a)-> System.out.println(a.name + " " + a.phonenum));
    }
}

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail (String n, String p, String e) {
        this.name = n;
        this.phonenum = p;
        this.email = e;
    }
}

class NamePhone {
    String name;
    String phonenum;

    NamePhone (String n, String p) {
        this.name = n;
        this.phonenum = p;
    }
}
