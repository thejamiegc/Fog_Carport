<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Materialeliste</h1>
        <p>Her kan du se alle materialer. Du kan slette eller ændre i materialer.</p>

        <iframe src="https://docs.google.com/spreadsheets/d/e/2PACX-1vQYtLB6VNyVC2r_QM-hXgNJJNkQhXGPsJHSZwMjphKsQ-6Cb4bkDhjIn0uHTRNT9InEJOVoDUCEQBiw/pubhtml?gid=0&amp;single=true&amp;widget=true&amp;headers=false"></iframe>

        <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">ID</th>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Længde</th>
                <th scope="col">Enhed</th>
                <th scope="col">Materiale beskrivelse</th>
                <th scope="col">Pris per meter</th>
                <th scope="col">Type</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="materialItem" items="${sessionScope.materialList}">
                <tr>
                    <th scope="row"></th>
                    <td>${orderItem.orderID}</td>
                    <td>${orderItem.customerID}</td>
                    <td>${orderItem.created}</td>
                    <td>${orderItem.carport.rooftype}</td>
                    <td>${orderItem.carport.shed}</td>
                    <td>${orderItem.carport.length} x ${orderItem.carport.width}</td>
                    <td>${orderItem.statusname}</td>
                    <form action="createorder" method="get">
                        <td style="font-weight: bold"><input class="btn btn-primary" type="submit" value="Lav ordre"></td>
                    </form>
                    <form action="showrequestdetailsadmin" method="get">
                        <td style="font-weight: bold"><input class="btn btn-primary" type="submit" value="Vis detajler"></td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:body>

</t:pagetemplate_admin>