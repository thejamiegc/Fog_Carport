<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate_user>

    <jsp:body>

        <h1>Byg en carport</h1>
        <p>Udfyld nedenstående omhyggeligt, og tryk "bestil tilbud". <br>
        Så vender vi hurtigst muligt tilbage med et tilbud til dig.</p>

        <h2>Vælg dine mål i meter her:</h2>
        <div class="form-outline mb-4">
            <form action="carportrequest" style="width:100px" method="post">
                <label for="width">Carport bredde*: </label>
                <input type="number" id="width" placeholder="Bredde i meter" name="width"/>
                <br>
                <label for="length">Carport længde*: </label>
                <input type="number" id="length" placeholder="Længde i meter" name="length"/>
                <br>
                <label for="roof">Carport tag: </label>
                <input type="text" id="roof" placeholder="Fladt tag" name="roof"/>
                <br>
                <label for="shed">Skur: </label>
                <input type="text" id="shed" placeholder="Ja eller nej" name="shed"/>
                <br>
                HVIS skur så:
                <label for="shedwidth">Skur bredde*: </label>
                <input type="number" id="shedwidth" placeholder="Skur bredde i meter" name="shedwidth"/>
                <br>
                <label for="shedlength">Skur længde*: </label>
                <input type="number" id="shedlength" placeholder="Skur længde i meter" name="shedlength"/>
                <br>
                <input type="submit" value="Bestil tilbud"/>
            </form>
        </div>


    </jsp:body>

</t:pagetemplate_user>