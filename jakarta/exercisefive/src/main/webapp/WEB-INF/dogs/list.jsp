<%@ page import="org.example.exercisefive.models.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2025
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="dogs" type="java.util.ArrayList<org.example.exercisefive.models.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/utils/header.jsp"%>

<h1> Dog List </h1>
<% if(dogs.isEmpty()) { %>
    <h3> There is no dog yet try to add one </h3>
<% } else { %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Breed</th>
        <th scope="col">Birthdate</th>
    </tr>
    </thead>
    <tbody>
    <% for (Dog dog:dogs){ %>
    <tr>
        <th scope="row"><%=dog.getId()%></th>
        <td><%=dog.getName()%></td>
        <td><%=dog.getBreed()%></td>
        <td><%= dog.getBirthDate()%></td>
        <td>
            <form action="${pageContext.request.contextPath}/dog/edit" method="get">
                <input type="number" class="form-control d-none" name="id" id="id" value="<%=dog.getId()%>">
                <button class="btn btn-info" type="submit">Edit</button>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/dog/delete" method="get">
                <input type="number" class="form-control d-none" name="id" id="id" value="<%=dog.getId()%>">
                <button class="btn btn-danger" type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<% } %>

<a href="${pageContext.request.contextPath}/dog/add" type="button" class="btn btn-outline-primary"> Add +</a>

<%@include file="/WEB-INF/utils/footer.jsp"%>
