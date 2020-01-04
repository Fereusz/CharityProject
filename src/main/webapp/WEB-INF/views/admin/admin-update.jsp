<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 04.01.2020
  Time: 17:17
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

    <h2>Zmien dane administratora</h2>

    <form:form method="post" modelAttribute="adminUpdate">
    <form:hidden path="id"/>
    <div class="form-group">

        <form:input path="username" name="username" placeholder="Nazwa użytkownika" required="true"/>
    </div>

    <div class="form-group">
        <form:input path="email" name="email" placeholder="e-mail" required="true"/>
    </div>

    <div class="form-group">
        <form:input path="password" name="password" placeholder="Podaj hasło" required="true"/>

    </div>
    <div class="form-group">
        <form:input path="rePassword" name="rePassword" placeholder="Powtórz hasło" required="true"/>

    </div>

    <div class="form-group form-group--buttons">
<%--        <a href="/login" class="btn btn--without-border">Zaloguj</a>--%>
        <button class="btn" type="submit">Potwierdz</button>
    </div>
        <form:errors path="*"/>

    </form:form>

    <jsp:include page="../footer.jsp"/>
    </section>
</html>