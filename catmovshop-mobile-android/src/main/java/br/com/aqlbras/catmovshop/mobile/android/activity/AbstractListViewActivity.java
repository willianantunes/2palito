package br.com.aqlbras.catmovshop.mobile.android.activity;

import java.io.IOException;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.integracao.AbstractIntegracao;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;

public abstract class AbstractListViewActivity<T> extends AbstractViewActivity {

	protected ListView listView;
	
	private class AcaoEscolhaListViewItem implements OnItemClickListener 
	{
		public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) 
		{		
			execucaoPosItemClick(parent, view, posicao, id);
		}
	}
	
	protected abstract class BuscaTask extends
			AsyncTask<Void, Integer, List<T>> {

		private static final String TAG = "aqlbras";
		private Context context;
		private ProgressDialog progresso;
		private AbstractIntegracao<T> integracao;
		private Object criterio;

		public BuscaTask(Context context, AbstractIntegracao<T> integracao,
				Object criterio) 
		{
			this.context = context;
			this.integracao = integracao;
			this.criterio = criterio;
		}

		@Override
		protected void onPreExecute() 
		{
			progresso = ProgressDialog.show(context,
					context.getString(R.string.app_name),
					context.getString(R.string.aguarde));
		}

		protected List<T> doInBackground(Void... params) {
			try {

				return integracao.getObjects(context,criterio);

			} catch (IOException e) {
				Log.e(TAG, e.getMessage(), e);
				AndroidUtils.alertDialog(context, R.string.erro_io);
			} finally {
				progresso.dismiss();
			}
			return null;
		}

		protected abstract void onPostExecute(List<T> objetos);
	}

	
	@Override
	protected void registraComponentesListeners() {
		listView.setOnItemClickListener(new AcaoEscolhaListViewItem());
	}
	
	protected abstract void execucaoPosItemClick(AdapterView<?> parent, View view, int posicao,
			long id);
}
