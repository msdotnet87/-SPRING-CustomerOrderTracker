package com.msi.panel.repository;

import com.msi.panel.entity.Customer;
import com.msi.panel.entity.Oplaty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OplatyRepository extends CrudRepository <Oplaty, Long>{

    @Query("SELECT u FROM Oplaty u")
    public List<Oplaty> showOplaty();



}
