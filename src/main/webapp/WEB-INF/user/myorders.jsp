<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate_user>
    <jsp:body>
        <h1>Mine ordrer</h1>
        <p>Her kan du se alle dine ordrer. Du kan se status på dine ordrer eller klikke på
            'se detaljer' for at få vist flere detaljer om din ordre. <br>Du acceptere ordren ved at klikke på ‘Accepter tilbud’. </p>

        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Ordrenummer</th>
                    <th scope="col">Carport type</th>
                    <th scope="col">Tagtype</th>
                    <th scope="col">Størrelse</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:set var="count" value="1" scope="page"/>
                <c:forEach var="orderItem" items="${sessionScope.orderList}">
                    <tr>
                        <th scope="row">${count}</th>
                        <td>${orderItem.orderID}</td>
                        <td>Enkelt</td>
                        <td>${orderItem.carport.rooftype}</td>
                        <td>${orderItem.carport.length} x ${orderItem.carport.width}</td>
                        <td>${orderItem.statusname}</td>
                        <form action="get">
                            <td style="font-weight: bold">
                                <button class="btn btn-primary" type="submit" formaction="showorderdetailsuser"
                                        name="orderID" value="${orderItem.orderID}">
                                    Vis detaljer
                                </button>
                            </td>
                        </form>
                        <form action="post">
                            <td style="font-weight: bold">
                                <button class="btn btn-primary" type="submit" formaction="acceptoffer" name="orderID"
                                        value="${orderItem.orderID}">
                                    Accepter tilbud
                                </button>
                            </td>
                        </form>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page"/>
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
</t:pagetemplate_user>