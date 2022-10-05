package com.msi.panel.repository;

import com.msi.panel.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("SELECT u FROM Customer u")
    public List<Customer> showAllCustomer();

    @Query("SELECT u FROM Customer u WHERE u.nip=:nip")
    public List<Customer> showCustomerbynip(@Param("nip")int nip);

    @Query("SELECT u FROM Customer u WHERE u.id=:id")
    public Customer showCustomerbyId(@Param("id")Long id);

    @Query("SELECT u FROM Customer u WHERE u.nazwaFirmy=:nazwa")
    public List<Customer> showCustomerbyname(@Param("nazwa")String nazwa);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer n  set n.nazwaFirmy =:nazwa1, n.adres =:adres1, n.nip =:nip1 WHERE n.id=:id")
    public void updCustomerwithId(@Param("id") Long id1,
                                               @Param("nip1") int nip,
                                               @Param("adres1") String adres1,
                                               @Param("nazwa1") String nazwa1
                                    );


@Transactional
    @Modifying
    @Query(value = "DELETE Customer d WHERE d.id=:id")
    public void deleteCustomerbyId(@Param("id") Long id);



    //public List<Customer> findByQuantityBetween(int minquantity, int maxquantity);
    //findByQuantityGreaterThenEqualOrderBy


}
