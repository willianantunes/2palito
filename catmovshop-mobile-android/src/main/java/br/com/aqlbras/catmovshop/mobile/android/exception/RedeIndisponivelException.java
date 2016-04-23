package br.com.aqlbras.catmovshop.mobile.android.exception;


public class RedeIndisponivelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9125078884110036252L;

	public RedeIndisponivelException(final String mensagem) {
		super(mensagem);
	}

	public RedeIndisponivelException(final Throwable t) {
		super(t);
	}

	public RedeIndisponivelException(final String mensagem, final Throwable t) {
		super(mensagem, t);
	}

}
