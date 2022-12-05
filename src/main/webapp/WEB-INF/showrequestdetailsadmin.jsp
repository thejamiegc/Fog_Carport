<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Detaljeret beskrivelse over bestilling</h1>

        <div class="row">
            <div class="col">
                <h2>Kunde oplysninger:</h2>
                <p>Navn: ${requestScope.user.firstname} + ${requestScope.user.lastname}</p>
                <p>Telefon: +45 ${requestScope.user.phonenumber}</p>
                <p>Email: ${requestScope.user.email}</p>
                <h2>Ønsker til carport:</h2>
                <p>Carport type: Enkelt</p>
                <p>Tag type: Fladt tag</p>
                <p>Skur: med skur</p>
                <p>Længde: ${requestScope.carport.length} meter</p>
                <p>Bredde: ${requestScope.carport.width} meter</p>
            </div>
            <div class="col">
                <img src="" alt="SVGdrawing/file"/>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate_admin>