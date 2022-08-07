package com.example.studentcrud.repository;

import com.example.studentcrud.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepJPQL extends JpaRepository<Students, Long> {
  @Query("select s from Students s")
  List<Students> findAll();
  @Modifying
  @Query("DELETE FROM Students s where s.id = :id")
  void deleteById(@Param("id") Long id);
}
