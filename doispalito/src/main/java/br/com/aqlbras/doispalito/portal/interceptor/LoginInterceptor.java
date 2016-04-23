package br.com.aqlbras.doispalito.portal.interceptor;

import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.component.UserSession;
import br.com.aqlbras.doispalito.portal.controller.AuthenticationController;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts(before=PermissionInterceptor.class)
public class LoginInterceptor implements Interceptor {
	
	private final UserSession userSession;
	private final Result result;
	
	public LoginInterceptor(UserSession userSession, Result result)
	{
		this.userSession = userSession;
		this.result = result;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		if(this.userSession.isLogged())
		{
			stack.next(method, resourceInstance);
		}
		else
		{
			this.result.redirectTo(AuthenticationController.class).login();
		}		
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		// Se tiver no método ou recurso (uma classe inteira @Resource, logo todos os métodos seriam públicos) anotado com @Public
		return !(method.getMethod().isAnnotationPresent(Public.class))
				|| method.getResource().getType().isAnnotationPresent(Public.class);
	}

}
