package br.com.aqlbras.catmovshop.mobile.android;

import android.app.Application;
import android.util.Log;
import br.com.aqlbras.catmovshop.mobile.android.util.DownloadImagemUtil;;


public class FornecedoresApplication extends Application {
	private static final String TAG = "FornecedoresApplication";
	// Singleton
	private static FornecedoresApplication instance = null;
	// Vari�veis
	private DownloadImagemUtil downloader;
	public static FornecedoresApplication getInstance() {
		if (instance == null)
			throw new IllegalStateException("Configure a aplica��o no AndroidManifest.xml");
		return instance;
	}
	@Override
	public void onCreate() {
		Log.i(TAG, "ContextApplication.onCreate()");
		downloader = new DownloadImagemUtil(this);
		// Salva a inst�ncia para termos acesso como Singleton
		instance = this;
	}
	public DownloadImagemUtil getDownloadImagemUtil() {
		return downloader;
	}
	@Override
	public void onTerminate() {
		super.onTerminate();
		Log.i(TAG, "ContextApplication.onTerminate()");
		downloader = null;
	}
}
