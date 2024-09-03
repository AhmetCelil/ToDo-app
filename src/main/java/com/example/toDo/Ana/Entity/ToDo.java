package com.example.toDo.Ana.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Long id;

    private String yapilacakIs;
    private String Sure;

    @Column(name = "Date")
    private Date tarih;
}
