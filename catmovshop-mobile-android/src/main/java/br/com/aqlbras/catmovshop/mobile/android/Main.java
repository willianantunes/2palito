package br.com.aqlbras.catmovshop.mobile.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.aqlbras.catmovshop.mobile.android.activity.TelaPrincipalActivity;
import br.com.aqlbras.catmovshop.mobile.android.domain.Bandeja;
import br.com.aqlbras.catmovshop.mobile.android.exception.RedeIndisponivelException;
import br.com.aqlbras.catmovshop.mobile.android.util.RedeUtils;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;

/**
 * Activity principal
 * 
 * @author Wellington Almeida
 */
public class Main extends Activity {

	/*
	 * Coment�rio teste
	 */
	private Activity mainActivity = this;
	private Button btAutenticar;

	private class AcaoBotaoAutenticar implements OnClickListener {

		public void onClick(View v) {

			try {
				RedeUtils.verificaDisponibilidadeRede(mainActivity);

				startActivity(new Intent(mainActivity,
						TelaPrincipalActivity.class).putExtra("Bandeja",
						new Bandeja("Status", false)));

			} catch (RedeIndisponivelException e) {
				AndroidUtils.alertDialog(mainActivity,
						R.string.erro_conexao_indisponivel);
			}
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		btAutenticar = (Button) findViewById(R.id.btAutenticar);
		btAutenticar.setOnClickListener(new AcaoBotaoAutenticar());
	}
}