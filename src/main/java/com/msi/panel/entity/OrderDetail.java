package com.msi.panel.entity;

import javax.persistence.*;

@Entity
@Table(name="zamowienie")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int nr_zlecenia;

    private String szczegoly_zlecenia;

    private String Uwagi;

    private int iloscgodzin;

    private int cenagodziny;

    private int lacznacena;

    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNr_zlecenia() {
        return nr_zlecenia;
    }

    public void setNr_zlecenia(int nr_zlecenia) {
        this.nr_zlecenia = nr_zlecenia;
    }

    public String getSzczegoly_zlecenia() {
        return szczegoly_zlecenia;
    }

    public void setSzczegoly_zlecenia(String szczegoly_zlecenia) {
        this.szczegoly_zlecenia = szczegoly_zlecenia;
    }

    public String getUwagi() {
        return Uwagi;
    }

    public void setUwagi(String uwagi) {
        Uwagi = uwagi;
    }

    public int getIloscgodzin() {
        return iloscgodzin;
    }

    public void setIloscgodzin(int iloscgodzin) {
        this.iloscgodzin = iloscgodzin;
    }

    public int getCenagodziny() {
        return cenagodziny;
    }

    public void setCenagodziny(int cenagodziny) {
        this.cenagodziny = cenagodziny;
    }

    public int getLacznacena() {
        return lacznacena;
    }

    public void setLacznacena(int lacznacena) {
        this.lacznacena = lacznacena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
