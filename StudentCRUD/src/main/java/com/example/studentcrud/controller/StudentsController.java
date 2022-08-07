package com.example.studentcrud.controller;

import com.example.studentcrud.model.Groups;
import com.example.studentcrud.model.Students;
import com.example.studentcrud.repository.IStudentRepJPA;
import com.example.studentcrud.repository.IStudentRepJPQL;
import com.example.studentcrud.repository.StudentRepositoryJDBCImpl;
import com.example.studentcrud.repository.StudentRepositoryJPQLImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class StudentsController {
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }

    private final StudentRepositoryJDBCImpl repository = new StudentRepositoryJDBCImpl();
    @GetMapping("/students")
    public List<Students> getAllStudents() throws SQLException, IOException {
        return  repository.findAll();
    }
    @GetMapping("/creatingStudent")
    public List<Students> getAllStudentsAfterCreating() throws SQLException, IOException {
        repository.save();
        return  repository.findAll();
    }
    @GetMapping("/DeletingStudent/{id}")
    public List<Students> getAllStudentsAfterDeleting(@PathVariable Long id) throws SQLException, IOException {
        repository.deleteById(id);
        return  repository.findAll();
    }
    @GetMapping("/UpdatingStudent/{id}/{name}")
    public List<Students> getAllStudentsAfterUpdating(@PathVariable Long id, @PathVariable String name) throws SQLException, IOException {
        repository.updateNameById(id, name);
        return  repository.findAll();
    }
    @GetMapping("/students/{name}")
    public List<Students> getStudentByName(@PathVariable String name) throws SQLException, IOException {
        return repository.findWhereNameLike(name);
    }
    @Autowired
    private IStudentRepJPA rep;
    @GetMapping("/studentsWithJPA")
    public List<Students> getAllStudentsJPA() throws SQLException, IOException {
        return  rep.findAll();
    }

    private StudentRepositoryJPQLImpl repo;
    @GetMapping("/studentsWithJPQL")
    public List<Students> getStudentsById() throws SQLException, IOException {
        return  repo.findAll();
    }
    @GetMapping("/studentsWithJPQL/{id}")
    public List<Students> DeleteStudentsById(@PathVariable Long id) throws SQLException, IOException {
          repo.deleteById(id);
          return repo.findAll();
    }
//    @Autowired
//    @GetMapping("/CreatingStudentsWithJPA")
//    public Students getAllStudentsAfterCreatingJPA() throws SQLException, IOException {
//        return  rep.save(new Students(1908732598L, "testSaving", new Groups(3L, "G3", new Date())));
//    }
}
