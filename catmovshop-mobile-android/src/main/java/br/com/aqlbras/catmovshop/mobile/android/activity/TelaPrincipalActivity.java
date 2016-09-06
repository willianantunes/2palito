package br.com.aqlbras.catmovshop.mobile.android.activity;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.aqlbras.catmovshop.mobile.android.Main;
import br.com.aqlbras.catmovshop.mobile.android.R;

/**
 * Activity base
 * 
 * @author Wellington Almeida
 * 
 */
public class TelaPrincipalActivity extends Activity implements Serializable {

	private class AcaoMostrarFornecedores implements OnClickListener {
		public void onClick(View v) {
			startActivity(criarIntentObjetoTransferencia(TelaFornecedoresActivity.class));
		}
	}

	private class AcaoMostrarConfiguracoes implements OnClickListener {

		public void onClick(View v) {
			startActivity(criarIntentObjetoTransferencia(TelaConfiguracoesActivity.class));
		}
	}

	private class AcaoMostrarHistorico implements OnClickListener {

		public void onClick(View v) {
			startActivity(criarIntentObjetoTransferencia(TelaHistoricoActivity.class));
		}
	}

	private class AcaoMostrarBandeja implements OnClickListener {
		public void onClick(View v) {
			startActivity(criarIntentObjetoTransferencia(TelaBandejaActivity.class));
		}
	}

	private class AcaoMostrarPedidos implements OnClickListener {
		public void onClick(View v) {
			startActivity(criarIntentObjetoTransferencia(TelaPedidosActivity.class));
		}
	}

	private class AcaoMostrarCategoriaItens implements OnClickListener {

		public void onClick(View v) {
			startActivity(criarIntentObjetoTransferencia(TelaCategoriaItensActivity.class));

		}
	}

	private Button botaoCardapio;
	private Button botaoConfiguracoes;
	private Button botaoHistorico;
	private Button botaoBandeja;
	private Button botaoPedidos;
	private Button botaoCategoriaItens;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_principal);
		inicializaComponentes();
		registraEventosClique();
	}

	private void registraEventosClique() {
		botaoPedidos.setOnClickListener(new AcaoMostrarPedidos());
		botaoCardapio.setOnClickListener(new AcaoMostrarFornecedores());
		botaoConfiguracoes.setOnClickListener(new AcaoMostrarConfiguracoes());
		botaoHistorico.setOnClickListener(new AcaoMostrarHistorico());
		botaoBandeja.setOnClickListener(new AcaoMostrarBandeja());
		botaoCategoriaItens.setOnClickListener(new AcaoMostrarCategoriaItens());
	}

	private void inicializaComponentes() {
		botaoCardapio = (Button) findViewById(R.id.btRestaurante);
		botaoConfiguracoes = (Button) findViewById(R.id.btConfiguracoes);
		botaoHistorico = (Button) findViewById(R.id.btFavorito);
		botaoBandeja = (Button) findViewById(R.id.btBandeja);
		botaoPedidos = (Button) findViewById(R.id.btPedidos);
		botaoCategoriaItens = (Button) findViewById(R.id.btItem);
	}

	private Intent criarIntentObjetoTransferencia(Class<?> clazz) {
		return new Intent(this, clazz).putExtra(
				Main.nameObjetoTransferencia,
				getIntent().getExtras().getSerializable(
						Main.nameObjetoTransferencia));
	}
}
