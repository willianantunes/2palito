package br.com.aqlbras.catmovshop.mobile.android.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import br.com.aqlbras.catmovshop.mobile.android.FornecedoresApplication;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.domain.Fornecedor;
import br.com.aqlbras.catmovshop.mobile.android.util.DownloadImagemUtil;

public class FornecedorAdapter extends BaseAdapter {
	protected static final String TAG = "alqbras";
	private LayoutInflater inflater;
	private final List<Fornecedor> fornecedores;
	private DownloadImagemUtil downloader;

	public FornecedorAdapter(Activity context, List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// Recupera o objeto global da aplica��o
		// FornecedoresApplication application = (FornecedoresApplication)
		// context.getApplication();
		// Utiliza este objeto para recuperar a classe que faz o download de
		// imagens
		/* downloader = application.getDownloadImagemUtil(); */

	}

	public int getCount() {
		return fornecedores != null ? fornecedores.size() : 0;
	}

	public Object getItem(int position) {
		return fornecedores != null ? fornecedores.get(position) : null;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder = null;
		if (view == null) {
			// Nao existe a View no cache para esta linha ent�o cria um novo
			holder = new ViewHolder();
			// Busca o layout para cada Fornecedor com a foto
			int layout = R.layout.detalhes_fornecedor;
			view = inflater.inflate(layout, null);
			view.setTag(holder);
			holder.tNome = (TextView) view.findViewById(R.id.tNome);
			holder.tDesc = (TextView) view.findViewById(R.id.tDesc);
			/* holder.imgFoto = (ImageView) view.findViewById(R.id.img); */
			holder.progress = (ProgressBar) view.findViewById(R.id.progress);
		} else {
			// Ja existe no cache, bingo entao pega!
			holder = (ViewHolder) view.getTag();
		}
		// holder.imgFoto.setImageBitmap(null);
		Fornecedor f = fornecedores.get(position);
		// Agora que temos a view atualizada os valores
		holder.tNome.setText(f.getRazaoSocial());
		holder.tDesc.setText(f.getDescricao());
		/*
		 * if(holder.tDesc != null) { holder.tDesc.setText(f.razaoSocial); }
		 * downloader.download(context, f.urlFoto, holder.imgFoto,
		 * holder.progress);
		 */
		return view;
	}

	// Design Patter "ViewHolder" para Android
	static class ViewHolder {
		TextView tNome;
		TextView tDesc;
		// ImageView imgFoto;
		ProgressBar progress;
	}
}