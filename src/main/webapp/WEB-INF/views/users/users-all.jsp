<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 06.01.2020
  Time: 13:12
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
    <table id="tabUser" >
        <tr class="form-group form-group--inline">
            <th>Lp</th>
            <th>Email</th>
            <th>Nazwa</th>
            <th>Czy aktywny?</th>
            <th>Zarzadzaj</th>
        </tr>
        <c:forEach items="${allUsers}" var="user" varStatus="stat">
            <tr class="form-group text-area">
                <td>${stat.count}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.active}</td>
                <td>
                    <c:url value="/admin/users/delete" var="deleteURL">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <c:url value="/admin/users/edit" var="updateURL">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <c:url value="/admin/users/block" var="blockURL">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <c:url value="/admin/users/unblock" var="unblockURL">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <a href="${deleteURL}" class="btn btn--without-border">Usuń</a>
                    <a href="${updateURL}" class="btn btn--without-border">Edytuj</a>
                    <a href="${blockURL}" class="btn btn--without-border">Zablokuj</a>
                    <a href="${unblockURL}" class="btn btn--without-border">Odblokuj</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div></br></br></br></br></br>

<jsp:include page="../footer.jsp"/>
</body>
</html>
