<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Sletning af bestilling eller ordre</h1>
        <p>Bestillingen/ordren er nu blevet slettet. Nedenunder kan du se informationerne: </p>

        <div class="table-responsive">
            <table class="table table-hover">
                <tbody>
                    <tr>
                        <td>Fornavn: ${sessionScope.order.user.firstname}</td>
                        <td>Efternavn: ${sessionScope.order.user.lastname}</td>
                        <td>OrdrerID: ${sessionScope.order.orderID}</td>
                    </tr>
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