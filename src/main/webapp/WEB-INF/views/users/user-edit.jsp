<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 06.01.2020
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<jsp:include page="../header.jsp"/>

<section class="login-page">

    <h2>Zmien dane uzytkownika</h2>

    <form:form method="post" modelAttribute="editUser">

        <div class="form-group">

            <form:input path="username" name="username" placeholder="Nazwa użytkownika" required="true"/>
        </div>

        <div class="form-group">
            <form:input path="email" name="email" placeholder="e-mail" required="true"/>
        </div>

        </div>

        <div class="form-group form-group--buttons">
                <%--        <a href="/login" class="btn btn--without-border">Zaloguj</a>--%>
            <button class="btn" type="submit">Zatwierdz zmiany</button>
        </div>
        <form:errors path="*"/>

    </form:form>

    <jsp:include page="../footer.jsp"/>
</section>
