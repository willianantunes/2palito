package br.com.aqlbras.catmovshop.mobile.android.business;

import br.com.aqlbras.catmovshop.mobile.android.business.common.GenericBusiness;
import br.com.aqlbras.catmovshop.mobile.android.model.Usuario;
import br.com.aqlbras.catmovshop.mobile.android.repository.UsuarioRepository;

public class UsuarioBusiness extends GenericBusiness<Usuario> implements UsuarioRepository
{

	public UsuarioBusiness(String baseURL) 
	{
		// We must set this using config file or somoething like that - Antunes
		super("http://aqlbras.no-ip.biz:65002/catmovshop/restService/usuarios");
	}

}
