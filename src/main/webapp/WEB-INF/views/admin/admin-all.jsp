<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 04.01.2020
  Time: 16:05
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
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>

<jsp:include page="../header.jsp"/></br></br>

<div class="container--90">
    <table id="tabAdmin" >
        <tr class="form-group form-group--inline">
            <th>Lp</th>
            <th>Email</th>
            <th>Nazwa</th>
            <th>Zarzadzaj</th>
        </tr>
        <c:forEach items="${allAdmins}" var="admin" varStatus="stat">
            <tr class="form-group text-area">
                <td>${stat.count}</td>
                <td>${admin.email}</td>
                <td>${admin.username}</td>
                <td>
                    <c:url value="/admin/admins/delete" var="deleteURL">
                        <c:param name="id" value="${admin.id}"/>
                    </c:url>
                    <c:url value="/admin/admins/edit" var="updateURL">
                        <c:param name="id" value="${admin.id}"/>
                    </c:url>
                    <a href="${deleteURL}" class="btn btn--without-border">Usuń</a>
                    <a href="${updateURL}" class="btn btn--without-border">Edytuj</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="/admin/create" class="btn btn--without-border">
        Dodaj administratora</a></br></br>
</div></br></br></br></br></br>

<jsp:include page="../footer.jsp"/>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
