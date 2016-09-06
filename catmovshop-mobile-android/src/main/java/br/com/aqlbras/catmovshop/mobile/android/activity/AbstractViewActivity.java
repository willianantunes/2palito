package br.com.aqlbras.catmovshop.mobile.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import br.com.aqlbras.catmovshop.mobile.android.Main;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.exception.RedeIndisponivelException;
import br.com.aqlbras.catmovshop.mobile.android.model.ObjetoTransferencia;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;
import br.com.aqlbras.catmovshop.mobile.android.util.RedeUtils;

public abstract class AbstractViewActivity extends Activity implements
		ActivityViewIntentManipulator {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView();

		try {
			RedeUtils.verificaDisponibilidadeRede(this);

			executaCarregamentoObjetosTela();

			iniciaComponentesLayout();

			registraComponentesListeners();

		} catch (RedeIndisponivelException e) {
			AndroidUtils.alertDialog(this, R.string.erro_conexao_indisponivel);
		}
	}

	protected Activity activityThis = this;

	public final Intent criarIntentObjetoTransferencia(Class<?> clazz) {
		return new Intent(this, clazz).putExtra(Main.nameObjetoTransferencia,
			getObjetoTransferencia());
		
	}

	public final ObjetoTransferencia getObjetoTransferencia() {
		
		return Main.objetoTransferencia;
		
//		return (ObjetoTransferencia) getIntent().getExtras().getSerializable(
//				Main.nameObjetoTransferencia);
	}

	public final Intent criarIntentObjetoTransferencia(Class<?> clazz,
			ObjetoTransferencia obj) {
		
		Main.objetoTransferencia = obj;
		
		return criarIntentObjetoTransferencia(clazz);

//		return new Intent(this, clazz).putExtra(Main.nameObjetoTransferencia,
//				obj);
	}

	protected abstract void iniciaComponentesLayout();

	protected abstract void registraComponentesListeners();

	protected abstract void executaCarregamentoObjetosTela();

	protected abstract void setContentView();

}
