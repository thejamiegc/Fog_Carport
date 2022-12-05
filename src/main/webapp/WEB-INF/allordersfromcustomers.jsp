<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate_admin>

    <jsp:body>

        <h1>Kunde ordrer</h1>
        <p>Her kan du se alle ordrer fra kunder. Du kan klikke 'vis detaljer' for at se detaljeret beskrivelse over kundens ordrer ( tegning, stykliste, kundeinfo samt pris ). <br>
        Du kan redigere eller slette en ordre samt sætte en status på ordren.</p>

            <div class="">
                <table>
                    <tr>
                        <th style="font-weight: bold">Ordrer nummer</th>
                        <th style="font-weight: bold">Fornavn + efternavn</th>
                        <th style="font-weight: bold">Carporttype</th>
                        <th style="font-weight: bold">Størrelse</th>
                        <th>DROPDOWN</th>
                        <th>KNAP ( for nu )</th>
                        <th>KNAP ( for nu )</th>
                        <th>KNAP ( for nu )</th>
                    </tr>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">x</td>
                    <td style="font-weight: bold">
                        <div class="dropdown">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown link
                            </a>

                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <li><a class="dropdown-item" href="#"></a></li>
                                <li><a class="dropdown-item" href="#"></a></li>
                                <li><a class="dropdown-item" href="#"></a></li>
                            </ul>
                        </div>
                    </td>
                    <td style="font-weight: bold"><button name="showdetails">Vis detaljer</button></td>
                    <td style="font-weight: bold"><button name="deleteorder">Slet ordre</button></td>
                    <td style="font-weight: bold"><button name="editorder">Rediger ordre</button></td>
                </table>
            </div>

    </jsp:body>

</t:pagetemplate_admin>