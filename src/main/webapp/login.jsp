<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <h1>Log ind</h1>
        <p>Herunder kan du logge ind.</p>

        <div class="form-outline mb-4">
            <form action="login" style="width:100px" method="post">
                <input type="text" id="username" placeholder="Email" name="username"/>
                <br>
                <br>
                <input type="password" id="password" placeholder="Adgangskode" name="password"/>
                <br>
                <br>
                <input type="submit" value="Log mig ind"/>
            </form>
        </div>

    </jsp:body>
</t:pagetemplate>