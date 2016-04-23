package br.com.aqlbras.doispalito.portal.model;

/**
 * <h1>ENUM que representa os estados de um pedido.</h1>
 * <ul>
 * <li><strong>Em análise:</strong> Quando o pedido foi enviado para o fornecedor;</li>
 * <li><strong>Cancelado:</strong> Quando o pedido foi rejeitado pelo fornecedor;</li>
 * <li><strong>Esperando pagamento:</strong> Quando o pedido foi aceitado pelo fornecedor, porém ele depende do pagamento do cliente para, então, passar para o próximo estado;</li>
 * <li><strong>Em produção:</strong> Após o fornecedor ter dado aceitado e dado baixa, o pedido fica em produção e o cliente fica esperando uma mensagem de confirmação sinalizando a finalização;</li>
 * <li><strong>Feito:</strong> Neste estado o cliente receberá um aviso informando sobre a conclusão do pedido.</li>
 * </ul>
 * @author Willian Antunes
 * @version 1.0.0
 * 
 */

public enum CustomerOrderStatus 
{
	IN_ANALYSIS, CANCELLED, AWAITING_PAYMENT, IN_PRODUCTION, DONE;
}