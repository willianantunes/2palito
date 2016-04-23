package br.com.aqlbras.doispalito.portal.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.aqlbras.doispalito.portal.annotation.Public;
import br.com.aqlbras.doispalito.portal.business.common.GenericBusiness;
import br.com.aqlbras.doispalito.portal.component.UserSession;
import br.com.aqlbras.doispalito.portal.model.User;
import br.com.aqlbras.doispalito.portal.repository.AuthenticationRepository;
import br.com.aqlbras.doispalito.portal.repository.UserRepository;
import br.com.aqlbras.doispalito.portal.util.Utils;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations; 
import br.com.caelum.vraptor.view.Results;

@Resource
public class AuthenticationController 
{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	// VRaptor
	private final Result result;
	private final Validator validator;
	// Component
	private final UserSession userSession;
	// Repositories
	private final AuthenticationRepository authenticationRepository;	
	
	public AuthenticationController(Result result, Validator validator, UserSession userSession, AuthenticationRepository authenticationRepository, UserRepository userRepository) 
	{
		this.result = result;
		this.validator = validator;
		this.userSession = userSession;
		this.authenticationRepository = authenticationRepository;
	}
	
	@Public
	@Get("/login")
	public void login()
	{
		
	}
	
	@Public
	@Post("/login")
	public void login(String email, String password)
	{
		final User userFound = this.authenticationRepository.login(email, Utils.passwordHashing(password));
		
		validator.checking(new Validations(){{
			that(userFound,is(notNullValue()) , "error", "mensagem.erroLoginEOUSenhaInvalidos");
		}});
		validator.onErrorUsePageOf(this).login();		
		
		// Keep the user in the session and redirect him to the main page
		this.userSession.setUser(userFound);
				
		result.redirectTo(UsersController.class).index();
	}	
	
	@Get("/logout")
	public void logout()
	{
		this.userSession.logout();
		result.redirectTo(this).login();
	}
	
	@Public
	@Post("/restService/user/login")
	@Consumes(value={"application/json", "application/x-www-form-urlencoded"})
	public void login(User user)
	{	
		logger.debug(String.format("Procurando usuário (%s)/(%s)", user.getEmail(), user.getPassword()));
		
		final User userFound = this.authenticationRepository.login(user.getEmail(), user.getPassword());
		
		if(userFound != null)
		{
			logger.debug(String.format("Serializando usuário (%s)", user.getEmail()));
			// this.usuarioInfo.setUsuario(usuarioAchado);			
			this.result.use(Results.json()).withoutRoot().from(userFound)
			.include("birthday")
			.include("registerDate")
			.include("userProfile")
			.serialize();
		}
		else
		{
			this.result.use(Results.status()).notFound();
		}
	}	
}
