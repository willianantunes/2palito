package br.com.aqlbras.catmovshop.mobile.android.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class AbstractAdapter<T> extends BaseAdapter {

	protected List<T> objetos;
	protected LayoutInflater inflater;

	public AbstractAdapter(List<T> objetos, Activity context) {
		super();
		this.objetos = objetos;
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return objetos.size();
	}

	public T getItem(int position) {
		return objetos.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public abstract View getView(int position, View convertView,
			ViewGroup parent);

}
