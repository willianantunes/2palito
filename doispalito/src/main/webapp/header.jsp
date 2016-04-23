<div class="cabecalho">
	<div class="cabecalho-conteudo">
	
		<div class="logotipo-principal">
			<h1><a href="<c:url value="/" />" title="Aqlbras">Aqlbras</a></h1>
		</div>	
		
		<div class="painel-superior">
			<div class="cabecalho-conteudo-painel-superior-esquerdo">
				<div class="cabecalho-conteudo-painel-superior-esquerdo-informacoes-usuario">					
					<ul>
						<li>
							<img alt="Informações do usuário" src="<c:url value="/img/icone-usuario.png"/>" />
						</li>
						<li>
							<p><fmt:message key="mensagem.BemVindo"/> <strong>${userSession.user.name}</strong></p>
							<p><a href="<c:url value="/usuarios/${userSession.user.id}" />"><fmt:message key="mensagem.alterarCadastro"/></a> | <a href="<c:url value="/logout" />"><fmt:message key="mensagem.sair"/></a></p>
						</li>						
						<li>
							<img alt="Atualizar portal" src="<c:url value="/img/icone-atualizar.png"/>" />
						</li>						
						<li>
							<p><a id="___refreshPortal" href="#" data-url="<c:url value="/json/establishment/customerOrders/" />"><fmt:message key="mensagem.atualizar"/></a></p>
						</li>
					</ul>
				</div>
				
				<div class="cabecalho-conteudo-painel-superior-esquerdo-procurar">                        

				   <form id="___frmProcurar" name="___frmProcurar" action="#" method="get">
					   <div class="cabecalho-conteudo-painel-superior-esquerdo-procurar-conteudo">                        
						   <span>
								<input id="__inputBuscar" type="submit" value="<fmt:message key="mensagem.buscar"/>" />
						   </span>	   
						   <div>
							   <input type="text" name="SearchText" disabled="disabled" />
						   </div>                          
					   </div>
				   </form>
				
				</div>				
			</div>
			<div class="cabecalho-conteudo-painel-superior-direita">				
				<ul>
					<li>            
						<a href="#">
							<img alt="<fmt:message key="mensagem.brasil"/>" title="<fmt:message key="mensagem.portugues"/>" src="<c:url value="/img/icone-idioma-brasil.png"/>" />
						</a>
					</li>
					<li>
						<a href="#">
							<img alt="<fmt:message key="mensagem.inglesAmericano"/>" title="<fmt:message key="mensagem.eua"/>" src="<c:url value="/img/icone-idioma-eua.png"/>" />
						</a>
					</li>
				</ul>						
			</div>			
		</div>
		
		<div class="menu-principal">
			<ul class="menu-principal-pai">
				<li class="menu-principal-pai-item">
					<a href="#"><fmt:message key="mensagem.cardapio"/></a>				
					<ul class="menu-principal-pai">
						<li><a href="<c:url value="/products" />"><fmt:message key="mensagem.gerirItens"/></a></li>
						<li><a href="<c:url value="/products/add" />"><fmt:message key="mensagem.adicionarItem"/></a></li>
					</ul>								
				</li>
				<li class="menu-principal-pai-item categoria-notificacao">
					<a href="#"><fmt:message key="mensagem.notificacoes"/></a>
					<div class="circleBase circleType1 circleNotification"></div>
					<div class="menu-principal-dropdown" id="___notificacoes">
						<ul>
							<li>
								<p class="menu-one-item">Nenhuma notificação no sistema.</p>
							</li>							
						</ul>
					</div>				
				</li>
				<li class="menu-principal-pai-item categoria-pedidos">
					<a href="#"><fmt:message key="mensagem.pedidos"/></a>
					<div class="circleBase circleType1 circleRequests"></div>
					<div class="menu-principal-dropdown" id="___pedidos">
						<ul>
							<li>
								<p class="menu-one-item">Nenhuma pedido no sistema.</p>
							</li>							
						</ul>
					</div>
				</li>
				<li class="menu-principal-pai-item">
					<a href="#"><fmt:message key="mensagem.relatorios"/></a>
					<ul class="menu-principal-pai">
						<li><a href="#"><fmt:message key="mensagem.notificacoes"/></a></li>
						<li><a href="#"><fmt:message key="mensagem.pedidos"/></a></li>
						<li><a href="#"><fmt:message key="mensagem.bandejas"/></a></li>
					</ul>				
				</li>
				<li class="menu-principal-pai-item">
					<a href="#"><fmt:message key="mensagem.configuracoes"/></a>
					<ul class="menu-principal-pai">
						<c:if test="${userSession.user.userProfile.userProfileType eq 'ADMINISTRATOR'}">
							<li><a href="<c:url value="/usuarios" />">Gerir usuários</a></li>
							<li><a href="<c:url value="/fornecedores" />">Gerir fornecedores</a></li>
						</c:if>
						<li><a href="<c:url value="/usuarios/${userSession.user.id}" />">Alterar cadastro</a></li>
						<c:if test="${userSession.user.userProfile.userProfileType eq 'EMPLOYEE'}">
							<li><a href="<c:url value="/fornecedores/${usuarioSession.fornecedor.id}" />">Alterar cadastro da empresa</a></li>
						</c:if>					
					</ul>					
				</li>
			</ul>
		</div>
	
	</div>
</div><!-- Fim div #cabecalho -->