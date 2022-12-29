<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>

<header>
    <nav class="navbar navbar-expand-sm navbar-blue" aria-label="Third navbar example">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/navtowelcomeuser">
                <img src="${pageContext.request.contextPath}/images/FOGLogo.jpg"/>
            </a>
            <a class="navbar-brand" href="#"></a>
            <button class="navbar-toggler toggler-example darken-3" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarsExample03"
                    aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExample03">
                <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                    <a class="nav-material nav-link" href="${pageContext.request.contextPath}/navToBuildCarport">Byg en
                        carport</a>
                    <a class="nav-material nav-link" href="myorders">Se mine ordrer</a>
                    <c:if test="${sessionScope.user == null }">
                        <a class="nav-material nav-link" href="${pageContext.request.contextPath}/login.jsp">Log ind</a>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                        <div style="color: white"><p>Bruger: ${sessionScope.user.firstname}</p></div>
                        <a class="nav-material nav-link" href="${pageContext.request.contextPath}/logout">Log ud</a>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
    <!-- search bar -->
    <div class="form-group has-search">
        <span class="fa fa-search form-control-feedback"></span>
        <input type="text" class="form-control" placeholder="Søg">
    </div>
</header>

<div class="container mt-4" style="min-height: 400px;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<footer class="footer mt-auto py-2 bg-light fixed-bottom">
    <div class="row">
        <div class="col md-3 text-muted">DAT 2.Sem Gruppe C - Eksamen</div>
        <div class="col md-9 text-muted">Jamie, Isak, Helena, Andreas og Felicia</div>
    </div>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous">
</script>
</html>