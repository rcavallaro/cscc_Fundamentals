package com.Rick_Cavallaro.Week_07;
/*
 * Created by Rick on 10/11/2016.
 */
class Contact {
    protected String name;
    protected String email;

    Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void display(){
        System.out.println("Name: " + name + ", Email: " + email);
    }
}

class BusinessContact extends Contact{
    protected String phoneNumber;

    BusinessContact(String name, String email, String phoneNumber) {
        super(name, email);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Phone Number: " + phoneNumber);
    }
}
public class Main {
    public static void main(String[] args){
        Contact rick = new Contact("Rick", "Rick.Cavallaro@cscc.edu");
        rick.display();

        BusinessContact holly = new BusinessContact("Holly", "Holly@cscc.edu", "614 456-7890");
        holly.display();
    }
}
