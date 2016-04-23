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
				<h2>Administração dos usuários</h2>
				<p>Só é permitido para usuários com o nível de acesso <strong>administrador</strong>.</p>
			</div>
			<div class="recursos-ajudaOpcoes corpo-novoPainel-esquerda">
				<h2>Opções</h2>
				<ul>
					<li><a href="<c:url value="/usuarios/add" />"><span class="ui-icon ui-icon-circle-plus"></span><span>Adicionar usuário</span></a></li>					
				</ul>
			</div>					
		</div>
	
		<div class="corpo-conteudo-painel-direita">
			<div class="painel-principal corpo-novoPainel-direita">
				<h2><strong>Usuários do sistema</strong></h2>
				<c:if test="${not empty usuarioList}">	
					<table class="tabela-padrao">
						<tr>
							<th>Nome</th>
							<th>Login</th>
							<th>Tipo</th>
							<th>Cadastrado</th>
							<th>E-mail</th>
							<th>Opções</th>								
						</tr>										
						<c:forEach items="${usuarioList}" var="user">
							<tr>
								<td>${user.nome}</td>
								<td><a href="<c:url value="/usuarios/${user.id}" />">${user.login}</a></td>
								<td>${mf:capitalize(fn:toLowerCase(user.perfilUsuario.tipo))}</td>
								<td><joda:format value="${user.dataCadastro}" pattern="dd/MM/yyyy" /></td>
								<td title="${user.email}">${fn:substring(user.email, 0, 30) }...</td>
								<td><a class="___confirmLink" href="<c:url value="/usuarios/deletar/${user.id}" />">Excluir</a></td>										
							</tr>						
						</c:forEach>						
					</table>					
				</c:if>

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