<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Kunde ordrer</h1>
        <p>Her kan du se alle ordrer fra kunder. Du kan klikke 'vis detaljer' for at se detaljeret beskrivelse over kundens ordrer ( tegning, stykliste, kundeinfo samt pris ). <br>
        Du kan redigere eller slette en ordre samt sætte en status på ordren.</p>


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
                        <td>${orderItem.statusID}</td>
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
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
<%--            <div class="">--%>
<%--                <table>--%>
<%--                    <tr>--%>
<%--                        <th style="font-weight: bold">Ordrer nummer</th>--%>
<%--                        <th style="font-weight: bold">Fornavn + efternavn</th>--%>
<%--                        <th style="font-weight: bold">Carporttype</th>--%>
<%--                        <th style="font-weight: bold">Størrelse</th>--%>
<%--                        <th>DROPDOWN</th>--%>
<%--                        <th>KNAP ( for nu )</th>--%>
<%--                        <th>KNAP ( for nu )</th>--%>
<%--                        <th>KNAP ( for nu )</th>--%>
<%--                    </tr>--%>
<%--                    <td style="font-weight: bold">x</td>--%>
<%--                    <td style="font-weight: bold">x</td>--%>
<%--                    <td style="font-weight: bold">x</td>--%>
<%--                    <td style="font-weight: bold">x</td>--%>
<%--                    <td style="font-weight: bold">--%>
<%--                        <div class="dropdown">--%>
<%--                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                                Dropdown link--%>
<%--                            </a>--%>

<%--                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">--%>
<%--                                <li><a class="dropdown-item" href="#"></a></li>--%>
<%--                                <li><a class="dropdown-item" href="#"></a></li>--%>
<%--                                <li><a class="dropdown-item" href="#"></a></li>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
<%--                    </td>--%>
<%--                    <td style="font-weight: bold"><button name="showdetails">Vis detaljer</button></td>--%>
<%--                    <td style="font-weight: bold"><button name="deleteorder">Slet ordre</button></td>--%>
<%--                    <td style="font-weight: bold"><button name="editorder">Rediger ordre</button></td>--%>
<%--                </table>--%>
<%--            </div>--%>

    </jsp:body>

</t:pagetemplate_admin>