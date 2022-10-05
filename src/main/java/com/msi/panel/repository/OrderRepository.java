package com.msi.panel.repository;

import com.msi.panel.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT u FROM Order u")
    public List<Order> showallOrders();

    @Query("SELECT u FROM Order u WHERE u.nazwaFirmy=:nazwa_firmy")
    public List<Order> showByCustomer(String nazwa_firmy);

    @Query("SELECT u FROM Order u WHERE u.idzlecenia=:idzlecenia")
    public Order showById(Long idzlecenia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Order n  set n.nazwaFirmy =:custName, n.szczegoly =:details, n.deadline =:deadline WHERE n.idzlecenia=:idzlecenia")
    public void updCustomerwithId(@Param("idzlecenia") Long idzlecenia,
                                  @Param("custName") String custName,
                                  @Param("details") String details,
                                  @Param("deadline") String deadline
    );

}
