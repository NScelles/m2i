package org.example.jakarta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myservlet",value = "/my-servlet")
public class MyServlet extends HttpServlet {
    private String firstName;

    public void init(){
        firstName = "firstName";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//
//        out.println("<title>Servlet MyServlet</title>");
//        out.println("</head>");
//
//        out.println("<body>");
//        out.println("<h1>Servlet MyServlet</h1>");
//
//        out.println("</body>");
//        out.println("</html>");
        getServletContext().getRequestDispatcher("/maPage.jsp").forward(req,resp);
    }
}
