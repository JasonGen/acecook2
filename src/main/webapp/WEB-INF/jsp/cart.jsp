<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>AceCooK - Cart</title>


</head>
<body>

  <div class="center_content">
    <div class="left_content">
      <div class="title"><span class="title_icon"></span><spring:message code="cartTitle"/></div>
      <div class="feat_prod_box_details">
        <table class="cart_table">
          <tr class="cart_title">
            <td>Product name</td>
            <td>Unit price</td>
            <td>Qty</td>
            <td>Total</td>
          </tr>

          <c:forEach items = "${basket.products}" var = "product">

            <tr>


              <td>${product.value.prixReel} €</td>
              <td>${product.value.nombrePieces}</td>
              <td>${product.value.prixReel * product.value.nombrePieces} €</td>
            </tr>
          </c:forEach>
          <tr>
            <td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
            <td> ${basket.prixTotalAchats()} €</td>
          </tr>
        </table>

        <a href="#" class="continue">&lt; </a> <a href="<spring:url value = '/cart/confirmOrder'/>"><spring:message code="confirmOrder"/> &gt;</a> </div>

      <div class="clear"></div>
    </div>
    <!--end of left content-->
    <div class="right_content">
      <div class="languages_box">
        <spring:url var="localeFr" value="">
          <spring:param name="locale" value="fr" />
        </spring:url>

        <spring:url var="localeEn" value="">
          <spring:param name="locale" value="en" />
        </spring:url>
        <span class="red">Languages:</span>

        <a href="${localeEn}"><img src="images/gb.gif" alt="" border="0" /></a>
        <a href="${localeFr}"><img src="images/fr.gif" alt="" border="0" /></a>  </div>
      <div class="cart">
        <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" /></span><spring:message code="cart"/></div>
        <div class="home_cart_content"> <c:if test ="${empty basket.products}"> 0
        </c:if>
          <c:if test = "${not empty basket.products}"> ${basket.getNumberArticles()} x
          </c:if>
          <spring:message code="items"/> | <span class="red">TOTAL: ${basket.prixTotalAchats()} €</span>

        </div>
        <a href="#" class="view_cart"><a href="<spring:url value='/cart'/>"><spring:message code="viewCart"/></a></a> </div>
      <div class="title"><span class="title_icon"></span><spring:message code="aboutShop"/></div>
      <div class="about">
        <p> <img src="images/about.gif" alt="" class="right" /> <spring:message code="shopAbout"/> </p>
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
    <div class="left_footer"><img src="" alt="" /><br />
      <a href="http://csscreme.com"><img src="images/csscreme.gif" alt="" border="0" /></a></div>
  </div>

</body>
</html>
