############################################ Projeto TCC

210513 1914
	� CRUD de produtos quase pronto.
	� � necess�rio arrumar diversos pontos afim de garantir a integridade e o n�vel de permiss�o entre funcion�rio e administrador.
	� N�o atualizei o fornecedor na Session ap�s ele mesmo alterar seus dados.
220513 0031
	� CRUD do neg�cio pronto: Usu�rio, Fornecedor e Produtos.
	� In�cio da l�gica dos Pedidos. Falta arrumar o JSON e incluir AJAX de busca de pedidos em EM_ANALISE.
220513 1602
	� AJAX funcionando, por�m apenas para efeito de teste.
220513 2243
	� AJAX funcionando para coleta de notifica��es, por�m falta implementar a execu��o ao abrir o portal e em fun��o do tempo configurado no perfil do fornecedor.
230513 1954
	� Dentro do pacote "util" criei uma classe para valida��o das imagens, entretanto n�o implementei nada sobre upload de imagens, por enquanto.
230513 2136
	� P�ginas de erro para os c�digos HTTP 403, 404, 500 e 503, os mais populares. J� inclui no web.xml.
	� Todos os di�logos para mensagens est�o no arquivo dialogs-options.jsp.
	� Seria interessante ter um administrador dos funcion�rios para gerenciar o fornecedor e a inclus�o/cadastro de novos funcion�ri.
	� Ainda falta a inclus�o de funcion�rios num fornecedor. Uma ideia interessante seria o ADMINISTRADOR DO SISTEMA cadastrar os fornecedores e os seus respectivos administradores cadastrarem seus funcion�rios.		
Ponta serem feitos depois da realiza��o do CORE/TCC do sistema
	� Quando um usu�rio alterar seus dados, se ele tirar o ID da URL ou colocar de outro usu�rio, ele poder� acessar e at� alterar/deletar esse(s) usu�rio(s).
	� Colocar annotations nas classes para filtras QUEM REALMENTE PODE USAR.
	� Fornecer a possibilidade do administrador geral do sistema "agir" como um fornecedor afim de cadastrar itens, entre outros.
	� Mudar TUDO para ingl�s.
	� Mudar o AbstractEntity e GenericBusiness para ABSTRACT na assinatura de suas classes.
	� Colocar mais um estado/tipo para o pedido, algo como "rejeitado". Assim poderemos saber quando um pedido foi cancelado (cliente) ou rejeitado (fornecedor). 

############################################ Projeto Comercial
###################### Pontos importantes

- Dentro de dialogs-options.jsp existe uma chamada para atualizar os pedidos do fornecedor

###################### Vers�es

0.5
	� Troca dos STATUS do pedido sendo feito de maneira plena pelo usu�rio Marty McFly. Ainda falta implementar a parte dos detalhes do CustomerOrder para visualiza��o.
