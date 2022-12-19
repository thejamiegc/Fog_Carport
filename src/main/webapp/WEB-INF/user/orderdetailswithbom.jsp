<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_user>

    <jsp:body>

        <h1>Ordre Detaljer - #${sessionScope.order.orderID}</h1>

        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Dine oplysninger</h5>
                        <p class="card-text">
                        <p>${sessionScope.order.user.firstname} ${sessionScope.order.user.lastname}</p>
                        <p>${sessionScope.order.user.address}
                            <br> ${sessionScope.order.user.postalcode}, ${sessionScope.order.user.city}</p>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Carport oplysninger</h5>
                            <p class="card-text">
                            <p>Størrelse: ${sessionScope.order.carport.carportSquareMeter} kvadratmeter</p>
                            <p>Længde: ${sessionScope.order.carport.length} cm</p>
                            <p>Bredde: ${sessionScope.order.carport.width} cm</p>
                            <p>Tagtype: ${sessionScope.order.carport.rooftype}</p>
                            <p>Skur: Med skur</p>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Plantegning</h5>
                            <p>Her ses en tegning af carporten fra oven</p>
                                ${sessionScope.carportDraw}
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Snittegning</h5>
                            <p>Her ses en tegning af carporten fra siden</p>
                            ${sessionScope.carportDraw}<!-- byt ud med tegning fra siden -->
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <div class="col-mb-7">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Stykliste</h5>
                            <ul class="list-group">
                                <li class="list-group-item">Liste 1</li>
                                <li class="list-group-item">Liste 2</li>
                                <li class="list-group-item">Liste 3</li>
                                <li class="list-group-item">Liste 4</li>
                                <li class="list-group-item">Liste 5</li>
                            </ul>
                            <a href="#" class="btn btn-primary">Print stykliste</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <br>
        <br>
        <br>

    </jsp:body>

</t:pagetemplate_user>