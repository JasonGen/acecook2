<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="type=text/html; charset=utf-8">

    <link rel="stylesheet" type="text/css" href="<spring:url value='/css/style.css'/>"/>
    <link rel="stylesheet" href="<spring:url value='/css/lightbox.css'/>" type="text/css" media="screen"/>
    <script src="js/prototype.js" type="text/javascript"></script>
    <script src="js/scriptaculous.js?load=effects" type="text/javascript"></script>
    <script src="js/lightbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/java.js"></script>


</head>
<body>
<div id="wrap">
    <div class="header">
        <div class="logo"><a href="#"><img src="images/logo.gif" alt="" border="0"/></a></div>
        <div id="menu">
            <ul>
                <li><a href="<spring:url value='/index'/>"><spring:message code="indexLink"/></a></li>
                <li><a href="<spring:url value='/about'/>"><spring:message code="aboutUsLink"/></a></li>
                <li><a href="<spring:url value='/products'/>"><spring:message code="cookingMaterialLink"/></a></li>
                <c:if test="${empty currentUser.email}">
                    <li><a href="<spring:url value='/myAccount'/>"><spring:message code="myAccountLink"/></a></li>
                    <li><a href="<spring:url value='/register'/>"><spring:message code="registerLink"/></a></li>
                </c:if>
                <c:if test="${not empty currentUser.email}">
                    <li><a href="<spring:url value='/myAccount/disconnect' />"><spring:message code="disconnect"/></a>
                    </li>
                </c:if>
                <li>
                    <c:if test="${not empty currentUser.email}">
                        ${currentUser.prenom}
                    </c:if>
                </li>

            </ul>

        </div>

    </div>
    <tiles:insertAttribute name="main-content"/>
</div>


</body>
</html>