<div id="___dialogRefresh" title="Carregando informa��es">
	Carregando...
</div>

<% // Mensagens e di�logos essenciais para informa��es ao usu�rio %>
<c:if test="${not empty mensagem}">
	<div id="information-ui-dialog-message" title="Informa��o" class="ui-corner-all ui-widget-header">
		<p>
		    <span class="ui-icon ui-icon-info" style="float: left; margin: 0 7px 50px 0;"></span>
			${mensagem}.
		</p>
	</div>
	<script>
	$("#information-ui-dialog-message").dialog({
		modal:true
		});
	</script>
</c:if>
<c:if test="${not empty errors}">
	<div id="error-ui-dialog-message" title="Aten��o!" class="ui-state-error ui-corner-all ui-widget-header">
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
<div id="___dialogConfirmation" title="Confirma��o requerida">Tem certeza?</div>

<% // Se for um fornecedor, atualizar� as categorias Notifica��es e Pedidos %>
<c:if test="${userSession.user.userProfile.userProfileType eq 'EMPLOYEE' or userSession.user.userProfile.userProfileType eq 'MANAGER'}">
	<script>
	$(window).load(function(){	
		$("#___refreshPortal").click();		
	});
	</script>
</c:if>