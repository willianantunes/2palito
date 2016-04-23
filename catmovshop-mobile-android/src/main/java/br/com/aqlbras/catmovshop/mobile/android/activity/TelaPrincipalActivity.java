package br.com.aqlbras.catmovshop.mobile.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.aqlbras.catmovshop.mobile.android.R;

/**
 * Activity base
 * 
 * @author Wellington Almeida
 * 
 */
public class TelaPrincipalActivity extends Activity 
{
	private Activity telaPrincipalActivity = this;

	private class AcaoBotaoCardapio implements OnClickListener 
	{
		public void onClick(View v) 
		{
			Intent intent = new Intent(telaPrincipalActivity,
					TelaCardapioActivity.class);
			intent.putExtra("Bandeja",
					getIntent().getExtras().getSerializable("Bandeja"));
			intent.putExtra("chamada", "btFornecedores"); // ver
			startActivity(intent);
		}
	}

	private class AcaoBotaoConfiguracoes implements OnClickListener 
	{

		public void onClick(View v) 
		{
			startActivity(new Intent(telaPrincipalActivity,
					TelaConfiguracoesActivity.class));
		}
	}

	private class AcaoBotaoHistorico implements OnClickListener 
	{

		public void onClick(View v) 
		{
			startActivity(new Intent(telaPrincipalActivity,
					TelaHistoricoActivity.class));
		}
	}

	private class AcaoBotaoBandeja implements OnClickListener 
	{
		public void onClick(View v) 
		{
			startActivity(new Intent(telaPrincipalActivity,
					TelaBandejaActivity.class));
		}
	}

	private class AcaoBotaoPedidos implements OnClickListener 
	{
		public void onClick(View v) 
		{
			startActivity(new Intent(telaPrincipalActivity,
					TelaPedidosActivity.class));
		}
	}

	private Button btCardapio;
	private Button btConfiguracoes;
	private Button btHistorico;
	private Button btBandeja;
	private Button btPedidos;

	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_principal);
		inicializaComponentes();
		registraEventosClique();
	}

	private void registraEventosClique() 
	{
		btPedidos.setOnClickListener(new AcaoBotaoPedidos());
		btCardapio.setOnClickListener(new AcaoBotaoCardapio());
		btConfiguracoes.setOnClickListener(new AcaoBotaoConfiguracoes());
		btHistorico.setOnClickListener(new AcaoBotaoHistorico());
		btBandeja.setOnClickListener(new AcaoBotaoBandeja());
	}

	private void inicializaComponentes() 
	{
		btCardapio = (Button) findViewById(R.id.btCardapio);
		btConfiguracoes = (Button) findViewById(R.id.btConfiguracoes);
		btHistorico = (Button) findViewById(R.id.btHistorico);
		btBandeja = (Button) findViewById(R.id.btBandeja);
		btPedidos = (Button) findViewById(R.id.btPedidos);
	}
}
