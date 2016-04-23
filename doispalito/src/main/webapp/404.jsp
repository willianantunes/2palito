<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@ include file="../../../header-options.jsp" %>

</head>
<body>

<noscript><fmt:message key="mensagem.erroJSNaoHabilitado"/></noscript>

<div class="corpo">
	<div class="corpo-conteudo">
		<div class="painel-login">
			<div class="logotipo-principal">
				<h1><a href="<c:url value="/" />" title="Aqlbras">Aqlbras</a></h1>
			</div>
			<div class="clear"></div>

			<h1 class="errorCodeTitle">404</h1>
			<p class="errorCodeMessage"><fmt:message key="mensagem.codigoStatusHTTP404"/>!</p>
		
		</div>	
	</div>
</div><!-- Fim div #corpo -->

</body>
</html>