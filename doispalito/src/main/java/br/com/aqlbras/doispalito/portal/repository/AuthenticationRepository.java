package br.com.aqlbras.doispalito.portal.repository;

import br.com.aqlbras.doispalito.portal.model.User;

public interface AuthenticationRepository 
{
	User login(String email, String password);
}
