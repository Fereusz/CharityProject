<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 17.12.2019
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="isAnonymous()">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </sec:authorize></br</br>

            <sec:authorize access="hasRole('ADMIN')">
                <li> Welcome <sec:authentication property="principal.username"/></li>
                <li><a href="/admin/admins" class="btn btn--without-border">Administratorzy</a></li>
                <li><a href="/admin/users" class="btn btn--without-border">Użytkownicy</a></li>
                <li><a href="/admin/institutions" class="btn btn--without-border">Instytucje</a></li>
            </sec:authorize></br></br>

            <sec:authorize access="hasRole('USER')">
                <li> Welcome <sec:authentication property="principal.username"/></li>
                <li><a href="/user/edit" class="btn btn--without-border">Edytuj Dane</a></li>
                <li><a href="/user/password" class="btn btn--without-border">Zmień hasło</a></li>
                <li><a href="/user/donations" class="btn btn--small btn--without-border">Zarządzanie darami</a></li>

            </sec:authorize>

            <sec:authorize access="isAuthenticated()">


                <form method="post" action="/logout">
                        <button class="btn btn--small btn--without-border" type="submit">Wyloguj</button>
                        <sec:csrfInput/>
                    </form>
                </li>
            </sec:authorize>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <sec:authorize access="hasRole('USER')">
            <li><a href="/donation/form" class="btn btn--without-border">Formularz przekazania darów</a></li>
            </sec:authorize>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

</header>
