package br.com.aqlbras.catmovshop.mobile.android.integracao;

import java.util.List;

import android.os.AsyncTask;
import br.com.aqlbras.catmovshop.mobile.android.business.PedidoBusiness;
import br.com.aqlbras.catmovshop.mobile.android.business.common.GenericBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Pedido;

public class PedidoIntegracao {

	private PedidoBusiness pedidoBusiness = new PedidoBusiness(
			"http://aqlbras.no-ip.biz:65002/catmovshop/restService/pedidos");

	public void dispacharPedidos(List<Pedido> listaPedidos) {

		for (Pedido pedido : listaPedidos) {

			try {

				pedido.setFornecedor(null);
				
				new EnviaPedido(new Pedido(), pedidoBusiness).execute();

//				Thread thread = new Thread(new Runnable() {
//					public void run() {
//						try {
//
//							pedidoBusiness.save(new Pedido());
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//				thread.start();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private class EnviaPedido extends AsyncTask<Void, Integer, Void> {
		private Pedido pedido;
		private GenericBusiness<Pedido> business;

		public EnviaPedido(Pedido pedido, GenericBusiness<Pedido> business) {
			this.pedido = pedido;
			this.business = business;
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				business.save(pedido);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

	}

}
