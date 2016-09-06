package br.com.aqlbras.catmovshop.mobile.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.com.aqlbras.catmovshop.mobile.android.activity.AbstractViewActivity;
import br.com.aqlbras.catmovshop.mobile.android.activity.TelaPrincipalActivity;
import br.com.aqlbras.catmovshop.mobile.android.business.UsuarioBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Bandeja;
import br.com.aqlbras.catmovshop.mobile.android.model.ObjetoTransferencia;
import br.com.aqlbras.catmovshop.mobile.android.model.Pedido;
import br.com.aqlbras.catmovshop.mobile.android.model.Usuario;
import br.com.aqlbras.catmovshop.mobile.android.repository.UsuarioRepository;
import br.com.aqlbras.catmovshop.mobile.android.util.AndroidUtils;
import br.com.aqlbras.catmovshop.mobile.android.util.Utils;

/**
 * Activity de tela de login
 * 
 * Merda Teste
 * 
 * opa
 * 
 * @author Wellington Almeida
 */
public class Main extends AbstractViewActivity {

	/**
	 * teste
	 */
	private UsuarioRepository usuarioRepository;
	private Button botaoAutenticar;
	public static ObjetoTransferencia objetoTransferencia = new ObjetoTransferencia(new Pedido(), new Bandeja("Status", false));
	public static final String nameObjetoTransferencia = "ObjetosTransferencia";

	private class AcaoAutenticar implements OnClickListener {

		public void onClick(View v) 
		{
			
			String login = null;
			String password = null;

			EditText editTxtUserName = (EditText) findViewById(R.id.editText_login);
			EditText editTxtPassword = (EditText) findViewById(R.id.editText_password);

			login = editTxtUserName.getText().toString();
			password = editTxtPassword.getText().toString();

			AuthUser authUser = new AuthUser(Main.this, usuarioRepository);
			authUser.execute(login, password);			
		}
	}

	@Override
	protected void iniciaComponentesLayout() {
		botaoAutenticar = (Button) findViewById(R.id.btAutenticar);
	}

	@Override
	protected void registraComponentesListeners() {
		botaoAutenticar.setOnClickListener(new AcaoAutenticar());
	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.login);
		this.usuarioRepository = new UsuarioBusiness("");
	}

	@Override
	protected void executaCarregamentoObjetosTela() {
		// Nada a fazer
	}
	
	//////////////////////////////////////////////////////////////////////////////
	// AsyncTask
	
    class AuthUser extends AsyncTask<String, Void, Usuario>
    {
    	private Context context;
    	private ProgressDialog progressDialog;
    	private UsuarioRepository usuarioRepository;
    	
    	public AuthUser(Context context, UsuarioRepository usuarioRepository)
    	{
    		this.context = context;
    		this.usuarioRepository = usuarioRepository;
    	}
    	
    	protected void onPreExecute()
    	{
    		progressDialog = ProgressDialog.show(context,
					context.getString(R.string.app_name),
					context.getString(R.string.aguarde));
    	}

		@Override
		protected Usuario doInBackground(String... params)
		{
            
        	String login = params[0];
        	String password = params[1];
        	
        	Usuario usuario = Usuario.getInstance();
        	usuario.setLogin(login);
        	usuario.setPassword(Utils.passwordHashing(password));
        	try
            {
        		return usuarioRepository.find(usuario);
            }
            catch(Exception ex)
            {
            	Log.e(this.toString(), ex.getMessage());
            	return null;
            }
        	finally
        	{
        		progressDialog.dismiss();
        	}        	
		}
		
		protected void onPostExecute(Usuario usuario)
		{
			if(usuario == null)
			{
				AndroidUtils.alertDialog(context, R.string.erro_login);
			}
			else{
		
				Usuario.setUsuario(usuario);
				startActivity(criarIntentObjetoTransferencia(TelaPrincipalActivity.class, objetoTransferencia));
			}			
		}
    }	
}