<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Forside
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col md-3">
                <h1>Velkommen!</h1>
                <p>Dette er Fog's custom Carport-hjemmeside. GLHF!</p>
                <c:if test="${sessionScope.user == null}">
                    <p>Du er ikke logget ind endnu. Det kan du gøre ved at <a
                            href="login.jsp"><b>klikke her.</b></a></p>
                </c:if>
            </div>
            <div class="col md-9">
                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-material active">
                            <img src="images/image1.png" class="d-block w-100" alt="image1">
                        </div>
                        <div class="carousel-material">
                            <img src="images/image2.png" class="d-block w-100" alt="image2">
                        </div>
                        <div class="carousel-material">
                            <img src="images/image3.png" class="d-block w-100" alt="image3">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
    </jsp:body>
</t:pagetemplate>