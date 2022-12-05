<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Velkommen ${sessionScope.user.username}</h1>
        <p>Her kan du tilgå kundebestillinger, kundeordrer og materialelisten.</p>
        <p>I kundebestillinger kan du se hvad kunderne har bestilt et tilbud på. <br>
        Du kan også lave en bestilling om til en ordre, så kunden modtager et pristilbud.</p>
        <p>I kundeordrer kan du se alle aktive ordrer i systemet.<br>
        I materialelisten kan du se og redigere priserne på materialer.</p>

    </jsp:body>

</t:pagetemplate_admin>