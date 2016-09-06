package br.com.aqlbras.catmovshop.mobile.android.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.model.Bandeja;
import br.com.aqlbras.catmovshop.mobile.android.model.ItemProduto;
import br.com.aqlbras.catmovshop.mobile.android.model.ObjetoTransferencia;
import br.com.aqlbras.catmovshop.mobile.android.model.Produto;

/**
 * @author Wellington Almeida
 * 
 */
public class AlertaActivity extends AbstractViewActivity {
	int contador;
	public TextView mostra;
	private Button btAdicionar;
	private Button btRemover;
	private Button btExcluir;
	private Button btPronto;

	private class AcaoBotaoMais implements OnClickListener {

		public void onClick(View v) {
			// incrementa 1 a quantidade.
			contador++;
			mostra.setText(String.valueOf(contador)); // Altera o texto da
														// TextVi
		}
	}

	private class AcaoBotaoMenos implements OnClickListener {

		public void onClick(View v) {
			// incrementa 1 a quantidade.
			contador--;
			mostra.setText(String.valueOf(contador)); // Altera o texto da
														// TextVi
		}
	}

	private class AcaoBotaoExcluir implements OnClickListener {

		public void onClick(View v) {
			ObjetoTransferencia obj = getObjetoTransferencia();		
			Produto produtoEscolhido = obj.getProdutoEscolhido();

			ItemProduto item = new ItemProduto(contador, produtoEscolhido);	
			
			// Excluir todos os itens
			contador = 0;
			mostra.setText(String.valueOf(contador)); // Altera o texto da
														// TextVi

			Bandeja novaBandeja = obj.getBandeja();

			novaBandeja.removerItem(item);

			setResult(2,
					criarIntentObjetoTransferencia(AlertaActivity.class, obj));

			finish();
		}
	}

	private class AcaoBotaoPronto implements OnClickListener {

		public void onClick(View v) {

			ObjetoTransferencia obj = getObjetoTransferencia();

			Produto produtoEscolhido = obj.getProdutoEscolhido();

			ItemProduto item = new ItemProduto(contador, produtoEscolhido);

			obj.setUltimoItemEscolhido(item);

			Bandeja novaBandeja = obj.getBandeja();

			if (contador > 0){
				novaBandeja.adicionarItem(item);
			}else{
				novaBandeja.removerItem(item);
			}
			

			setResult(2,
					criarIntentObjetoTransferencia(AlertaActivity.class, obj));

			finish();
		}
	}

	@Override
	protected void iniciaComponentesLayout() {
		contador = 0;

		mostra = (TextView) findViewById(R.id.tvqtd);
		btAdicionar = (Button) findViewById(R.id.btAdicionar);
		btRemover = (Button) findViewById(R.id.btRemover);
		btExcluir = (Button) findViewById(R.id.btExcluir);
		btPronto = (Button) findViewById(R.id.btPronto);

	}

	@Override
	protected void registraComponentesListeners() {
		mostra.setText("0");
		btAdicionar.setOnClickListener(new AcaoBotaoMais());
		btRemover.setOnClickListener(new AcaoBotaoMenos());
		btExcluir.setOnClickListener(new AcaoBotaoExcluir());
		btPronto.setOnClickListener(new AcaoBotaoPronto());

	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.alerta_alterar_itens);
	}

	@Override
	protected void executaCarregamentoObjetosTela() {
		// //Não precisa fazer nada, não é tela de listView

	}

}
