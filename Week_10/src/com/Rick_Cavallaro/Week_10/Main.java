package com.Rick_Cavallaro.Week_10;

import com.sun.jndi.cosnaming.IiopUrl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

class Contact implements Comparable<Contact> {
    public String name;
    public String email;

    Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void display() {
        System.out.println("Name: " + name + ", Email: " + email);
    }

    @Override
    public int compareTo(Contact o) {
        if (!name.equals(o.name)) {
            return name.compareTo(o.name);
        } else {
            return email.compareTo(o.email);
        }
    }
}

class AddressBook implements Iterable<Contact> {
    private List<Contact> contacts = new ArrayList<>();

    public void add(Contact o){
        contacts.add(o);
    }

    @Override
    public Iterator<Contact> iterator(){
        return contacts.iterator();
    }

    public void sort() {
        Collections.sort(contacts);
    }
}


/*
 * Created by Rick on 11/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        Contact bob = new Contact("bob", "bob@bob.com");
        Contact arthur = new Contact("arthur", "arthur@arthur.com");
        Contact arthur2 = new Contact("arthur2", "aarthur@arthur.com");

        AddressBook addressBook = new AddressBook();
        addressBook.add(bob);
        addressBook.add(arthur);
        addressBook.add(arthur2);

        addressBook.sort();

        for (Contact c: addressBook){
            c.display();
        }

//        List <Contact> contacts = new ArrayList<>();
//        contacts.add(bob);
//        contacts.add(arthut);

        //Collections.sort(contacts);

        //for(Contact contact: contacts){
            //contact.display();
        //}

    }
}
