<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 10.01.2020
  Time: 12:24
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
            <th>Liczba worków</th>
            <th>Miasto</th>
            <th>Data odbioru</th>
            <th>Godzina odbioru</th>
            <th>Szczegóły</th>
            <th>Status</th>
            <th>Zarządzaj</th>

        </tr>
        <c:forEach items="${allDonations}" var="donation" varStatus="stat">
            <tr class="form-group text-area">
                <td>${stat.count}</td>
                <td>${donation.quantity}</td>
                <td>${donation.zipCode} ${donation.city} ${donation.street} </td>
                <td>${donation.pickUpDate}</td>
                <td>${donation.pickUpTime}</td>
                <td>${donation.pickUpComment}</td>
                <td>${donation.status}</td>

                <c:if test="${donation.status == true}">
                    <td>Dary odebrane</td>
                </c:if>
                <c:if test="${donation.status == false}">
                    <td>Dary nie zostały odebrane</td>
                </c:if>
                <td>
                    <c:url value="/user/donations/delete" var="deleteURL">
                        <c:param name="id" value="${donation.id}"/>
                    </c:url>
                    <a href="${deleteURL}" class="btn btn--without-border">Usuń</a>

                    <c:if test="${donation.status == false}">
                    <c:url value="/user/donations/update" var="updateURL">
                        <c:param name="id" value="${donation.id}"/>
                    </c:url>
                    <a href="${updateURL}" class="btn btn--without-border">Edytuj</a>
                    </c:if>

            </tr>
        </c:forEach>
    </table>
</div></br></br></br></br></br>

<jsp:include page="../footer.jsp"/>
</body>
</html>