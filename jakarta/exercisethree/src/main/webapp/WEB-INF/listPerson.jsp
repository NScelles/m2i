<%@ page import="com.example.exercisethree.models.Person" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2025
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="persons" type="java.util.ArrayList<com.example.exercisethree.models.Person>" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des personnes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
<h1>Liste :</h1>
<table class="table">
  <thead>
  <tr>
    <th scope="col">First</th>
    <th scope="col">Last</th>
    <th scope="col">Age</th>
  </tr>
  </thead>
  <tbody>
  <% for (Person person:persons){ %>
  <tr>
    <td><%= person.getFirstName() %></td>
    <td><%= person.getLastName() %></td>
    <td><%= "Age: "+ person.getAge() %></td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
