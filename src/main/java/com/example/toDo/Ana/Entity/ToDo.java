package com.example.toDo.Ana.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String yapilacakIs;
    private String Sure;
    private String tarih;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYapilacakIs() {
        return yapilacakIs;
    }

    public void setYapilacakIs(String yapilacakIs) {
        this.yapilacakIs = yapilacakIs;
    }

    public String getSure() {
        return Sure;
    }

    public void setSure(String sure) {
         Sure = sure;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
