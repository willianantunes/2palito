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
				<h2>Adicionar novo usuário</h2>
				<p>O tempo de atendimento padrão para todo usuário do sistema é 3 minutos.</p>
			</div>		
		</div>
	
		<div class="corpo-conteudo-painel-direita">
			<div class="painel-principal corpo-novoPainel-direita">
				<h2><strong>Detalhes do usuário</strong></h2>
				<form action="<c:url value="/usuarios/add" />" name="___frmFornecedor" id="___frmFornecedor" class="formulario-padrao" method="post">
					<label for="user.name">Nome:</label>
					<input type="text" name="user.name" class="validate[required] text-input" />
					<div class="clear"></div>
					
					<label for="user.email">E-mail:</label>
					<input type="text" name="user.email" class="validate[required,custom[email]] text-input" />	
					<div class="clear"></div>					
					
					<label for="user.userProfile.userProfileType">Tipo:</label>
					<select name="user.userProfile.userProfileType" class="validate[required]">
						<option value="">Escolha um tipo</option>
						<option value="ADMINISTRATOR">Administrador</option>
						<option value="CUSTOMER">Cliente</option>
						<option value="EMPLOYEE">Funcionário administrador</option>						
						<option value="EMPLOYEE_ADMINISTRATOR">Funcionário</option>
					</select>								
					<div class="clear"></div>		
					
					<label for="user.birthday">Nascimento:</label>
					<input type="text" name="user.birthday" class="validate[required,custom[date]] text-input" />	
					<div class="clear"></div>					
					
					<label for="usuario.perfilUsuario.tempoLimiteAtendimento">Tempo de atendimento:</label>
					<input type="text" name="usuario.perfilUsuario.tempoLimiteAtendimento" value="3" class="validate[required,custom[integer],max[20]]" />
					<div class="clear"></div>
					
					<label for="usuario.password">Senha:</label>
					<input type="password" name="usuario.password" id="usuarioPassword" value="" class="validate[required] text-input" />	
					<div class="clear"></div>
					
					<label for="passwordConfirmado">Confirmar senha:</label>
					<input type="password" name="passwordConfirmado" value="" class="validate[required,equals[usuarioPassword]] text-input"/>	
					<div class="clear"></div>																	
																			
					<div class="clear"></div>
					<input type="submit" value="Cadastrar" />
				</form>
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