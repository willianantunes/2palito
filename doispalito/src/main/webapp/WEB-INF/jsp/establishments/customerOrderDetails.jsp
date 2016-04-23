<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/funcoes.tld" prefix="mf" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@ include file="../../../header-options.jsp" %>

</head>
<body>
<noscript><fmt:message key="mensagem.erroJSNaoHabilitado"/></noscript>

<div class="painel-principal" style="margin: 20px; padding: 20px">
	<h2><strong>Detalhes do pedido</strong></h2><br/>
	
	<h3><strong>Cliente: </strong>${customerOrder.user.name} </h3>
	<h3><strong>Pedido feito em: </strong><joda:format value="${customerOrder.registerDate}" pattern="dd/MM/yyyy HH:mm:ss" /></h3>
	<fmt:setLocale value="pt-BR" />
	<h3><strong>Valot total: </strong><fmt:formatNumber value="${_totalPrice}" type="currency" /> </h3><br/>
	
	<c:if test="${not empty customerOrder.productItems}">	
		<table class="tabela-padrao">
			<tr>
				<th colspan="2">Nome</th>
				<th colspan="1">Preço</th>
				<th colspan="1">Quantidade</th>
				<th colspan="1">Descrição</th>								
			</tr>										
			<c:forEach items="${customerOrder.productItems}" var="product">
				<tr>
					<td>			
						<img alt="${product.name}" src="<c:url value="${product.imageLink}"/>" />
					</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
					<td>${product.description}</td>													
				</tr>						
			</c:forEach>						
		</table>					
	</c:if>
</div>

</body>
</html>