<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:body>
        <div class="form-signin">
        <form action="login" method="post">
            <h1 class="h3 mb-3 fw-normal">Log ind</h1>
            <p>Herunder kan du logge ind.</p>

            <div class="form-floating">
                <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email">
                <label for="email">Email addresse</label>
                <div id="emailHelp" class="form-text">Vi deler ikke dine oplysninger.</div>
                <br>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="password" placeholder="Password" name="password">
                <label for="password">Adgangskode</label>
            </div>
            <input class="w-100 btn btn-lg btn-primary" type="submit" value="Log mig ind"/>
        </form>

    </jsp:body>
</t:pagetemplate>