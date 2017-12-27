<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>AceCooK - Register</title>
    <!--
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
              <link rel="stylesheet" href="/resources/demos/style.css">
            <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
              <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
              <script>
                  $( function() {
                        $( "#datepicker" ).datepicker();
                  } );
            </script>-->
</head>
<body>

<div class="center_content">
    <div class="left_content">
        <div class="title"><span class="title_icon"></span><spring:message code="registerTitle"/></div>
        <div class="feat_prod_box_details">
            <p class="details"></p>
            <div class="contact_form">
                <div class="form_subtitle"><spring:message code="registerInfo"/></div>

                <form:form id="userFormInscription" method="POST" action="/acecook/register/createUser"
                           modelAttribute="userForm">
                    <div class="form_row">
                        <form:label path="email" class="contact"> <strong><spring:message
                                code="mail"/>:</strong></form:label>
                        <form:input path="email" type="text" class="contact_input"/>
                        <form:errors path="email"/>
                    </div>
                    <div class="form_row">
                        <form:label path="motDePasse" class="contact"> <strong><spring:message
                                code="pw"/>:</strong></form:label>
                        <form:input path="motDePasse" type="password" class="contact_input"/>
                        <form:errors path="motDePasse"/>
                    </div>
                    <div class="form_row">
                        <form:label path="confirmationMotDePasse" class="contact"><strong> <spring:message
                                code="confirmPw"/>:</strong></form:label>
                        <form:input path="confirmationMotDePasse" type="password" class="contact_input"/>
                        <form:errors path="confirmationMotDePasse"/>
                    </div>
                    <div class="form_row">
                        <form:label path="nom" class="contact"><strong><spring:message
                                code="lastName"/>:</strong></form:label>
                        <form:input path="nom" type="text" class="contact_input"/>
                        <form:errors path="nom"/>
                    </div>
                    <div class="form_row">
                        <form:label path="prenom" class="contact"><strong><spring:message
                                code="firstName"/>:</strong></form:label>
                        <form:input path="prenom" type="text" class="contact_input"/>
                        <form:errors path="prenom"/>
                    </div>
                    <div class="form_row">
                        <form:label path="dateNaiss" class="contact"><strong><spring:message code="birthday"/>:</strong></form:label>
                        <form:input type="date" path="dateNaiss" id="datepicker" class="contact_input"/>
                        <form:errors path="dateNaiss"/>
                    </div>
                    <div class="form_row">
                        <form:label path="numTel" class="contact"><strong><spring:message code="phoneNumber"/>:</strong></form:label>
                        <form:input path="numTel" type="text" class="contact_input"/>
                        <form:errors path="numTel"/>
                    </div>
                    <div class="form_row">
                        <form:label path="numeroRue" class="contact"><strong><spring:message
                                code="streetNumber"/>:</strong></form:label>
                        <form:input path="numeroRue" type="text" class="contact_input"/>
                        <form:errors path="numeroRue"/>
                    </div>
                    <div class="form_row">
                        <form:label path="rue" class="contact"><strong><spring:message
                                code="street"/>:</strong></form:label>
                        <form:input path="rue" type="text" class="contact_input"/>
                        <form:errors path="rue"/>
                    </div>
                    <div class="form_row">
                        <form:label path="ville" class="contact"><strong><spring:message
                                code="town"/>:</strong></form:label>
                        <form:input path="ville" type="text" class="contact_input"/>
                        <form:errors path="ville"/>
                    </div>
                    <div class="form_row">
                        <form:label path="codePostal" class="contact"><strong><spring:message
                                code="postalCode"/>:</strong></form:label>
                        <form:input path="codePostal" type="text" class="contact_input"/>
                        <form:errors path="codePostal"/>
                    </div>

                    <div class="form_row">
                        <form:button type="submit" class="bouton" value="register"><spring:message code="btnRegister"/></form:button>
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
            <a href="#" class="view_cart"><a href="<spring:url value='/cart'/>"><spring:message code="viewCart"/></a>
        </div>
        <div class="title"><span class="title_icon"></span><spring:message code="aboutShop"/></div>
        <div class="about">
            <p><img src="images/about.gif" alt="" class="right"/> <spring:message code="shopAbout"/></p>
        </div>
        <div class="right_box">
            <div class="title"><span class="title_icon"></span></div>

        </div>
    </div>
    <!--end of right content-->
    <div class="clear"></div>
</div>
<!--end of center content-->
<div class="footer">

    <a href="http://csscreme.com"><img src="images/csscreme.gif" alt="" border="0"/></a></div>
</div>

</body>
</html>
