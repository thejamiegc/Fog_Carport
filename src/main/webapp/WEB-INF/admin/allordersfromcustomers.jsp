<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>
        <h1>Kunde ordrer</h1>
        <p>Her kan du se alle ordrer fra kunder. Du kan klikke 'vis detaljer' for at se detaljeret beskrivelse over
            kundens ordrer. <br>
            Du kan redigere eller slette en ordre samt sætte en status på ordren.</p>

        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Ordrenummer</th>
                    <th scope="col">Kunde ID</th>
                    <th scope="col">Dato</th>
                    <th scope="col">Tagtype</th>
                    <th scope="col">Størrelse</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderItem" items="${sessionScope.orderList}">
                    <tr>
                        <th scope="row"></th>
                        <td>${orderItem.orderID}</td>
                        <td>${orderItem.customerID}</td>
                        <td>${orderItem.created}</td>
                        <td>${orderItem.carport.rooftype}</td>
                        <td>${orderItem.carport.length} x ${orderItem.carport.width}</td>
                        <td>${orderItem.statusname}</td>
                        <form action="post">
                            <td style="font-weight: bold">
                                <button class="btn btn-primary" type="submit" formaction="showdetailsadmin"
                                        name="orderID" value="${orderItem.orderID}">
                                    Vis detaljer
                                </button>
                            </td>
                        </form>
                        <form action="post">
                            <td style="font-weight: bold">
                                <button class="btn btn-primary" type="submit" formaction="deleteorder" name="orderID"
                                        value="${orderItem.orderID}">
                                    Slet bestilling
                                </button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
    </jsp:body>
</t:pagetemplate_admin>