<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Kunde bestillinger</h1>
        <p>Her kan du se alle kunders bestillinger. Du kan se status på ordrene eller XXXX </p>


        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Ordrer nummer</th>
                    <th scope="col">Kunde ID</th>
                    <th scope="col">Dato</th>
                    <th scope="col">Tagtype</th>
                    <th scope="col">Skur</th>
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
                        <td>${orderItem.carport.shed}</td>
                        <td>${orderItem.carport.length} x ${orderItem.carport.width}</td>
                        <td>${orderItem.statusname}</td>
                        <form action="createorder" method="get">
                            <td style="font-weight: bold"><input class="btn btn-primary" type="submit" value="Lav ordre"></td>
                        </form>
                        <form action="showrequestdetailsadmin" method="get">
                            <td style="font-weight: bold"><input class="btn btn-primary" type="submit" value="Vis detajler"></td>
                        </form>
<%--                        <form action="deleterequest" id="delete" method="get">--%>
<%--                            <td style="font-weight: bold"><input class="btn btn-primary" type="submit" value="Slet bestilling"></td>--%>
<%--                        </form>--%>
                        <form action="post">
                            <td style="font-weight: bold"><button class="btn btn-primary"   type ="submit" formaction="deleterequest" name="orderItem" value="${orderItem}">
                                Slet bestilling
                            </button></td>
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