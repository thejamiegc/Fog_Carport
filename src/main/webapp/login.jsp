<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <div class="row">
        <div class="col md-4"></div>
            <div class="col">
                <h1>Log ind</h1>
                <p>Herunder kan du logge ind.</p>
                <form action="login" method="post">
                    <div class="mb-3">
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" id="password">
                    </div>
                    <button type="submit" class="btn btn-primary">Log mig ind</button>
                </form>
        </div>
            <div class="col md-4"></div>
        </div>

    </jsp:body>
</t:pagetemplate>