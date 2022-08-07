package com.example.studentcrud.repository;

import com.example.studentcrud.jdbc.DBConnection;
import com.example.studentcrud.model.Groups;
import com.example.studentcrud.model.Students;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentRepositoryJDBCImpl implements IStudentRepository{

    @Override
    public  List<Students> findAll() throws IOException, SQLException {
        List<Students> StudentList = new ArrayList<>();
        ResultSet res = DBConnection.DBStatement().executeQuery("SELECT students.id, students.name, groups.id, groups.name, creation_date FROM students INNER JOIN groups ON groups.id = students.groups_id;");
        while (res.next()){
            Long id_student = res.getLong("id");
            String name = res.getString("name");
            Long id_group = res.getLong("id");
            String group_name = res.getString("name");
            Date creation_date = res.getDate("creation_date");

            StudentList.add(new Students(id_student, name, new Groups(id_group, group_name, creation_date)));
        }
        return StudentList;
    }

    @Override
    public void save() {
        int id = 0;
        String name = null;
        try {
            Scanner prompt = new Scanner(System.in);
            System.out.println("Entrez le groupe de l'étudiant: ");
            id = prompt.nextInt();

            Scanner prompts = new Scanner(System.in);
            System.out.println("Entrez le nom de l'étudiant: ");
            name = prompts.nextLine();

            StringBuilder temp = new StringBuilder();
            temp.append("'").append(name).append("'");

            DBConnection.DBStatement().executeUpdate("INSERT INTO students (name, groups_id) VALUES (" + temp + "," + id +")");
            System.out.println("L'étudiant a été ajouté");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            DBConnection.DBStatement().executeUpdate("DELETE FROM students WHERE id="+id);

            System.out.println("L'étudiant a été supprimé !");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateNameById(Long id, String newName) {
        try {
            StringBuilder temp = new StringBuilder();
            temp.append("'").append(newName).append("'");

            DBConnection.DBStatement().executeUpdate("UPDATE students SET name ="+temp+" WHERE id="+id);
            System.out.println("Mise à jour effectuée");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public  List<Students> findWhereNameLike(String name) {
        List<Students> StudentList = new ArrayList<>();
        try {
            ResultSet res = DBConnection
                    .DBStatement()
                    .executeQuery("SELECT students.id, students.name, groups.id, groups.name, creation_date" +
                    " FROM students INNER JOIN groups ON groups.id = students.groups_id WHERE students.name ilike '%"+name+"%';");
            while (res.next()){
                Long id_student = res.getLong("id");
                String students_name = res.getString("name");
                Long id_group = res.getLong("id");
                String group_name = res.getString("name");
                Date creation_date = res.getDate("creation_date");

                StudentList.add(new Students(id_student, students_name, new Groups(id_group, group_name, creation_date)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return StudentList;
    }
}
