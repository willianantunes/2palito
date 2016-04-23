<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<h2><fmt:message key="mensagem.introducao"/></h2>
				<p><fmt:message key="index.jsp.introducaoTexto"/></p>
			</div>		
			<div class="recursos-ajudaOpcoes corpo-novoPainel-esquerda">
				<h2><fmt:message key="mensagem.recursosRapidos"/></h2>
				<p><fmt:message key="index.jsp.recursosRapidosTexto"/></p>
			</div>
			<div class="recursos-notificacoes corpo-novoPainel-esquerda">
				<h2><fmt:message key="mensagem.notificacoes"/></h2>
				<p><fmt:message key="index.jsp.notificacoesTexto"/></p>
			</div>		
		</div>
	
		<div class="corpo-conteudo-painel-direita">
			<div class="painel-principal corpo-novoPainel-direita">
				<h2><strong><fmt:message key="site.nomeProduto"/></strong></h2>
				<p><fmt:message key="index.jsp.indexTextoP1"/></p>
				<p><fmt:message key="index.jsp.indexTextoP2"/></p>
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