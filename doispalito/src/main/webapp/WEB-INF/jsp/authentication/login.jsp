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

<c:if test="${not empty errors}">
	<div id="error-ui-dialog-message" title="Atenção!" class="ui-state-error ui-corner-all ui-widget-header">
		<p>
		    <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 50px 0;"></span>
			${errors[0].message}.
		</p>
	</div>
	<script>
	$("#error-ui-dialog-message").dialog({
		modal:true
		});
	</script>
</c:if>

<div class="corpo">
	<div class="corpo-conteudo">
		<div class="painel-login">
			<div class="logotipo-principal">
				<h1><a href="http://www.aqlbras.com.br" title="Aqlbras">Aqlbras</a></h1>
			</div>
			<div class="clear"></div>
			<form name="___frmLogin" id="___frmLogin" action="<c:url value="/login" />" method="post">
				<fieldset>
					<legend><fmt:message key="login.jsp.___frmLogin.legend"/></legend>
					
					<label for="email"><fmt:message key="login.jsp.___frmLogin.usuarioLogin"/></label><br />
					<input name="email" type="text" class="validate[required] text-input" /><br />
					
					<label for="password"><fmt:message key="login.jsp.___frmLogin.usuarioPassword"/></label><br />
					<input name="password" type="password" class="validate[required] text-input" /><br />									
					
				</fieldset>
				<input type="submit" value="Entrar" />
			</form>
			<br />
			<p><a href="#"><fmt:message key="login.jsp.link.recuperarSenha"/></a></p>			
			<p><a href="#"><fmt:message key="login.jsp.link.Registrar"/></a></p>			
		</div>
	
	</div>
</div><!-- Fim div #corpo -->

</body>
</html>