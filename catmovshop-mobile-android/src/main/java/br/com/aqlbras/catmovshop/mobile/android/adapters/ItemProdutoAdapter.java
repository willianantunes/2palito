package br.com.aqlbras.catmovshop.mobile.android.adapters;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.model.ItemProduto;

public class ItemProdutoAdapter extends AbstractAdapter<ItemProduto> {

	public ItemProdutoAdapter(List<ItemProduto> objetos, Activity context) {
		super(objetos, context);
	}

	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder = null;
		if (view == null) {
			// Nao existe a View no cache para esta linha ent�o cria um novo
			holder = new ViewHolder();
			// Busca o layout para cada Fornecedor com a foto
			int layout = R.layout.detalhes_itens_bandeja;
			view = inflater.inflate(layout, null);
			view.setTag(holder);
			holder.tNome = (TextView) view.findViewById(R.id.tNome);
			holder.tDesc = (TextView) view.findViewById(R.id.tDesc);
			holder.tPreco = (TextView) view.findViewById(R.id.tPreco);
			holder.tQuantidade = (TextView) view.findViewById(R.id.tQuantidade);
			holder.tTotalItem = (TextView) view.findViewById(R.id.tTotal);
			/* holder.imgFoto = (ImageView) view.findViewById(R.id.img); */
			holder.progress = (ProgressBar) view.findViewById(R.id.progress);
		} else {

			// Ja existe no cache, bingo entao pega!
			holder = (ViewHolder) view.getTag();
			holder.tQuantidade = (TextView) view.findViewById(R.id.tQuantidade);
			holder.tTotalItem = (TextView) view.findViewById(R.id.tTotal);

		}

		// holder.imgFoto.setImageBitmap(null);
		ItemProduto p = objetos.get(position);
		// Agora que temos a view atualizada os valores
		
		String teste = p.getNome() ; 
		
		holder.tNome.setText(p.getNome());
		holder.tDesc.setText(p.getDescricao());
		holder.tPreco.setText(p.getPreco() + "");
		holder.tQuantidade.setText("" + p.getQuantidade());
		holder.tTotalItem.setText("" + p.getQuantidade() * p.getPreco());
		/*
		 * if(holder.tDesc != null) { holder.tDesc.setText(f.razaoSocial); }
		 * downloader.download(context, f.urlFoto, holder.imgFoto,
		 * holder.progress);
		 */
		return view;
	}

	// Design Patter "ViewHolder" para Android
	static class ViewHolder {
		TextView tPreco;
		TextView tNome;
		TextView tDesc;
		TextView tQuantidade;
		TextView tTotalItem;
		// ImageView imgFoto;
		ProgressBar progress;
	}
}