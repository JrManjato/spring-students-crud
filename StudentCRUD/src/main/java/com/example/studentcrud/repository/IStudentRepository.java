package com.example.studentcrud.repository;


import com.example.studentcrud.model.Students;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Students> findAll() throws IOException, SQLException;

    void save();

    void deleteById(Long id);

    void updateNameById(Long id, String newName);

    List<Students>  findWhereNameLike(String query);
    // Select * from students where name like '%query%'
}
//implémentez cette interface avec une classe concrète avec JDBC (faites enc sorte de
// convertir le resultset en list)
// Devoir de recherche :
// Proposez une autre implémentation avec JPQL (Java Persistence Query Language)
// *** voir anotation @Query

