<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Velkommen!
    </jsp:attribute>

    <jsp:body>

        <p>Dette er Fog's custom Carport-hjemmeside. GLHF!</p>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu. Det kan du gøre her: <a
                    href="login.jsp">Login</a></p>
        </c:if>
        <div class="indexphoto">
        <img src="images/carport.jpg" alt="carport" width="600px" height="400px">
        </div>

    </jsp:body>

</t:pagetemplate>