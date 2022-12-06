<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_user>

    <jsp:body>

        <h1>Mine ordrer</h1>
        <p>Her kan du se alle dine ordrer. Du kan se status på dine ordrer eller klikke på
        'se tegning' for at få et visuelt overblik.</p>

            <div class="">
                <table>
                    <tr>
                        <th style="font-weight: bold">Ordrer nummer</th>
                        <th style="font-weight: bold">Carport type</th>
                        <th style="font-weight: bold">Tagtype</th>
                        <th style="font-weight: bold">Skur</th>
                        <th style="font-weight: bold">Størrelse</th>
                        <th style="font-weight: bold">Status</th>
                        <th>KNAP ( for nu )</th>
                    </tr>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold"><button name="showdetails">Vis detaljer</button></td>
                </table>
            </div>
            <br>
            <div class="">
                <input type="submit" value="Checkout"/>
            </div>

    </jsp:body>

</t:pagetemplate_user>