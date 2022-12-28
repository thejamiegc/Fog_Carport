<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>
    <jsp:body>
        <h1>Materialeliste</h1>
        <p>Her kan du se alle materialer. Du kan slette eller ændre i materialer.</p>

        <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Længde</th>
                <th scope="col">Enhed</th>
                <th scope="col">Pris per enhed</th>
                <th scope="col">Type</th>
                <th scope="col">Rediger</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="materiallist" items="${sessionScope.materiallist}">
                <tr>
                    <td>${materiallist.value.materialID}</td>
                    <td>${materiallist.value.description}</td>
                    <td>${materiallist.value.length}</td>
                    <td>${materiallist.value.unit}</td>
                    <td>${materiallist.value.pricePerUnit}</td>
                    <td>${materiallist.value.typename}</td>
                    <form action="post">
                        <td style="font-weight: bold">
                            <button class="btn btn-primary" type="submit" formaction="editmateriallist"
                                    name="materialID" value="${materiallist.value.materialID}">
                                Rediger
                            </button>
                        </td>
                    </form>

                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:body>
</t:pagetemplate_admin>