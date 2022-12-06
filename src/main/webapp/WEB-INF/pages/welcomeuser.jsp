<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate_user>

    <jsp:body>

        <h1>Velkommen ${sessionScope.user.firstname}</h1>
        <p>Her kan du bygge en carport skræddersyet til dine ønsker.</p>
        <a href="../buildcarport.jsp"><img src="../../images/carportfladttag.png" alt="flatroof"></a>


    </jsp:body>

</t:pagetemplate_user>