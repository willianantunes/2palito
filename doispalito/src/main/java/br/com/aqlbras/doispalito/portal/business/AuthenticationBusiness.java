package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.aqlbras.doispalito.portal.model.User;
import br.com.aqlbras.doispalito.portal.repository.AuthenticationRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class AuthenticationBusiness implements AuthenticationRepository
{
	// VRaptor
	private final Session session;
	
	public AuthenticationBusiness(Session session) 
	{
		super();
		this.session = session;
	}

	@Override
	public User login(String email, String password) {
		return (User) this.session.createCriteria(User.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
	}

}
