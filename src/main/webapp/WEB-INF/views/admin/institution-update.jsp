<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 05.01.2020
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<jsp:include page="../header.jsp"/>

<form:form method="post" modelAttribute="updateInstitution">
    <form:hidden path="id"/>
<div class="form-section form-section--columns">
    <div class="form-section--column">

        <h4>Edytuj Instytucje</h4>
        <div class="form-group form-group--inline">
            <label> Nazwa <form:input path="name" required="true"/> </label>
        </div>

        <div class="form-group form-group--inline">
            <label> Opis <form:textarea style="margin: 0px; width: 200px; height: 100px"
                                        path="description" required="true"/> </label>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/admin/institutions" class="btn">Wstecz</a>
            <button type="submit" class="btn">Edytuj</button>
        </div>
    </div>
</div>
    <form:errors path="*"/>
</form:form>
<jsp:include page="../footer.jsp"/>

</html>