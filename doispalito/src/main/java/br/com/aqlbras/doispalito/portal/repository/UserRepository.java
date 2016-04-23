package br.com.aqlbras.doispalito.portal.repository;

import br.com.aqlbras.doispalito.portal.model.User;
import br.com.aqlbras.doispalito.portal.model.UserProfileType;
import br.com.aqlbras.doispalito.portal.repository.common.GenericRepository;

public interface UserRepository extends GenericRepository<User>
{
	User findByEmail(String email);
}
