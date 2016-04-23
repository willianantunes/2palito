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
				<h2>Detalhe/edição dos dados</h2>
				<p>Caso deseje editar seus dados, porém mantendo o antigo o password, apenas deixe os dois campos referentes a esse campo em branco.</p>
			</div>		
		</div>
	
		<div class="corpo-conteudo-painel-direita">
			<div class="painel-principal corpo-novoPainel-direita">
				<h2><strong>Detalhes do usuário</strong></h2>
				<form action="<c:url value="/usuarios" />" name="___frmUsuario" id="___frmUsuario" class="formulario-padrao" method="post">
					<label for="usuario.nome">Nome:</label>
					<input type="text" name="usuario.nome" value="${user.name}" class="validate[required] text-input" />
					<div class="clear"></div>
					
					<!-- 
					<label for="usuario.perfilUsuario.tipo">Tipo:</label>
					<select name="usuario.perfilUsuario.tipo" class="validate[required]" ${userSession.user.userProfile.tipo eq 'ADMINISTRATOR'? "" : "disabled='disabled'"} >
						<option value="">Escolha um tipo</option>
						<option value="ADMINISTRADOR" ${usuario.perfilUsuario.tipo eq "ADMINISTRADOR"? "selected" : ""}>Administrador</option>
						<option value="CLIENTE" ${usuario.perfilUsuario.tipo eq "CLIENTE"? "selected" : ""}>Cliente</option>
						<option value="FUNCIONARIO" ${usuario.perfilUsuario.tipo eq "FUNCIONARIO"? "selected" : ""}>Funcionario</option>
					</select>								
					<div class="clear"></div> -->
					
					<label for="usuario.email">E-mail:</label>
					<input type="text" name="usuario.email" value="${user.email}" class="validate[required,custom[email]] text-input" />	
					<div class="clear"></div>
					
					<label for="usuario.dataCadastro">Cadastrado:</label>
					<input type="text" disabled="disabled" name="usuario.dataCadastro" value="<joda:format value="${user.registerDate}" pattern="dd/MM/yyyy" />" class="validate[required,custom[date]] text-input" />	
					<div class="clear"></div>
					
					<label for="usuario.dataNascimento">Nascimento:</label>
					<input type="text" name="usuario.dataNascimento" value="<joda:format value="${user.birthday}" pattern="dd/MM/yyyy" />" class="validate[required,custom[date]] text-input" />	
					<div class="clear"></div>					
					
					<label for="usuario.perfilUsuario.tempoLimiteAtendimento">Tempo de atendimento:</label>
					<input type="text" name="usuario.perfilUsuario.tempoLimiteAtendimento" value="${user.userProfile.timeOutTreatment}" class="validate[required,custom[integer],max[20]]" />
					<div class="clear"></div>
					
					<label for="usuario.password">Senha:</label>
					<input type="password" name="usuario.password" id="usuarioPassword" value="" />	
					<div class="clear"></div>
					
					<label for="passwordConfirmado">Confirmar senha:</label>
					<input type="password" name="passwordConfirmado" value="" class="validate[condRequired[usuarioPassword],equals[usuarioPassword]] text-input"/>	
					<div class="clear"></div>																	
																			
					<input type="hidden" name="usuario.perfilUsuario.id" value="${user.userProfile.id}"/>
					<input type="hidden" name="usuario.id" value="${user.id}"/>
					<input type="hidden" name="_method" value="put"/>
					<div class="clear"></div>
					<input type="submit" value="Alterar" />
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