package br.com.aqlbras.doispalito.portal.business;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.model.User;
import br.com.aqlbras.doispalito.portal.repository.UserRepository;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class UserBusiness extends GenericBusiness<User> implements UserRepository 
{
	protected UserBusiness(Session session) 
	{
		super(session);
	}

	@Override
	public User findByEmail(String email) {
		logger.debug(String.format("Lendo (%s) com o email (%s)", this.classType, email));
		return (User) this.session.createCriteria(User.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
	}
}
