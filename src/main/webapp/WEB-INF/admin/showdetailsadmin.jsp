<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>


        <div class="container rounded bg-white">
            <div class="row d-flex justify-content-center pb-5">
                <div class="col-sm-5 col-md-5 ml-1">
                    <h1>Detaljeret beskrivelse over bestilling</h1>
                    <h4>Personlige oplysninger:</h4>
                    <div class="d-flex pt-2">
                        <div><p>Fornavn: <span class="green">${sessionScope.order.user.firstname}</span></p></div>
                        <div><p>Efternavn: <span class="green">${sessionScope.order.user.lastname}</span></p></div>
                        <div><p>Telefon nummer: <span class="green">${sessionScope.order.user.phonenumber}</span></p></div>
                        <div><p>Email: <span class="green">${sessionScope.order.user.email}</span></p></div>
                        <div><p>Addresse: <span class="green">${sessionScope.order.user.address}</span></p></div>
                        <div><p>Post nummer: <span class="green">${sessionScope.order.user.postalcode}</span></p></div>
                        <div><p>By: <span class="green">${sessionScope.order.user.city}</span></p></div>
                    </div>
                    <h4>Carport oplysninger:</h4>
                    <div class="d-flex pt-2">
                        <div><p>Længde: <span class="green">${sessionScope.order.carport.length}</span></p></div>
                        <div><p>Bredde: <span class="green">${sessionScope.order.carport.width}</span></p></div>
                        <div><p>Skur: <span class="green">${sessionScope.order.carport.shed}</span></p></div>
                        <div><p>Tagtype: <span class="green">${sessionScope.order.carport.rooftype}</span></p></div>
                    </div>
                    <hr>
                    <div class="pt-2">
                        <div class="d-flex">
                            <div><p><b>Samlet pris på tilbud: </b><span class="green">${sessionScope.order.price}</span></p></div>
                            <div class="ml-auto p-2"><p class="text-primary"><i class="fa fa-plus-circle text-primary"></i>Add payment card</p></div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 col-md-4 offset-md-1 mobile">
                    <div class="bg-light rounded d-flex flex-column">
                        <div class="p-2 ml-3"><h4>Stykliste:</h4></div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Contracted Price</div>
                            <c:forEach var="orderItem" items="${sessionScope.orderList}">
                            <div class="ml-auto">${sessionScope.order.bom}</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Amount toward deductible</div>
                            <div class="ml-auto">$0.00</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Coinsurance( 0% )</div>
                            <div class="ml-auto">+ $0.00</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Copayment</div>
                            <div class="ml-auto">+ $40.00</div>
                        </div>
                        <div class="border-top px-4 mx-3">
                        </div>
                        <div class="p-2 d-flex pt-3">
                            <div class="col-8">Total Deductible, Coinsurance, and Copay</div>
                            <div class="ml-auto">$40.00</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Maximum out-of-pocket on Insurance Policy (not reached)</div>
                            <div class="ml-auto">$6500.00</div>
                        </div>
                        <div class="border-top px-4 mx-3"></div>
                        <div class="p-2 d-flex pt-3">
                            <div class="col-8">Insurance Responsibility</div>
                            <div class="ml-auto"><b>$71.76</b></div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Patient Balance  <span class="fa fa-question-circle text-secondary"></span></div>
                            <div class="ml-auto"><b>$71.76</b></div>
                        </div>
                        <div class="border-top px-4 mx-3"></div>
                        <div class="p-2 d-flex pt-3">
                            <div class="col-8"><b>Total</b></div>
                            <div class="ml-auto"><b class="green">$85.00</b></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate_admin>