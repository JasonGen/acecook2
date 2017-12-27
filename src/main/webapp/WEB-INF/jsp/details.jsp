<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>AceCooK - Details</title>
</head>
<body>

<div class="center_content">
    <div class="left_content">
        <div class="title"><span class="title_icon"></span>Product name</div>
        <div class="feat_prod_box_details">


            <div class="prod_det_box">

                <div class="box_center">
                    <div class="prod_title"><spring:message code="detailsTitle"/></div>
                    <p class="details"></p>
                    <div class="price"><strong><spring:message code="price"/>:</strong> <span
                            class="red"><fmt:formatNumber value="${materiel.prix}" type="currency"
                                                          currencySymbol="€"/></span></div>
                    <div>
                        <%--<h1><spring:message code="articleName"/></h1>--%>
                        <img src="<spring:url value = '${materiel.photo}' />" alt="Une image ici, doit être">
                        <p><b>Reste en stock : </b> ${materiel.quantiteStock}</p>
                        <%--<spring:message code ="description" />--%>

                    </div>
                    <form:form
                            method="POST"
                            action="/acecook/details/addCart"
                            modelAttribute="ligneCommande">
                        <form:input id="qtyToChoose" path="nombrePieces" type="number" max="${materiel.quantiteStock}"
                                    min="1" value="1"/>
                        <form:button type="submit"><spring:message code="addToCart"/><img src="images/order_now.gif"
                                                                                          alt=""
                                                                                          border="0"/></a></form:button>
                        <%--<form:button type="submit"><a class="more"><img src="images/order_now.gif" alt="" border="0" /></a></form:button>--%>
                        <%--<form action ="/details/${materiel.idMateriel}" method="post" id="orderAction" modelAttribute="ligneCommande">--%>
                        <%--&lt;%&ndash;<form:input path="prixReel" disabled="true"/>&ndash;%&gt;--%>
                        <%--<form:input path="nombrePieces" type="number" />--%>
                        <%--<form:button type="submit"><a class="more"><img src="images/order_now.gif" alt="" border="0" /></a></form:button>--%>
                        <%--</form>--%>
                    </form:form>
                    <div class="clear"></div>
                </div>
                <div class="box_bottom"></div>
            </div>
            <div class="clear"></div>
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
    <div class="left_footer"><img src="" alt=""/><br/>
        <a href="http://csscreme.com"><img src="images/csscreme.gif" alt="" border="0"/></a></div>
</div>

</body>
</html>
<!--
<script type="text/javascript">

var tabber1 = new Yetii({
id: 'demo'
});

</script>-->

