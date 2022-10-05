package com.msi.panel.service;

import com.msi.panel.entity.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    public List<Order> showAllOrders();

    public List<Order> showOrdersByCustomer(String customer);


}
