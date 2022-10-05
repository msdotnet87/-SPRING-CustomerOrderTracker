package com.msi.panel.service;

import com.msi.panel.entity.Customer;
import com.msi.panel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cust_Service_Implem  implements Cust_Service{

    @Autowired
    private CustomerRepository customerRepository;






    @Override
    public void savefullCustomer(String adres, String nazwa, int nip) {
        Customer customer3 = new Customer();
        customer3.setAdres(adres);
        customer3.setNazwaFirmy(nazwa);
        customer3.setNip(nip);
        customerRepository.save(customer3);
    }

    @Override
    public void saveCustCust(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> showAllCustomer() {
        return customerRepository.showAllCustomer();
    }

    @Override
    public List<Customer> showCustomerbynip(int nip) {
        return customerRepository.showCustomerbynip(nip);
    }

    @Override
    public List<Customer> showCustomerbyname(String name) {
        return customerRepository.showCustomerbyname(name);
    }

    public Customer CreateCustomer(int nip, String name, String adress){
        Customer cust = new Customer();
        cust.setNip(nip);
        cust.setAdres(adress);
        cust.setNazwaFirmy(name);
        return cust;
    }

    public Customer geCustomerbyId (Long id){
        return customerRepository.showCustomerbyId(id);
    }

    public void updCustomerwithId(Long id, String adres, String nazwa, int nip){
        customerRepository.updCustomerwithId(id, nip, adres, nazwa);
    }

    public void updateCustomer(Long id, String adres, String nazwa, int nip){
        Customer newcust = new Customer();
        newcust.setNazwaFirmy(nazwa);
        newcust.setId(id);
        newcust.setNip(nip);
        newcust.setAdres(adres);
        customerRepository.save(newcust);
    }

    public void delCustomerbyId(Long id){
        customerRepository.deleteCustomerbyId(id);
    }
}
