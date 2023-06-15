package com.omcart.core.apractice;

public class Customer {
    private int customerId;
    private String name;
    private String phone;

    public Customer(int id, String name, String phone) {
        //code here
        this.customerId = id;
        this.name = name;
        this.phone = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        //Output should be in given format
        String result="Customer-"+name+" "+"with ID-"+customerId;
        return result;

    }

    @Override
    public boolean equals(Object o) {
        Customer co= (Customer ) o;
        if (this.name.equals(co.name) && this.phone.equals(co.phone)){
            return true;
        } else {
            return false;
        }
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getCustomerId(), getName());
//    }
}

class Tester {
    public static void main(String[] args) {
        Customer c1 = new Customer(105, "Max", "8574637281");
        Customer c2 = new Customer(109, "Nick", "9453281756");
        Customer c3 = new Customer(109, "Nick", "9453281756");
        if (c2.equals(c3)){
            System.out.println("same{}");
        }else {
            System.out.println(c1+ "\n"+ c2);
        }
//        System.out.println(c1);
    }
}
