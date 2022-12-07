<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Kunde bestillinger</h1>
        <p>Her kan du se alle kunde bestillinger. Du kan klikke 'se tegning' for at se hvordan kunden ønsker sit layout på sin carport <br>
        Du kan klikke på 'lav ordre' for at oprette et tilbud til kunden.</p>

            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Ordrer nummer</th>
                        <th scope="col">Carport type</th>
                        <th scope="col">Tagtype</th>
                        <th scope="col">Skur</th>
                        <th scope="col">Størrelse</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Lav ordre"></td>
                        <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Vis detajler"></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Lav ordre"></td>
                        <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Vis detajler"></td>

                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td>x</td>
                        <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Lav ordre"></td>
                        <td style="font-weight: bold"><input class="btn btn-primary" type="button" value="Vis detajler"></td>

                    </tr>

                    </tbody>
                </table>
            </div>

    </jsp:body>

</t:pagetemplate_admin>