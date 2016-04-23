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

<%@ include file="../../../header.jsp" %>
	
<hr />

<div class="corpo">
	<div class="corpo-conteudo">
	
		<div class="corpo-conteudo-painel-esquerdo">
			<div class="recursos-introducao corpo-novoPainel-esquerda">
				<h2>Administração dos produtos</h2>
				<p>Lorem ipsum dolor sit amet.</p>
			</div>
			<div class="recursos-ajudaOpcoes corpo-novoPainel-esquerda">
				<h2>Opções</h2>
				<ul>
					<li><a href="<c:url value="/products/add" />"><span class="ui-icon ui-icon-circle-plus"></span><span>Adicionar produto</span></a></li>					
				</ul>
			</div>					
		</div>
	
		<div class="corpo-conteudo-painel-direita">
			<div class="painel-principal corpo-novoPainel-direita">
				<h2><strong>Produtos do cardápio</strong></h2>
				<c:choose>
					<c:when test="${not empty productList}">
						<table class="tabela-padrao">
							<tr>
								<th>Nome</th>
								<th>Descricao</th>
								<th>Ativo</th>
								<th>Cadastrado</th>
								<th>Preço</th>
								<th>Opções</th>									
							</tr>										
							<c:forEach items="${productList}" var="prod">
								<tr>
									<td><a href="<c:url value="/products/${prod.id}" />">${prod.name}</a></td>
									<td>${prod.description}</td>
									<td>${prod.active eq "true"? "Sim" : "Não"}</td>
									<td><joda:format value="${prod.registerDate}" pattern="dd/MM/yyyy" /></td>
									<td>${prod.price}</td>
									<td><a class="___confirmLink" href="<c:url value="/products/delete/${prod.id}" />">Excluir</a></td>										
								</tr>						
							</c:forEach>						
						</table>					
					</c:when>
					<c:otherwise>
					<p>Nenhum produto cadastrado.</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	
	</div>
</div><!-- Fim div #corpo -->
	
<hr />

<%@ include file="../../../dialogs-options.jsp" %>

<hr />

<%@ include file="../../../footer.jsp" %>

</body>
</html>