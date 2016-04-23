package br.com.aqlbras.doispalito.portal.interceptor;

import static br.com.caelum.vraptor.view.Results.http;

import java.util.Arrays;
import java.util.Collection;

import br.com.aqlbras.doispalito.portal.annotation.Permission;
import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.component.UserSession;
import br.com.aqlbras.doispalito.portal.model.UserProfileType;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts(after=LoginInterceptor.class)
public class PermissionInterceptor implements Interceptor
{

	private final Result result;
	private final UserSession userSession;
	private final Localization localization;
	
	public PermissionInterceptor(Result result, UserSession userSession, Localization localization)
	{
		this.result = result;
		this.userSession = userSession;
		this.localization = localization;
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {
		return !(method.getMethod().isAnnotationPresent(Public.class) 
				|| method.getResource().getType().isAnnotationPresent(Public.class));
	}	

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		
		Permission methodPermission = method.getMethod().getAnnotation(Permission.class);
		Permission controllerPermission = method.getResource().getType().getAnnotation(Permission.class);
		
		if (this.hasAccess(methodPermission) && this.hasAccess(controllerPermission)) {
			stack.next(method, resourceInstance);
		} else {
			result.use(http()).sendError(403, this.localization.getMessage("mensagem.codigoStatusHTTP403"));
		}		

	}
	
	private boolean hasAccess(Permission permission)
	{
		if(permission == null)
			return true;
		
		Collection<UserProfileType> userProfileTypes = Arrays.asList(permission.value());
		return  userProfileTypes.contains(this.userSession.getUser().getUserProfile().getUserProfileType());
	}
	
}
