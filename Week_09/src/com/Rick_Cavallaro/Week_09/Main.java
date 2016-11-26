package com.Rick_Cavallaro.Week_09;

import com.sun.scenario.effect.impl.prism.ps.PPSOneSamplerPeer;

import java.util.ArrayList;
import java.util.List;

abstract class Contact {
    private String name;

    Contact(String name) {
        this.name = name;
    }

    abstract public void contact();
}

class EmailContact extends Contact {
    private String email;

    EmailContact(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void contact() {
        System.out.println("Emailing " + email);
    }
}

class PhoneContact extends Contact {
    private String phoneNumber;

    PhoneContact(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void contact() {
        System.out.println("Calling " + phoneNumber);
    }
}

/*
 * Created by Rick on 11/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        PhoneContact rick = new PhoneContact("Rick", "614 456-7890");
        EmailContact holly = new EmailContact("Holly", "Holly@email.com");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(rick);
        contacts.add(holly);

        for (Contact c: contacts) {
            c.contact();
        }
    }
}
