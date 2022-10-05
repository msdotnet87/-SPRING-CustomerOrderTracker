package com.msi.panel.entity;

import javax.persistence.*;

@Entity
@Table(name = "Oplaty")
public class Oplaty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int miesiac;

    private int rok;

    private int gaz;

    private int prad;

    private int internet;

    private int rata;

    private int inne;

    public int getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGaz() {
        return gaz;
    }

    public void setGaz(int gaz) {
        this.gaz = gaz;
    }

    public int getPrad() {
        return prad;
    }

    public void setPrad(int prad) {
        this.prad = prad;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getRata() {
        return rata;
    }

    public void setRata(int rata) {
        this.rata = rata;
    }

    public int getInne() {
        return inne;
    }

    public void setInne(int inne) {
        this.inne = inne;
    }
}
