package com.Rick_Cavallaro.Week_08;

import java.util.ArrayList;
import java.util.List;

class Contact {
    private String name;
    private String eMail;

    public Contact(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("eMail: " + eMail);
    }
}

class BusinessContact extends Contact {
    private String phoneNumber;

    public BusinessContact(String name, String eMail, String phoneNumber) {
        super(name, eMail);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Phone Number: " + phoneNumber);
    }
}

class AddressBook {
    List<Contact> contacts = new ArrayList<>();

    public void add(Contact c) {
        contacts.add(c);
    }

    public void display() {
        for (Contact c: contacts) {
            c.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Contact rick = new Contact("Rick", "Rick@cscc.edu");
        BusinessContact holly = new BusinessContact("Holly", "Holly@eMail.com", "614 456-7890");
        AddressBook contacts = new AddressBook();
        contacts.add(rick);
        contacts.add(holly);
        contacts.display();
    }
}

