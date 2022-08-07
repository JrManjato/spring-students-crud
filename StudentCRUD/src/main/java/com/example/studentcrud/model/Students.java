package com.example.studentcrud.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 200)
    private String name;

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups group;

    public Students(Long id, String name, Groups group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }
}

