<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_user>
    <jsp:body>
        <h1>Byg en carport</h1>
        <p>Udfyld nedenstående omhyggeligt, og tryk "bestil tilbud". <br>
            Så vender vi hurtigst muligt tilbage med et tilbud til dig.</p>

        <h2>Vælg dine mål i cm her:</h2>
        <form action="buildCarport" method="post">
            <div class="mb-3">
                <label for="length" class="form-label">Carport længde:</label>
                <input type="number" id="length" name="length" class="form-control" placeholder="længde i cm">
            </div>
            <div class="mb-3">
                <label for="width" class="form-label">Carport bredde:</label>
                <input type="number" id="width" name="width" class="form-control" placeholder="bredde i cm">
            </div>
            <div class="mb-3">
                <label>Carport tag:</label>
                <input class="form-control" id="roof" name="roof" type="text" value="Fladt tag"
                       aria-label="readonly input example" readonly>
            </div>

            <div data-bs-toggle="collapse" data-bs-target="#demo">
                <div class="form-check">
                    <p>Tilføj skur<input class="form-check-input" type="checkbox" id="shed" name="shed" value="1"></p>

                </div>
            </div>

            <div id="demo" class="collapse">
                <div class="mb-3">
                    <label for="shedwidth" class="form-label">Skur bredde:</label>
                    <input type="number" id="shedwidth" name="shedwidth" class="form-control"
                           placeholder="bredde i cm">
                </div>
                <div class="mb-3">
                    <label for="shedlength" class="form-label">Skur længde:</label>
                    <input type="number" id="shedlength" name="shedlength" class="form-control"
                           placeholder="længde i cm">
                </div>
            </div>

            <div class="mb-3">
                <input value="Bestil tilbud" class="w-100 btn btn-lg btn-primary" type="submit"/>
            </div>
            </div>
        </form>
        <br>
        <br>

    </jsp:body>
</t:pagetemplate_user>