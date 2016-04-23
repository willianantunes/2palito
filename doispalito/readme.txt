############################################ Projeto TCC

210513 1914
	• CRUD de produtos quase pronto.
	• É necessário arrumar diversos pontos afim de garantir a integridade e o nível de permissão entre funcionário e administrador.
	• Não atualizei o fornecedor na Session após ele mesmo alterar seus dados.
220513 0031
	• CRUD do negócio pronto: Usuário, Fornecedor e Produtos.
	• Início da lógica dos Pedidos. Falta arrumar o JSON e incluir AJAX de busca de pedidos em EM_ANALISE.
220513 1602
	• AJAX funcionando, porém apenas para efeito de teste.
220513 2243
	• AJAX funcionando para coleta de notificações, porém falta implementar a execução ao abrir o portal e em função do tempo configurado no perfil do fornecedor.
230513 1954
	• Dentro do pacote "util" criei uma classe para validação das imagens, entretanto não implementei nada sobre upload de imagens, por enquanto.
230513 2136
	• Páginas de erro para os códigos HTTP 403, 404, 500 e 503, os mais populares. Já inclui no web.xml.
	• Todos os diálogos para mensagens estão no arquivo dialogs-options.jsp.
	• Seria interessante ter um administrador dos funcionários para gerenciar o fornecedor e a inclusão/cadastro de novos funcionári.
	• Ainda falta a inclusão de funcionários num fornecedor. Uma ideia interessante seria o ADMINISTRADOR DO SISTEMA cadastrar os fornecedores e os seus respectivos administradores cadastrarem seus funcionários.		
Ponta serem feitos depois da realização do CORE/TCC do sistema
	• Quando um usuário alterar seus dados, se ele tirar o ID da URL ou colocar de outro usuário, ele poderá acessar e até alterar/deletar esse(s) usuário(s).
	• Colocar annotations nas classes para filtras QUEM REALMENTE PODE USAR.
	• Fornecer a possibilidade do administrador geral do sistema "agir" como um fornecedor afim de cadastrar itens, entre outros.
	• Mudar TUDO para inglês.
	• Mudar o AbstractEntity e GenericBusiness para ABSTRACT na assinatura de suas classes.
	• Colocar mais um estado/tipo para o pedido, algo como "rejeitado". Assim poderemos saber quando um pedido foi cancelado (cliente) ou rejeitado (fornecedor). 

############################################ Projeto Comercial
###################### Pontos importantes

- Dentro de dialogs-options.jsp existe uma chamada para atualizar os pedidos do fornecedor

###################### Versões

0.5
	• Troca dos STATUS do pedido sendo feito de maneira plena pelo usuário Marty McFly. Ainda falta implementar a parte dos detalhes do CustomerOrder para visualização.
