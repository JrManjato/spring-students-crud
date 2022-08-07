package com.example.studentcrud.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 3)
    private String name;
    @Column
    private Date creation_date;

    public Groups(Long id_group, String group_name, Date creation_date) {
        this.id = id_group;
        this.name = group_name;
        this.creation_date = creation_date;
    }
}
