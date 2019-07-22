<jsp:include page="header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="cart" />

<html lang="${param.lang}">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>art</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
  <link rel="stylesheet" href="src/main/webapp/WEB-INF/css/bootstrap.min.css">
	<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
  <link rel="stylesheet" href="css/cart_style.css">
  <script language="javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body>
  <!--================Cart Area =================-->
  <section class="cart_area">
      <div class="container">
          <div class="cart_inner">
              <div class="table-responsive">
                  <table class="table">
                      <thead>
                          <tr>
                              <th scope="col"><fmt:message key="label.product" /></th>
                              <th scope="col"><fmt:message key="label.Price" /></th>
                              <th scope="col"><fmt:message key="label.Quantity" /></th>
                              <th scope="col"><fmt:message key="label.Total" /></th>
                              <th scope="col"><fmt:message key="label.Remove" /></th>
                          </tr>
                      </thead>
                      <tbody>

                      <c:forEach items="${cartList}" var="cart" >
                          <tr>
                          <form method="post">
                              <td>
                                  <div class="media">
                                      <div class="d-flex">
                                          <img src="./img/${cart.getItemsImage()}" class="img" alt="">
                                      </div>
                                      <div class="media-body">
                                          <p>${cart.itemsName}</p>
                                      </div>
                                  </div>
                              </td>
                              <td>
                                  <h5>${cart.itemsPrice}</h5>
                              </td>
                              <td>

                                  <div class="product_count">

                                      <input type="text" id="ss${cart.getItemOrderId()}" maxlength="12" value="${cart.itemOrdersQuantity}" title="Quantity:"
                                          class="input-text qty" readonly>

                                      <button class="increase items-count" name="incrementQuantity" value="${cart.getItemOrderId()}" ><i class="fa fa-angle-up" aria-hidden="true"></i></button>


                                      <button class="reduced items-count" name="decrementQuantity" value="${cart.getItemOrderId()}"><i class="fa fa-angle-down" aria-hidden="true"></i></button>

                                  </div>

                              </td>
                              <td>
                                  <h5><div>${cart.getTotalPrice()}</div></h5>
                              </td>

                              <td>
                                   <button onclick="" name="delete" value="${cart.getItemOrderId()}" class="delete_button" ><i class="fa fa-trash" aria-hidden="true"></i></button>
                              </td>
                              </form>
                          </tr>
                          </c:forEach>

							  <tr class="bottom_button">
                              <td>
                              <a class="gray_btn" href="/cart"><fmt:message key="label.UpdateCart" /></a>

                              </td>

                              </td>
                              <td>

                              </td>
                              <td>
                                  <h5> <fmt:message key="label.GrandTotal"/></h5>
                              </td>
                              <td>
                                  <h5>${Subtotal}</h5>
                              </td>
                              <td>

                                                            </td>
                          </tr>

                          <tr class="out_button_area">

                              <td class="d-none-l">
                              </td>
                              <td class="">

                              </td>
                              <td>

                              </td>
                              <td>
                                  <div class="checkout_btn_inner d-flex align-items-center">
                                  <t> "UserId now is" + "${userId}" </t>
                                      <a class="gray_btn" href="/items">Continue Shopping</a>
                                      <form method="post">
                                      <button onclick="" name="proceedToCheckout" value="${userId}" >Proceed to checkout</button>
                                      </form>

                                  </div>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </section>
  <!--================End Cart Area =================-->
  <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>