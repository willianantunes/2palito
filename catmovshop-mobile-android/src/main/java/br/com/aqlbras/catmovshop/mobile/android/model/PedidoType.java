package br.com.aqlbras.catmovshop.mobile.android.model;

/**
 * ENUM que representa os estados de um pedido.
 * 	Em análise: Quando o pedido foi enviado para o fornecedor;
 * 	Cancelado: Quando o pedido foi rejeitado pelo fornecedor;
 * 	Esperando pagamento: Quando o pedido foi aceitado pelo fornecedor, porém ele depende do pagamento do cliente para, então, passar para o próximo estado;
 * 	Em produção: Após o fornecedor ter dado aceitado e dado baixa, o pedido fica em produção e o cliente fica esperando uma mensagem de confirmação sinalizando a finalização;
 * 	Feito: Neste estado o cliente receberá um aviso informando sobre a conclusão do pedido.
 * @author Antunes
 *
 */

public enum PedidoType
{	
	EM_ANALISE, CANCELADO, ESPERANDO_PAGAMENTO, EM_PRODUCAO, FEITO;
}
