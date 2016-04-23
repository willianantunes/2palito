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
				<h2>Adicionar novo produto</h2>
				<p>A descrição do produto é de suma importância pois o cliente visualizará caso deseje em seu dispositivo móvel.</p>
			</div>		
		</div>
	
		<div class="corpo-conteudo-painel-direita">
			<div class="painel-principal corpo-novoPainel-direita">
				<h2><strong>Detalhes do produto</strong></h2>
				<form action="<c:url value="/products/add" />" name="___frmProdutos" id="___frmProdutos" class="formulario-padrao" method="post">
					<label for="product.nome">Nome:</label>
					<input type="text" name="produto.nome" value="" class="validate[required] text-input" />
					<div class="clear"></div>

					<label for="produto.descricao">Descrição:</label>
					<textarea rows="" cols="" name="produto.descricao"></textarea>
					<div class="clear"></div>
					
					<label for="produto.ativo">Ativo:</label>
					<select name="produto.ativo" class="validate[required]">
						<option value="">Escolha uma opção</option>
						<option value="1" selected>Ativado</option>
						<option value="0">Desativado</option>
					</select>								
					<div class="clear"></div>					
					
					<label for="produto.preco">Preço:</label>
					<input type="text" name="produto.preco" class="validate[required,custom[number]]" />	
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