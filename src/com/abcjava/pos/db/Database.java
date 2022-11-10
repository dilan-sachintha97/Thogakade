package com.abcjava.pos.db;

import com.abcjava.pos.modal.Customer;
import com.abcjava.pos.modal.Item;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static ArrayList<Item> itemList = new ArrayList<Item>();

    static {
        customerList.add(new Customer("C001","Nimal","Matara",25000));
        customerList.add(new Customer("C002","Sirimal","Colombo",85000));
        customerList.add(new Customer("C003","Nuwam","Matara",45000));
        customerList.add(new Customer("C004","Malith","Galle",50000));
        customerList.add(new Customer("C005","Dilan","Kottawa",70000));
    }
}
