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
import br.com.aqlbras.catmovshop.mobile.android.domain.Produto;
import br.com.aqlbras.catmovshop.mobile.android.util.DownloadImagemUtil;

public class ProdutoAdapter extends BaseAdapter {
	protected static final String TAG = "alqbras";
	private LayoutInflater inflater;
	private final List<Produto> produtos;
	private DownloadImagemUtil downloader;
	
	public ProdutoAdapter(Activity context, List<Produto> produtos) {
		this.produtos = produtos;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// Recupera o objeto global da aplica��o
//		FornecedoresApplication application = (FornecedoresApplication) context.getApplication();
		// Utiliza este objeto para recuperar a classe que faz o download de imagens
/*		downloader = application.getDownloadImagemUtil();*/

	}

	public int getCount() {
		return produtos != null ? produtos.size() : 0;
	}

	public Object getItem(int position) {
		return produtos != null ? produtos.get(position) : null;
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
			int layout = R.layout.detalhes_itens;
			view = inflater.inflate(layout, null);
			view.setTag(holder);
			holder.tNome = (TextView) view.findViewById(R.id.tNome);
			holder.tDesc = (TextView) view.findViewById(R.id.tDesc);
			holder.tPreco = (TextView) view.findViewById(R.id.tPreco);			
	/*		holder.imgFoto = (ImageView) view.findViewById(R.id.img);*/
			holder.progress = (ProgressBar) view.findViewById(R.id.progress);
		} else {
			// Ja existe no cache, bingo entao pega!
			holder = (ViewHolder) view.getTag();
		}
//		holder.imgFoto.setImageBitmap(null);
		Produto p = produtos.get(position);
		// Agora que temos a view atualizada os valores
		holder.tNome.setText(p.getNome());
		holder.tDesc.setText(p.getDescricao());
		holder.tPreco.setText(p.getPreco().toString());		
/*		if(holder.tDesc != null) {
			holder.tDesc.setText(f.razaoSocial);
		}
		downloader.download(context, f.urlFoto, holder.imgFoto, holder.progress);*/
		return view;
	}
	// Design Patter "ViewHolder" para Android
	static class ViewHolder {
		TextView tPreco;
		TextView tNome;
		TextView tDesc;
//		ImageView imgFoto;
		ProgressBar progress;
	}
} 