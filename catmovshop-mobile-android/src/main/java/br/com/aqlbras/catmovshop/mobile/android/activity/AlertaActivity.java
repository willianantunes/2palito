package br.com.aqlbras.catmovshop.mobile.android.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.exception.RedeIndisponivelException;
import br.com.aqlbras.catmovshop.mobile.android.util.RedeUtils;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;

/**
 * @author Wellington Almeida
 * 
 */
public class AlertaActivity extends Activity {
	int contador;
	public TextView mostra;
	private Button btAdicionar;
	private Button btRemover;
	private Button btExcluir;
	private Button btPronto;
	
	private class AcaoBotaoMais implements OnClickListener {

		public void onClick(View v) {
            //incrementa 1 a quantidade.
            contador++;
            mostra.setText(String.valueOf(contador)); 	//Altera o texto da TextVi
		}
	}
	
	private class AcaoBotaoMenos implements OnClickListener {

		public void onClick(View v) {
            //incrementa 1 a quantidade.
            contador--;
            mostra.setText(String.valueOf(contador)); 	//Altera o texto da TextVi
		}
	}	
	
	private class AcaoBotaoExcluir implements OnClickListener {

		public void onClick(View v) {
            // Excluir todos os itens
            contador = 0;
            mostra.setText(String.valueOf(contador)); 	//Altera o texto da TextVi
            
			Intent data = new Intent();
			data.putExtra("quantidade", contador);
			setResult(2, data);
			
            finish();
		}
	}
	
	private class AcaoBotaoPronto implements OnClickListener {

		public void onClick(View v) {
			
			Intent data = new Intent();
			data.putExtra("quantidade", contador);
			setResult(2, data);
			// Sai da tela comitando a alteracao	
			finish();
		}
	}		
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.alerta_alterar_itens);
		mostra = (TextView)findViewById(R.id.tvqtd);
		iniciaComponentesLayout();

		try {
			RedeUtils.verificaDisponibilidadeRede(this);
		} catch (RedeIndisponivelException e) {
			AndroidUtils.alertDialog(this, R.string.erro_conexao_indisponivel);
		}
	}
	

	private void iniciaComponentesLayout() {
		contador = 0;
		mostra.setText("0");
		btAdicionar = (Button) findViewById(R.id.btAdicionar);
		btRemover = (Button) findViewById(R.id.btRemover);
		btExcluir = (Button) findViewById(R.id.btExcluir);
		btPronto = (Button) findViewById(R.id.btPronto);		

		btAdicionar.setOnClickListener(new AcaoBotaoMais());
		btRemover.setOnClickListener(new AcaoBotaoMenos());
		btExcluir.setOnClickListener(new AcaoBotaoExcluir());
		btPronto.setOnClickListener(new AcaoBotaoPronto());
	}

}
