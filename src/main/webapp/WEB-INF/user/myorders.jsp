<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_user>

    <jsp:body>

        <h1>Mine ordrer</h1>
        <p>Her kan du se alle dine ordrer. Du kan se status på dine ordrer eller klikke på
        'se tegning' for at få et visuelt overblik.</p>


        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Ordrer nummer</th>
                    <th scope="col">Carport type</th>
                    <th scope="col">Tagtype</th>
                    <th scope="col">Skur</th>
                    <th scope="col">Størrelse</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderList" items="${sessionScope.orderList},${sessionScope.carportList}">
                <tr>
                    <th scope="row">1</th>
                    <td>${sessionScope.orderList.get.orderID}</td>
                    <td>Enkelt</td>
                    <td>${sessionScope.carportList.get.rooftype}</td>
                    <td>${sessionScope.carportList.get.shed}</td>
                    <td>${sessionScope.carportList.get.length} x ${sessionScope.carportList.get.width}</td>
                    <td>${sessionScope.orderList.get.statusID}</td>
                    <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Vis detajler"></td>
                </tr>
                </c:forEach>
                <tr>
                    <th scope="row">2</th>
                    <td>x</td>
                    <td>x</td>
                    <td>x</td>
                    <td>x</td>
                    <td>x</td>
                    <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Lav ordre"></td>
                    <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Vis detajler"></td>

                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>x</td>
                    <td>x</td>
                    <td>x</td>
                    <td>x</td>
                    <td>x</td>
                    <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Lav ordre"></td>
                    <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Vis detajler"></td>

                </tr>

                </tbody>
            </table>
        </div>

    </jsp:body>

</t:pagetemplate_user>