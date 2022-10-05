package com.msi.panel.controller;


import com.msi.panel.entity.Customer;
import com.msi.panel.repository.CustomerRepository;
import com.msi.panel.service.Cust_Service_Implem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MainController {


@Autowired
private CustomerRepository custCrud;

@Autowired
Cust_Service_Implem cust_service_implem;



    /*
Dziala z serwisami
     */
@RequestMapping("/")
    public String index(HttpServletResponse response){
    Customer customer2 = new Customer();
    customer2.setAdres("Test22");
    customer2.setNazwaFirmy("Test22");
    customer2.setNip(121212);
    cust_service_implem.saveCustCust(customer2);
    return "Hello Worlds";
}


    //Wyswietl Customera o nazwie test
    @RequestMapping("/show")
    public List<Customer> index2(HttpServletResponse response){
        return cust_service_implem.showCustomerbyname("test");
    }



//    @RequestMapping("/Paging")
//    public List<Customer> index3(@RequestParam(defaultValue = "0") String page){
//       int currPage = Integer.parseInt(page);
//
//
//        return null;
//
//    }

}
