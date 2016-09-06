package br.com.aqlbras.catmovshop.mobile.android.adapters;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import br.com.aqlbras.catmovshop.mobile.android.R;
import br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor;

public class FornecedorAdapter extends AbstractAdapter<Fornecedor> {

	public FornecedorAdapter(List<Fornecedor> objetos, Activity context) {
		super(objetos, context);
	}

	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder = null;
		if (view == null) {

			holder = new ViewHolder();

			int layout = R.layout.detalhes_restaurantes;
			view = inflater.inflate(layout, null);
			view.setTag(holder);
			holder.tNome = (TextView) view.findViewById(R.id.tNome);
			holder.tDesc = (TextView) view.findViewById(R.id.tDesc);

			holder.progress = (ProgressBar) view.findViewById(R.id.progress);
		} else {

			holder = (ViewHolder) view.getTag();
		}

		Fornecedor f = objetos.get(position);

		holder.tNome.setText(f.getRazaoSocial());
		holder.tDesc.setText(f.getDescricao());

		return view;
	}

	static class ViewHolder {
		TextView tNome;
		TextView tDesc;
		ProgressBar progress;
	}
}