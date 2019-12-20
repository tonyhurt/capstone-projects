<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="calculator">
<h1>Solar System Geek Gift Shop</h1>
<table> 

<c:forEach items = "${ productList }" var = "product" >
<tr>
<td> <img src = "img/${ product.imageName }" alt="productImage"/></td> 
<td> <h4>${product.name }</h4><h5>${product.price }</h5></td></tr>
</c:forEach>

</table></div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />