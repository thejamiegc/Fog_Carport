<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Kunde bestillinger</h1>
        <p>Her kan du se alle kunde bestillinger. Du kan klikke 'se tegning' for at se hvordan kunden ønsker sit layout på sin carport <br>
        Du kan klikke på 'lav ordre' for at oprette et tilbud til kunden.</p>

            <div class="">
                <table>
                    <tr>
                        <th style="font-weight: bold">Ordrer nummer</th>
                        <th style="font-weight: bold">Carport type</th>
                        <th style="font-weight: bold">Tagtype</th>
                        <th style="font-weight: bold">Skur</th>
                        <th style="font-weight: bold">Størrelse</th>
                        <th>KNAP ( for nu )</th>
                        <th>KNAP ( for nu )</th>
                    </tr>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold"><button name="createorder">Lav ordre</button></td>
                    <td style="font-weight: bold"><button name="showdetails">Vis detaljer</button></td>
                </table>
            </div>

    </jsp:body>

</t:pagetemplate_admin>