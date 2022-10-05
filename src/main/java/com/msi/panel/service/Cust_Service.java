package com.msi.panel.service;

import com.msi.panel.entity.Customer;

import java.util.List;

public interface Cust_Service {

    public void savefullCustomer(String adres, String nazwa, int nip);

    public void saveCustCust(Customer customer);


    /*
    Metody operujące na modelu Customer
     */
    public List<Customer> showAllCustomer();
    public List<Customer> showCustomerbynip(int nip);
    public List<Customer> showCustomerbyname(String name);



}
