package br.com.aqlbras.catmovshop.mobile.android.util;

import android.app.Activity;
import br.com.aqlbras.catmovshop.mobile.android.exception.RedeIndisponivelException;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;

public class RedeUtils {

	public static void verificaDisponibilidadeRede(Activity activity) throws RedeIndisponivelException{
		if (!AndroidUtils.isNetworkAvailable(activity)) {
			throw new RedeIndisponivelException("A rede da Activity" + activity
					+ "encontra-se Indispon�vel");

		}
	}
}
