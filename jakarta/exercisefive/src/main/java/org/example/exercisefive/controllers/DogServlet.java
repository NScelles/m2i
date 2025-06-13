package org.example.exercisefive.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercisefive.models.Dog;
import org.example.exercisefive.services.PetService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "dogservlet",value = "/dog/*")
public class DogServlet extends HttpServlet {

    PetService petService;
    @Override
    public void init() throws ServletException {
        petService = new PetService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        switch (pathInfo){
            case "/list" -> showAll(req,resp);
            case "/add" -> showAdd(req,resp);
            case "/edit" -> showEdit(req,resp);
            case "/delete" -> delete(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));
        if (!(Integer.parseInt(req.getParameter("id"))>0))
            petService.createDog(name,breed,birthdate);
        else{
            Dog dog = petService.getDog(Integer.parseInt(req.getParameter("id")));
            dog.setName(name);
            dog.setBreed(breed);
            dog.setBirthDate(birthdate);
            petService.updateDog(dog);
        }
        doGet(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        petService.deleteDog(petService.getDog(id));
        resp.sendRedirect(req.getContextPath()+"/dog/list");
    }

    private void showAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/dogs/add.jsp").forward(req,resp);
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("dog", petService.getDog(id));
        req.getRequestDispatcher("/WEB-INF/dogs/edit.jsp").forward(req,resp);
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogs", petService.getDogs());
        req.getRequestDispatcher("/WEB-INF/dogs/list.jsp").forward(req, resp);
    }

}
