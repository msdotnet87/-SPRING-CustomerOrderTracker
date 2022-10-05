package com.msi.panel.entity;

import javax.persistence.*;


@Entity
@Table(name="szczegoly")
public class Order {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idzlecenia;

        private String nazwaFirmy;


        private String szczegoly;

        private String deadline;


        public long getIdzlecenia() {
                return idzlecenia;
        }

        public void setIdzlecenia(long idzlecenia) {
                this.idzlecenia = idzlecenia;
        }

        public String getNazwaFirmy() {
                return nazwaFirmy;
        }

        public void setNazwaFirmy(String nazwaFirmy) {
                this.nazwaFirmy = nazwaFirmy;
        }

        public String getSzczegoly() {
                return szczegoly;
        }

        public void setSzczegoly(String szczegoly) {
                this.szczegoly = szczegoly;
        }

        public String getDeadline() {
                return deadline;
        }

        public void setDeadline(String deadline) {
                this.deadline = deadline;
        }
}
