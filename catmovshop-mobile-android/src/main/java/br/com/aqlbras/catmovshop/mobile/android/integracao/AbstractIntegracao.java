package br.com.aqlbras.catmovshop.mobile.android.integracao;

import java.io.IOException;
import java.util.List;

import android.content.Context;

public abstract class AbstractIntegracao<T> 
{
	
	protected IntegracaoService integracao = new IntegracaoService();
	public abstract List<T> getObjects(Context context,Object criterio) throws IOException;
}
