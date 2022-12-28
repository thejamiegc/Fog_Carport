<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:body>
        <div class="form-createuser">
        <form action="createUser" method="post">
            <h1 class="h3 mb-3 fw-normal">Opret bruger</h1>
            <p>For at kunne bestille en carport på egne mål, skal du oprette en bruger. Dette kan du gøre her. <br>
                Alle felter markeret med * skal udfyldes. <br> <br>
                Vi gemmer dine kontaktoplysninger, så vi kan kontakte dig med henblik på et udvidet kundemøde.</p>
            <h2>Opret log ind</h2>

            <div class="form-floating">
                <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email">
                <label for="email">Indtast email</label>
                <div id="email" class="form-text">Vi deler ikke dine oplysninger.</div>
                <br>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="password" placeholder="Adgangskode" name="password">
                <label for="password">Adgangskode</label>
            </div>

            <div class="form-floating">
                <input type="password" class="form-control" id="password1" placeholder="Gentag adgangskode"
                       name="password1">
                <label for="password1">Gentag adgangskode</label>
            </div>

            <h2>Kontaktoplysninger</h2>
            <div class="form-floating">
                <input type="text" class="form-control" id="firstname" placeholder="Fornavn" name="firstname">
                <label for="firstname">Fornavn</label>
            </div>

            <div class="form-floating">
                <input type="text" class="form-control" id="lastname" placeholder="Efternavn" name="lastname">
                <label for="lastname">Efternavn</label>
            </div>

            <div class="form-floating">
                <input type="text" class="form-control" id="address" placeholder="Adresse" name="address">
                <label for="address">Adresse</label>
            </div>

            <div class="form-floating">
                <input type="text" class="form-control" id="postalcode" placeholder="Postnummer" name="postalcode">
                <label for="postalcode">Postnummer</label>
            </div>

            <div class="form-floating">
                <input type="text" class="form-control" id="city" placeholder="By" name="city">
                <label for="city">By</label>
            </div>

            <div class="form-floating">
                <input type="tel" class="form-control" id="phonenumber" placeholder="+45" name="phonenumber">
                <label for="phonenumber">Telefonnummer</label>
            </div>

            <input value="Opret bruger" class="w-100 btn btn-lg btn-primary" type="submit"/>
            <br>
            <br>
            <br>
            <br>
        </form>
    </jsp:body>
</t:pagetemplate>