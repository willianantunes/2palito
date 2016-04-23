package br.com.aqlbras.catmovshop.mobile.android.activity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.adapters.ItemProdutoAdapter;
import br.com.aqlbras.catmovshop.mobile.android.domain.ItemProduto;
import br.com.aqlbras.catmovshop.mobile.android.domain.Bandeja;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;

/**
 * @author Almeida
 * 
 */
public class TelaBandejaActivity extends Activity {

	// list view de produtos
	private ListView listView;
	private Bandeja p;
	private Button btComprar;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_bandeja);
		
		iniciaComponentesLayout();

		listView = (ListView) findViewById(R.id.listview);

		Intent intent = getIntent();
		Bundle par = intent.getExtras();
		// Bundle params = intent.getExtras();

		boolean redeOk = AndroidUtils.isNetworkAvailable(this);
		if (redeOk) {

				p = (Bandeja) par.getSerializable("Bandeja");
				new BuscapItemProdutosTask(this).execute();
			

		} else {
			AndroidUtils.alertDialog(this, R.string.erro_conexao_indisponivel);
		}
	}

	private class AcaoBotaoComprar implements OnClickListener {

		public void onClick(View v) {
				p.realizarPedido();
		}
	}	
	
	private void iniciaComponentesLayout() {
		btComprar = (Button) findViewById(R.id.btBandejasFechadas); // mudar nome do botao

		btComprar.setOnClickListener(new AcaoBotaoComprar());

	}	

	// BUSCA PRODUTOS DA BANDEJA
	class BuscapItemProdutosTask extends
			AsyncTask<Void, Integer, List<ItemProduto>> {
		private static final String TAG = "aqlbras";
		private Context context;
		private ProgressDialog progresso;

		public BuscapItemProdutosTask(Context context) {
			this.context = context;
		}

		// Antes de executar, vamos exibir uma janela de progresso
		protected void onPreExecute() {
			progresso = ProgressDialog.show(context,
					context.getString(R.string.app_name),
					context.getString(R.string.aguarde));
		}

		// Busca itens da bandeja em segundo plano dentro da thread
		protected List<ItemProduto> doInBackground(Void... params) {
			try {

				//List<ItemProduto> produtos = p.getItens();
				//List<ItemProduto> produtos = new ArrayList<ItemProduto>(p.getItens()); 
				List<ItemProduto> produtos = new ArrayList<ItemProduto>((Collection<? extends ItemProduto>) p.getMapaItensFornecedor().values()); 
				return produtos;
				/*
				 * } catch (IOException e) { Log.e(TAG, e.getMessage(), e);
				 * AndroidUtils.alertDialog(context, R.string.erro_io);
				 */
			} finally {
				progresso.dismiss();
			}
			// return null;
		}

		// Atualiza a view dentro sincronizado com a thread e interface
		protected void onPostExecute(List<ItemProduto> produtos) {
			Activity context = TelaBandejaActivity.this;
			listView.setAdapter(new ItemProdutoAdapter(context, produtos));
		}
	}
}
