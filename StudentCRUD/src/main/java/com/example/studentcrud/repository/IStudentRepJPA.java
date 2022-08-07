package com.example.studentcrud.repository;

import com.example.studentcrud.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepJPA extends JpaRepository<Students, Long> {
}
