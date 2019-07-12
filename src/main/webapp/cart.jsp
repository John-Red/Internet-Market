<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<html lang="zxx">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Aroma Shop - Cart</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
  <link rel="stylesheet" href="src/main/webapp/WEB-INF/css/bootstrap.min.css">
	<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
  <link rel="stylesheet" href="css/cart_style.css">
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
                          <tr>
                              <td>
                                  <div class="media">
                                      <div class="d-flex">
                                          <img src="img/cart/cart1.png" alt="">
                                      </div>
                                      <div class="media-body">
                                          <p>Minimalistic shop for multipurpose use</p>
                                      </div>
                                  </div>
                              </td>
                              <td>
                                  <h5>$360.00</h5>
                              </td>
                              <td>
                                  <div class="product_count">
                                      <input type="text" name="qty" id="sst1" maxlength="12" value="1" title="Quantity:"
                                          class="input-text qty">
                                      <button onclick="var result = document.getElementById('sst1'); var sst1 = result.value; if( !isNaN( sst1 )) result.value++;return false;"
                                          class="increase items-count" type="button"><i class="fa fa-angle-up" aria-hidden="true"></i></button>
                                      <button onclick="var result = document.getElementById('sst1'); var sst1 = result.value; if( !isNaN( sst1 ) &amp;&amp; sst1 > 0 ) result.value--;return false;"
                                          class="reduced items-count" type="button"><i class="fa fa-angle-down" aria-hidden="true"></i></button>
                                  </div>
                              </td>
                              <td>
                                  <h5>$720.00</h5>
                              </td>
                              <td>
                                  <a href="#" class="delete_button" ><i class="fa fa-trash" aria-hidden="true"></i></a>
                              </td>
                          </tr>
                          <tr>
                              <td>
                                  <div class="media">
                                      <div class="d-flex">
                                          <img src="img/cart/cart2.png" alt="">
                                      </div>
                                      <div class="media-body">
                                          <p>Minimalistic shop for multipurpose use</p>
                                      </div>
                                  </div>
                              </td>
                              <td>
                                  <h5>$360.00</h5>
                              </td>
                              <td>
                                  <div class="product_count">
                                      <input type="text" name="qty2" id="sst2" maxlength="12" value="1" title="Quantity:"
                                          class="input-text qty2">
                                      <button onclick="var result = document.getElementById('sst2'); var sst2 = result.value; if( !isNaN( sst2 )) result.value++;return false;"
                                          class="increase items-count" type="button"><i class="fa fa-angle-up" aria-hidden="true"></i></button>
                                      <button onclick="var result = document.getElementById('sst2'); var sst2 = result.value; if( !isNaN( sst2 ) &amp;&amp; sst2 > 0 ) result.value--;return false;"
                                          class="reduced items-count" type="button"><i class="fa fa-angle-down" aria-hidden="true"></i></button>
                                  </div>
                              </td>
                              <td>
                                  <h5>$720.00</h5>
                              </td>
                              <td>
                                                                <a href="#" class="delete_button" ><i class="fa fa-trash" aria-hidden="true"></i></a>
                                                            </td>
                          </tr>
                          <tr>
                              <td>
                                  <div class="media">
                                      <div class="d-flex">
                                          <img src="img/cart/cart3.png" alt="">
                                      </div>
                                      <div class="media-body">
                                          <p>Minimalistic shop for multipurpose use</p>
                                      </div>
                                  </div>
                              </td>
                              <td>
                                  <h5>$360.00</h5>
                              </td>
                              <td>
                                  <div class="product_count">
                                      <input type="text" name="qty" id="sst3" maxlength="12" value="1" title="Quantity:"
                                          class="input-text qty">
                                      <button onclick="var result = document.getElementById('sst3'); var sst3 = result.value; if( !isNaN( sst3 )) result.value++;return false;"
                                          class="increase items-count" type="button"><i class="fa fa-angle-up" aria-hidden="true"></i></button>
                                      <button onclick="var result = document.getElementById('sst3'); var sst3 = result.value; if( !isNaN( sst3 ) &amp;&amp; sst3 > 0 ) result.value--;return false;"
                                          class="reduced items-count" type="button"><i class="fa fa-angle-down" aria-hidden="true"></i></button>
                                  </div>
                              </td>
                              <td>
                                  <h5>$720.00</h5>
                              </td>
                              <td>
                                                                <a href="#" class="delete_button" ><i class="fa fa-trash" aria-hidden="true"></i></a>
                                                            </td>
                          </tr>
							  <tr class="bottom_button">
                              <td>
                                  <a class="button" href="#">Update Cart</a>
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