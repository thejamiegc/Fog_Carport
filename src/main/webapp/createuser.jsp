<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>
        <h1>Opret bruger</h1>
        <p>For at kunne bestille en carport på egne mål, skal du oprette en bruger. Dette kan du gøre her. <br>
            Alle felter markeret med * skal udfyldes. <br> <br>
            Vi gemmer dine kontaktoplysninger, så vi kan kontakte dig med henblik på et udvidet kundemøde.</p>
        <h2>Opret log ind</h2>
        <div class="form-outline mb-4">
            <form action="createuser" style="width:100px" method="post">
                <label for="email">Indtast email: </label>
                <input type="text" id="email" placeholder="Email" name="username"/>
                <br>
                <label for="password">Vælg adgangskode: </label>
                <input type="text" id="password" placeholder="Adgangskode" name="username"/>
                <br>
                <label for="password1">Gentag adgangskode: </label>
                <input type="text" id="password1" placeholder="Adgangskode" name="username"/>
                <br>
                <h2>Kontaktoplysninger</h2>
                <label for="firstname">Fornavn* : </label>
                <input type="text" id="firstname" placeholder="Fornavn" name="username"/>
                <br>
                <label for="lastname">Efternavn* : </label>
                <input type="text" id="lastname" placeholder="Efternavn" name="username"/>
                <br>
                <label for="address">Adresse* : </label>
                <input type="text" id="address" placeholder="Adresse" name="username"/>
                <br>
                <label for="postnumber">Postnummer* : </label>
                <input type="number" id="postnumber" placeholder="Postnummer" name="username"/>
                <br>
                <label for="city">By* : </label>
                <input type="text" id="city" placeholder="By" name="username"/>
                <br>
                <label for="phonenumber">Telefon nummer* : </label>
                <input type="number" id="phonenumber" placeholder="+45" name="username"/>
                <br>
                <input type="submit" value="Opret bruger"/>
            </form>
        </div>

    </jsp:body>
</t:pagetemplate>