<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2025
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/utils/header.jsp"%>

<form action="${pageContext.request.contextPath}/dog/list" method="post">
    <input type="number" class="d-none" value="0" name="id">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" name="name" id="name" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text"></div>
    </div>
    <div class="mb-3">
        <label for="breed" class="form-label">Breed</label>
        <input type="text" class="form-control" name="breed" id="breed">
    </div>
    <div class="mb-3 form-check">
        <label class="form-date-label" for="birthdate">Birthdate</label>
        <input type="date" class="form-date-input" name="birthdate" id="birthdate">
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>

<%@include file="/WEB-INF/utils/footer.jsp"%>
