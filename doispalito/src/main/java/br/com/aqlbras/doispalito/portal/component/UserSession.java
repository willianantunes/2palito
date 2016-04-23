package br.com.aqlbras.doispalito.portal.component;

import br.com.aqlbras.doispalito.portal.model.User;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UserSession 
{
	private User user;
	
	public User getUser() 
	{
		return user;
	}
	public void setUser(User user) 
	{
		this.user = user;
	}
    public void logout()
    {
    	this.user = null;
    }
    
    public boolean isLogged()
    {
    	return this.user != null;
    }
}
