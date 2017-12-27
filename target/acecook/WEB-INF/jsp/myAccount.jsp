<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>AceCooK - My Account</title>


</head>
<body>
<div id="wrap">
</div>
<div class="center_content">
    <div class="left_content">
        <div class="title"><span class="title_icon"></span><spring:message code="myAccountTitle"/></div>
        <div class="feat_prod_box_details">
            <p class="details"><spring:message code="myAccountHelp"/></p>
            <div class="contact_form">
                <div class="form_subtitle"><spring:message code="myAccountInfo"/></div>
                <form:form name="register" method="post" modelAttribute="loginForm" action="/acecook/myAccount/login"
                           id="loginForm">
                    <div class="form_row">
                        <form:label path="email" class="contact"><strong><spring:message
                                code="mail"/>:</strong></form:label>
                        <form:input path="email" type="text" class="contact_input"/>
                    </div>
                    <div class="form_row">
                        <form:label path="password" class="contact"><strong><spring:message
                                code="pw"/>:</strong></form:label>
                        <form:input path="password" type="password" class="contact_input"/>
                    </div>
                    <div class="form_row">
                        <form:button type="submit" class="bouton" value="register">Login</form:button>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <!--end of left content-->
    <div class="right_content">
        <div class="languages_box">
            <spring:url var="localeFr" value="">
                <spring:param name="locale" value="fr"/>
            </spring:url>

            <spring:url var="localeEn" value="">
                <spring:param name="locale" value="en"/>
            </spring:url>
            <span class="red">Languages:</span>

            <a href="${localeEn}"><img src="images/gb.gif" alt="" border="0"/></a>
            <a href="${localeFr}"><img src="images/fr.gif" alt="" border="0"/></a></div>

        <div class="cart">
            <div class="title"><span class="title_icon"><img src="images/cart.gif" alt=""/></span><spring:message
                    code="cart"/></div>

            <div class="home_cart_content"><c:if test="${empty basket.products}"> 0
            </c:if>
                <c:if test="${not empty basket.products}"> ${basket.getNumberArticles()} x
                </c:if>
                <spring:message code="items"/> | <span class="red">TOTAL: ${basket.prixTotalAchats()} €</span>

            </div>
            <a href="#" class="view_cart"><a href="<spring:url value='/cart'/>"><spring:message
                    code="viewCart"/></a></a></div>
        <div class="title"><span
                class="title_icon"><!-- <img src="images/bullet3.gif" alt="" />--></span><spring:message
                code="aboutShop"/></div>
        <div class="about">
            <p><img src="images/about.gif" alt="" class="right"/> <spring:message code="shopAbout"/></p>
            <p>${client.nom} </p>
        </div>

        <div class="right_box">
            <div class="title"><!--<span class="title_icon"><img src="images/bullet5.gif" alt="" /></span>--></div>

            <div class="title"><!--<span class="title_iconn">  <img src="images/bullet66.gif" alt="" /></span>--></div>
            <ul class="list">

            </ul>
        </div>
    </div>
    <!--end of right content-->
    <div class="clear"></div>
</div>
<!--end of center content-->
<div class="footer">
    <div class="left_footer"><img src="" alt=""/><br/>
        <a href="http://csscreme.com"><img src="images/csscreme.gif" alt="" border="0"/></a></div>
</div>
</div>
</body>
</html>
