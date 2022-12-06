<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="form-createuser">
            <form method="post">
                <h1 class="h3 mb-3 fw-normal">Opret bruger</h1>
                <p>For at kunne bestille en carport på egne mål, skal du oprette en bruger. Dette kan du gøre her. <br>
                    Alle felter markeret med * skal udfyldes. <br> <br>
                    Vi gemmer dine kontaktoplysninger, så vi kan kontakte dig med henblik på et udvidet kundemøde.</p>
                <h2>Opret log ind</h2>

                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Indtast email</label>
                    <div id="email" class="form-text">Vi deler ikke dine oplysninger.</div>
                    <br>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="password" placeholder="Adgangskode">
                    <label for="floatingPassword">Adgangskode</label>
                </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="password1" placeholder="Gentag adgangskode">
                    <label for="floatingPassword">Gentag adgangskode</label>
                </div>

                <h2>Kontaktoplysninger</h2>
                <div class="form-floating">
                    <input type="text" class="form-control" id="firstname" placeholder="Fornavn">
                    <label for="firstname">Fornavn</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="lastname" placeholder="Efternavn">
                    <label for="lastname">Efternavn</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="address" placeholder="Adresse">
                    <label for="address">Adresse</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="postalcode" placeholder="Postnummer">
                    <label for="postalcode">Postnummer</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="city" placeholder="By">
                    <label for="city">By</label>
                </div>

                <div class="form-floating">
                    <input type="tel" class="form-control" id="phonenumber" placeholder="+45">
                    <label for="phonenumber">Telefonnummer</label>
                </div>

                <button class="w-100 btn btn-lg btn-primary" type="submit">Opret bruger</button>
            </form>


    </jsp:body>
</t:pagetemplate>