<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_user>

    <jsp:body>

        <h1>Detaljeret beskrivelse over dine ordrer MED BOMMMMMMMMMMMMM</h1>

        <div class="table-responsive">

            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Ordrer ID</th>
                    <th scope="col">BOM DEScrIPon</th>
                    <th scope="col">Status navn</th>
                    <th scope="col">DIT NAVN</th>
                    <th scope="col">Pris ( money money money )</th>

                </tr>
                </thead>
                <tbody>
                <c:set var="count" value="1" scope="page" />
                    <tr>
                        <th scope="row">${count}</th>
                        <td>${sessionScope.order.orderID}</td>
                        <td>${sessionScope.order.billOfMaterialsList.get(0).description}</td>
                        <td>${sessionScope.order.statusname}</td>
                        <td>${sessionScope.order.user.firstname}</td>
                        <td>${sessionScope.order.price}</td>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page" />
                </tbody>
            </table>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
            <div class="col">
                <img src="" alt="SVGdrawing/file"/>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate_user>