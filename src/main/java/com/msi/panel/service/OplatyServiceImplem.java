package com.msi.panel.service;

import com.msi.panel.entity.Customer;
import com.msi.panel.entity.Oplaty;
import com.msi.panel.repository.OplatyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OplatyServiceImplem {

    @Autowired
    OplatyRepository oplatyRepository;



    public Oplaty createOplaty(int miesiac, int rok, int gaz, int prad, int internet, int rata, int inne ){
        Oplaty oplaty = new Oplaty();
        oplaty.setGaz(gaz);
        oplaty.setMiesiac(miesiac);
        oplaty.setRok(rok);
        oplaty.setInternet(internet);
        oplaty.setPrad(prad);
        oplaty.setRata(rata);
        oplaty.setInne(inne);

        return oplaty;
    }

    public void saveOplaty(Oplaty oplaty){
        oplatyRepository.save(oplaty);
    }
    public List<Oplaty> showOplaty (){
       return oplatyRepository.showOplaty();
    }

}
