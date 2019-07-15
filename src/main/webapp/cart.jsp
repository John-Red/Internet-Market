<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<html lang="zxx">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>art</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
  <link rel="stylesheet" href="src/main/webapp/WEB-INF/css/bootstrap.min.css">
	<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
  <link rel="stylesheet" href="css/cart_style.css">
  <script type="text/javascript" src="js/button_test.js"></script>
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
                              <th scope="col">Product</th>
                              <th scope="col">Price</th>
                              <th scope="col">Quantity</th>
                              <th scope="col">Total</th>
                              <th scope="col">Remove</th>
                          </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${cartList}" var="cart" >
                          <tr>
                              <td>
                                  <div class="media">
                                      <div class="d-flex">
                                          <img src="img/cart/cart1.png" alt="">
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
                                      <input type="text" name="qty" id="sst1" maxlength="12" value="${cart.itemOrdersQuantity}" title="Quantity:"
                                          class="input-text qty">
                                      <button onclick="var result = document.getElementById('sst1'); var sst1 = result.value; if( !isNaN( sst1 )) result.value++;return false;"
                                          class="increase items-count" type="button"><i class="fa fa-angle-up" aria-hidden="true"></i></button>
                                      <button onclick="var result = document.getElementById('sst1'); var sst1 = result.value; if( !isNaN( sst1 ) &amp;&amp; sst1 > 0 ) result.value--;return false;"
                                          class="reduced items-count" type="button"><i class="fa fa-angle-down" aria-hidden="true"></i></button>
                                  </div>
                              </td>
                              <td>
                                  <h5>${cart.itemsPrice}</h5>
                              </td>
                              <td>
                                  <a href="#" class="delete_button" ><i class="fa fa-trash" aria-hidden="true"></i></a>
                              </td>
                          </tr>
                          </c:forEach>
							  <tr class="bottom_button">
                              <td>
                               <button onclick="javascript:MyFunction();" class="button"<i class="fa fa-angle-up" aria-hidden="true"></i>Update Cart</button>

                              </td>

                              </td>
                              <td>

                              </td>
                              <td>
                                  <h5>Subtotal</h5>
                              </td>
                              <td>
                                  <h5>$2160.00</h5>
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
                                      <a class="gray_btn" href="/">Continue Shopping</a>
                                      <a class="primary-btn ml-2" href="#">Proceed to checkout</a>
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
</body>
</html>