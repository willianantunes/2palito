package br.com.aqlbras.catmovshop.mobile.android.adapters;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.model.Produto;

public class ProdutoAdapter extends AbstractAdapter<Produto> {

	public ProdutoAdapter(List<Produto> objetos, Activity context) {
		super(objetos, context);
	}

	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder = null;
		if (view == null) {

			holder = new ViewHolder();

			int layout = R.layout.detalhes_itens;
			view = inflater.inflate(layout, null);
			view.setTag(holder);
			holder.tNome = (TextView) view.findViewById(R.id.tNome);
			holder.tDesc = (TextView) view.findViewById(R.id.tDesc);
			holder.tPreco = (TextView) view.findViewById(R.id.tPreco);

			holder.progress = (ProgressBar) view.findViewById(R.id.progress);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		Produto p = objetos.get(position);

		holder.tNome.setText(p.getNome());
		holder.tDesc.setText(p.getDescricao());
		holder.tPreco.setText(p.getPreco() + "");

		return view;
	}

	static class ViewHolder {
		TextView tPreco;
		TextView tNome;
		TextView tDesc;
		ProgressBar progress;
	}
}