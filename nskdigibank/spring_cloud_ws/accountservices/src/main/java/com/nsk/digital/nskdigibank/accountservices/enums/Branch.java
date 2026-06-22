package com.nsk.digital.nskdigibank.accountservices.enums;

public enum Branch{


    TALUPULA("8-41, Main Bazar, Talupula"),
    ANANTAPUR("10-22, Gandhi Road, Anantapur"),
    KADAPA("5-67, Market Street, Kadapa");

    private final String address;
    Branch(String address){
        this.address=address;
    }

     public String getAddress() {
        return address;
     }
}
