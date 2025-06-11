package com.example.exercisethree.controllers;

import com.example.exercisethree.models.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personServlet", value = "/person-servlet")
public class PersonServlet extends HttpServlet {
    List<Person> persons = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        persons.add(new Person("Nelou","Coucou", 9));
        persons.add(new Person("Salimou","Filou", 8));
        persons.add(new Person("Nou","Nounou", 7));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("persons",persons);
        req.getRequestDispatcher("/WEB-INF/listPerson.jsp").forward(req,resp);
    }

}
