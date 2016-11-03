package com.Rick_Cavallaro.Test_02;

class Building {
    String address;

    Building(String address) {
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("Address:" + address);
    }
}

class House extends Building {
    private int residentCount;

    House(String address, Integer residentCount) {
        super(address);
        this.residentCount = residentCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Address:" + super.address);
        System.out.println("Residents:" + this.residentCount);
    }
}
public class Main {
    public static void main(String[] args) {
        Building building = new Building("123 Main St.");
        House house = new House("456 High St.",4);
        building.displayInfo();
        house.displayInfo();
    }
}
