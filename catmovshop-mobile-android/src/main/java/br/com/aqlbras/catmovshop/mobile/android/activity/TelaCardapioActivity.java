package br.com.aqlbras.catmovshop.mobile.android.activity;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import br.com.aqlbras.catmovshop.mobile.android.Main;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.adapters.FornecedorAdapter;
import br.com.aqlbras.catmovshop.mobile.android.adapters.ProdutoAdapter;
import br.com.aqlbras.catmovshop.mobile.android.domain.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.domain.ItemProduto;
import br.com.aqlbras.catmovshop.mobile.android.domain.Bandeja;
import br.com.aqlbras.catmovshop.mobile.android.domain.Produto;
import br.com.aqlbras.catmovshop.mobile.android.exception.RedeIndisponivelException;
import br.com.aqlbras.catmovshop.mobile.android.service.CardapioService;
import br.com.aqlbras.catmovshop.mobile.android.util.RedeUtils;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;

/**
 * @author Wellington Almeida
 * 
 */
public class TelaCardapioActivity extends Activity {

	// Botoes do menu header
	private Button btFornecedores;
	private Button btItens;
	private Button btBandeja;

	// variavel q indica a opcao chamada
	private boolean bandejaAberta = false;
	private Bandeja pedidoCardapio;
	private Fornecedor f;
	private Produto pr;
	private int quantidade;

	// list view de fornecedores
	private ListView listView;

	private final Activity activityCardapio = this;

	private class AcaoBotaoItens implements OnClickListener {

		public void onClick(View v) {
			Intent intent = new Intent(activityCardapio,
					TelaCardapioActivity.class);
			intent.putExtra("chamada", "btItens");
			intent.putExtra("Bandeja",
					getIntent().getExtras().getSerializable("Bandeja"));
			startActivity(intent);
		}
	}

	private class AcaoBotaoFornecedores implements OnClickListener {

		public void onClick(View v) {
			Intent intent = new Intent(activityCardapio,
					TelaCardapioActivity.class);
			intent.putExtra("chamada", "btFornecedor");
			intent.putExtra("Bandeja",
					getIntent().getExtras().getSerializable("Bandeja"));
			startActivity(intent);
		}
	}

	private class AcaoBotaoBandeja implements OnClickListener {

		public void onClick(View v) {
			Intent intent = new Intent(activityCardapio,
					TelaBandejaActivity.class);
			Bundle params = new Bundle();
			params.putSerializable("Bandeja", pedidoCardapio);
			intent.putExtra("Bandeja",
					getIntent().getExtras().getSerializable("Bandeja"));
			
			intent.putExtras(params);
			startActivity(intent);
		}
	}

	private class AcaoEscolhaListView implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int posicao,
				long id) {

			String chamada = (String) getIntent().getExtras().get("chamada");

			if (chamada.equals("btFornecedores")
					|| chamada.equals("btFornecedor")) {
				Fornecedor f = (Fornecedor) parent.getAdapter()
						.getItem(posicao);

				Toast.makeText(activityCardapio,
						"Fornecedor: " + f.getRazaoSocial(), Toast.LENGTH_SHORT)
						.show();

				Intent intent = new Intent(activityCardapio,
						TelaCardapioActivity.class);
				intent.putExtra("chamada", "btItens");
				Bundle params = new Bundle();
				params.putSerializable("Fornecedor", f);
				intent.putExtra("Bandeja", getIntent().getExtras()
						.getSerializable("Bandeja"));
				intent.putExtras(params);
				startActivity(intent);

			} else {
				pr = (Produto) parent.getAdapter().getItem(posicao);
				
				// chama o "alertdialog" para defir a quantidade do item.  
				Intent intent_alert = new Intent(activityCardapio, AlertaActivity.class);
				startActivityForResult(intent_alert, 1);		
				

//				pedidoCardapio = (Bandeja) getIntent().getExtras().get("Bandeja");
//				
//				ItemProduto iP = new ItemProduto(pr.getPreco(), quantidade,
//						pr.getNome(), pr.getDescricao(), "data",
//						pr.getImagem(), pr);
//				
//				pedidoCardapio.adicionarItem(iP);
//
//				Toast.makeText(
//						activityCardapio,
//						"O Produto: " + pr.getNome() + " foi inserido na req: "
//								+ pedidoCardapio.getCodSolicitacao() + " QTD: "+ iP.getQuantidade(),
//						Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_cardapio);

		iniciaComponentesLayout();

		Intent intent = getIntent();

		pedidoCardapio = (Bandeja) intent.getExtras().get("Bandeja");

		try {
			RedeUtils.verificaDisponibilidadeRede(this);

			executaTaskBusca(getIntent().getStringExtra("chamada"));

		} catch (RedeIndisponivelException e) {
			AndroidUtils.alertDialog(this, R.string.erro_conexao_indisponivel);
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
			quantidade = data.getExtras().getInt("quantidade");

			
			pedidoCardapio = (Bandeja) getIntent().getExtras().get("Pedido");
			
			if (quantidade>=1){
			
				ItemProduto iP = new ItemProduto(pr.getPreco(), quantidade,
						pr.getNome(), pr.getDescricao(), "data",
						pr.getImagem(), pr);
				
				pedidoCardapio.adicionarItem(iP);
				
				Toast.makeText(
						activityCardapio,
						"O Produto: " + pr.getNome() + " foi inserido na req: "
								 + " QTD: "+ iP.getQuantidade(),
						Toast.LENGTH_SHORT).show();	
				
			}else{
				ItemProduto iP = new ItemProduto(pr.getPreco(), quantidade,
						pr.getNome(), pr.getDescricao(), "data",
						pr.getImagem(), pr);
				pedidoCardapio.removerItem(iP);
				
			}

		
	}	

	private void executaTaskBusca(String chamada) {

		if (chamada.equals("btItens")) {
			Intent intent = getIntent();
			Bundle par = intent.getExtras();
			f = (Fornecedor) par.getSerializable("Fornecedor");
			if (f != null) {
				new BuscaProdutosTask(this, f.getRazaoSocial()).execute();
			} else {
				new BuscaProdutosTask(this, "").execute();
			}
		} else {
			new BuscaFornecedoresTask(this).execute();
		}
	}

	private void iniciaComponentesLayout() {
		btFornecedores = (Button) findViewById(R.id.btFornecedores);
		btItens = (Button) findViewById(R.id.btItens);
		btBandeja = (Button) findViewById(R.id.btBandeja);
		listView = (ListView) findViewById(R.id.listview);

		btFornecedores.setOnClickListener(new AcaoBotaoFornecedores());
		btItens.setOnClickListener(new AcaoBotaoItens());
		btBandeja.setOnClickListener(new AcaoBotaoBandeja());

		listView.setOnItemClickListener(new AcaoEscolhaListView());
	}

	// Task de busca das informacoes para o list view
	class BuscaFornecedoresTask extends
			AsyncTask<Void, Integer, List<Fornecedor>> {
		private static final String TAG = "aqlbras";
		private Context context;
		private ProgressDialog progresso;

		public BuscaFornecedoresTask(Context context) {
			this.context = context;
		}

		@Override
		// Antes de executar, vamos exibir uma janela de progresso
		protected void onPreExecute() {
			progresso = ProgressDialog.show(context,
					context.getString(R.string.app_name),
					context.getString(R.string.aguarde));
		}

		// Busca os carros em segundo plano dentro da thread
		protected List<Fornecedor> doInBackground(Void... params) {
			try {
				List<Fornecedor> fornecedores = CardapioService
						.getFonecedores(context);
				return fornecedores;
			} catch (IOException e) {
				Log.e(TAG, e.getMessage(), e);
				AndroidUtils.alertDialog(context, R.string.erro_io);
			} finally {
				progresso.dismiss();
			}
			return null;
		}

		// Atualiza a view dentro sincronizado com a thread e interface
		protected void onPostExecute(List<Fornecedor> fornecedores) {
			Activity context = TelaCardapioActivity.this;
			listView.setAdapter(new FornecedorAdapter(context, fornecedores));
		}
	}

	// BUSCA PRODUTOS
	private class BuscaProdutosTask extends
			AsyncTask<Void, Integer, List<Produto>> {

		private static final String TAG = "aqlbras";
		private Context context;
		private ProgressDialog progresso;
		private String nomeRestaurante; // ton.n

		public BuscaProdutosTask(Context context, String nomeRestaurante) {
			this.context = context;
			this.nomeRestaurante = nomeRestaurante;
		}

		@Override
		// Antes de executar, vamos exibir uma janela de progresso
		protected void onPreExecute() {
			progresso = ProgressDialog.show(context,
					context.getString(R.string.app_name),
					context.getString(R.string.aguarde));
		}

		// Busca os carros em segundo plano dentro da thread
		protected List<Produto> doInBackground(Void... params) {
			List<Produto> produtos = null;

			try {
				produtos = (List<Produto>) CardapioService
						.getProdutos(context, nomeRestaurante); // ton.n
				return produtos;

			} catch (IOException e) {
				Log.e(TAG, e.getMessage(), e);
				AndroidUtils.alertDialog(context, R.string.erro_io);
			} finally {
				progresso.dismiss();
			}
			return produtos;
		}

		// Atualiza a view dentro sincronizado com a thread e interface
		protected void onPostExecute(List<Produto> produtos) {
			listView.setAdapter(new ProdutoAdapter(TelaCardapioActivity.this,
					produtos));
		}
	}

}
