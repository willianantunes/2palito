package br.com.aqlbras.catmovshop.mobile.android.activity;

import android.content.Intent;
import br.com.aqlbras.catmovshop.mobile.android.model.ObjetoTransferencia;

public interface ActivityViewIntentManipulator {

	Intent criarIntentObjetoTransferencia(Class<?> clazz,
			ObjetoTransferencia obj);

	ObjetoTransferencia getObjetoTransferencia();
	
}
