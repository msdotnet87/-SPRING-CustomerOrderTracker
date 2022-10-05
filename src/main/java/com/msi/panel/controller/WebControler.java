package com.msi.panel.controller;


import com.msi.panel.entity.Customer;
import com.msi.panel.entity.Oplaty;
import com.msi.panel.entity.Order;
import com.msi.panel.entity.User;
import com.msi.panel.service.Cust_Service_Implem;
import com.msi.panel.service.OplatyServiceImplem;
import com.msi.panel.service.Order_Service_Implem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Controller
public class WebControler {

    Cust_Service_Implem cust_service_implem;
    Order_Service_Implem order_service_implem;

    @Autowired
    OplatyServiceImplem oplatyServiceImplem;

    @Autowired
    public WebControler(Cust_Service_Implem cust_service_implem, Order_Service_Implem order_service_implem)
    {
        this.order_service_implem = order_service_implem;
        this.cust_service_implem = cust_service_implem;
    }

    /*
    ****************************************
     */


    @RequestMapping(value = "/user_panel", method = RequestMethod.GET)
    public ModelAndView userPanel(ModelAndView modelAndView){
        modelAndView.setViewName("user_panel");
        return modelAndView;
    }

    @RequestMapping(value = "/admin_panel", method = RequestMethod.GET)
    public ModelAndView admin_panel(ModelAndView modelAndView){
        modelAndView.setViewName("admin_panel");
        return modelAndView;
    }


    /*
    Customer - show all view
     */
    @RequestMapping(value = "/api/show_custmer")
    public ModelAndView show_customer(Model model, ModelAndView modelAndView){
        List<Customer> allCustomers = cust_service_implem.showAllCustomer();
        model.addAttribute("allCustomer", allCustomers);
        modelAndView.setViewName("show_customer");
        return modelAndView;
    }


    /*
Customer - add GET/POST
 */
    @GetMapping (value = "/add_customer")
    public ModelAndView addCustomer(ModelAndView modelAndView){
        modelAndView.setViewName("add_customer");
        return modelAndView;
    }

    @RequestMapping(value = "/add_customer", method = RequestMethod.POST)
    public ModelAndView addCustomerPost(ModelAndView modelAndView, @RequestParam("nip") int nip,
                                    @RequestParam("name") String nazwa,
                                    @RequestParam ("adress") String adres){
        cust_service_implem.saveCustCust(cust_service_implem.CreateCustomer(nip, nazwa, adres));
        //return new ModelAndView("../add_Customer");
        modelAndView.setViewName("redirect:/api/show_custmer");
    return modelAndView;

    }


   /*
   Edit Customer
    */

    @GetMapping (value = "/editCustomer")
    public ModelAndView editCustomer(@RequestParam ("id") Long id, Model model, ModelAndView modelAndView){
        modelAndView.setViewName("editCustomer");
        Customer customer_id = cust_service_implem.geCustomerbyId(id);
        model.addAttribute("customer", customer_id);

        System.out.println(customer_id);
        return modelAndView;
    }


    @RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
    public ModelAndView editCustomerPost(ModelAndView modelAndView,
                                         @RequestParam("Id") Long id,
                                         @RequestParam("nip") int nip,
                                        @RequestParam("name") String nazwa,
                                        @RequestParam ("adress") String adres){
        cust_service_implem.updCustomerwithId(id, adres, nazwa, nip);
        System.out.println(id+ adres+ nip+ nazwa);
        modelAndView.setViewName("redirect:/api/show_custmer");
        return modelAndView;

    }



/*
Delete customer
 */
    @GetMapping (value = "/delCustomer")
    public ModelAndView delCustomer(@RequestParam ("id") Long id, Model model, ModelAndView modelAndView){
        cust_service_implem.delCustomerbyId(id);
        modelAndView.setViewName("redirect:/api/show_custmer");
        return modelAndView;
    }

// *******************************************************ORDERS ******************************************************

    /*
    ADD ORDER
     */
@GetMapping (value = "/add_Order")
public ModelAndView add_Order(Model model, ModelAndView modelAndView){
        List<Customer> customer = cust_service_implem.showAllCustomer();
        model.addAttribute("customer", customer);
    modelAndView.setViewName("add_Order");
    return modelAndView;
}


    @RequestMapping(value = "/add_Order", method = RequestMethod.POST)
    public ModelAndView add_OrderPost(ModelAndView modelAndView, @RequestParam("customer") String customer,
                                        @RequestParam("details") String details,
                                        @RequestParam ("dll") String dll){
        order_service_implem.createNewOrder(customer, details, dll);
        modelAndView.setViewName("redirect:/api/show_orders");
        return modelAndView;

    }

    /*
    Order - show all view
     */
    @RequestMapping(value = "/api/show_orders")
    public ModelAndView show_orders(Model model, ModelAndView modelAndView){
        List<Order> allOrders = order_service_implem.showAllOrders();
        model.addAttribute("allOrders", allOrders);
        modelAndView.setViewName("show_orders");
        return modelAndView;
    }

  /*
    Order - Edit Order
     */
  @GetMapping (value = "/editOrder")
  public ModelAndView editOrderGet(@RequestParam ("id") Long id, Model model, ModelAndView modelAndView){
      modelAndView.setViewName("editOrder");
      Order order = order_service_implem.showOrderbyId(id);
      model.addAttribute("order", order);

      return modelAndView;
  }


    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    public ModelAndView editOrderPost(ModelAndView modelAndView,
                                         @RequestParam("Id") Long idzlecenia,
                                         @RequestParam("custName") String custName,
                                         @RequestParam("details") String details,
                                         @RequestParam ("dll") String dll){
        order_service_implem.updateOrderbyID(idzlecenia, custName, details, dll);
        modelAndView.setViewName("redirect:/api/show_orders");
        return modelAndView;

    }

/**********************************************ORDER DETAILS***********************************/

 @RequestMapping(value = "/api/orderdet")
 public ModelAndView orderdet(Model model, ModelAndView modelAndView){
 List<Order> allOrders = order_service_implem.showAllOrders();
 model.addAttribute("allOrders", allOrders);
 modelAndView.setViewName("orderdet");
 return modelAndView;
 }




/*

OPLATYYY

 */

    @RequestMapping(value = "/api/oplaty")
    public ModelAndView oplaty(Model model, ModelAndView modelAndView){
        List<Oplaty> oplatyList = oplatyServiceImplem.showOplaty();
        model.addAttribute("oplaty", oplatyList);
        modelAndView.setViewName("oplaty");
        return modelAndView;
    }

    @RequestMapping(value = "/Tracker")
    public ModelAndView Tracker(Model model, ModelAndView modelAndView){
        List<Oplaty> oplatyList = oplatyServiceImplem.showOplaty();
        model.addAttribute("oplaty", oplatyList);
        modelAndView.setViewName("Tracker");
        return modelAndView;
    }

    @GetMapping (value = "/DodajOplaty")
    public ModelAndView DodajOplaty(ModelAndView modelAndView){
        modelAndView.setViewName("DodajOplaty");
        return modelAndView;
    }


    @RequestMapping(value = "/DodajOplaty", method = RequestMethod.POST)
    public ModelAndView DodajOplatyPost(ModelAndView modelAndView,
                                        @RequestParam("Miesiac") int miesiac,
                                        @RequestParam("Rok") int rok,
                                        @RequestParam("Prad") int prad,
                                        @RequestParam("Gaz") int gaz,
                                        @RequestParam("Rata") int rata,
                                        @RequestParam("Internet") int internet,
                                        @RequestParam("Inne") int inne){
       Oplaty noweOplaty = oplatyServiceImplem.createOplaty(miesiac, rok, gaz, prad, internet, rata, inne);
       oplatyServiceImplem.saveOplaty(noweOplaty);
        modelAndView.setViewName("redirect:/api/oplaty");
        return modelAndView;

    }


    /*
Site Login
 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
