package org.example.exercices;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private int idClass;
    private String degreeDate;

    public Student() {

    }

    public Student(int id, String firstname, String lastname, int idClass, String degreeDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.idClass = idClass;
        this.degreeDate = degreeDate;
    }

    @Override
    public String toString() {
        return  id + ")" + firstname + lastname + "Classe: " +  idClass + "a obtenu le diplome le " + degreeDate ;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getDegreeDate() {
        return degreeDate;
    }

    public void setDegreeDate(String degreeDate) {
        this.degreeDate = degreeDate;
    }
}
