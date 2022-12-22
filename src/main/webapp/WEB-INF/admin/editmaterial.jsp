<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Materialeliste</h1>
        <p>Her kan du redigere i materialets data.</p>

        <form action="updatematerial" method="get">
        <div class="mb-3">
            <label for="materialID" class="form-label">Materiale ID:</label>
            <input readonly type="number" id="materialID" name="materialID" class="form-control" value="${sessionScope.material.materialID}">

            <label for="description" class="form-label">Beskrivelse:</label>
            <input type="text" id="description" name="description" class="form-control" value="${sessionScope.material.description}">

            <label for="length" class="form-label">Længde:</label>
            <input type="number" id="length" name="length" class="form-control" value="${sessionScope.material.length}">

            <label for="unit" class="form-label">Enhed:</label>
            <input type="text" id="unit" name="unit" class="form-control" value="${sessionScope.material.unit}">

            <label for="priceperunit" class="form-label">Pris per enhed:</label>
            <input type="number" id="priceperunit" name="priceperunit" class="form-control" value="${sessionScope.material.pricePerUnit}">

            <label for="typename" class="form-label">Type:</label>
            <input readonly type="text" id="typename" name="typename" class="form-control" value="${sessionScope.material.typename}">


                <input value="Opdater" class="w-100 btn btn-lg btn-primary" type="submit"/>
            </div>

        </form>
        <br>
        <br>
        <br>
        <br>
        <br>



    </jsp:body>

</t:pagetemplate_admin>