package br.com.aqlbras.doispalito.portal.controller;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.joda.time.DateTime;

import br.com.aqlbras.doispalito.portal.component.UserSession;
import br.com.aqlbras.doispalito.portal.model.User;
import br.com.aqlbras.doispalito.portal.repository.UserRepository;
import br.com.aqlbras.doispalito.portal.util.Utils;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.validator.Validations;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

@Resource
public class UsersController 
{
	// VRaptor
	private final Result result;
	private final Validator validator;
	private final Localization localization;		
	// Repositories
	private final UserRepository userRepository;
	// Component
	private final UserSession userSession;
	
	public UsersController(Result result, Validator validator, Localization localization, UserRepository userRepository, UserSession userSession) 
	{
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.userRepository = userRepository;
		this.userSession = userSession;
	}

	@Get("/")
	public void index()
	{
		
	}
	
	@Get("/users/")
	public List<User> list()
	{
		return Lists.newArrayList(this.userRepository.list());
	}
	
	@Get("/users/add")
	public void create()
	{

	}
	
	@Post("/users/add")
	public void create(User user)
	{
		Preconditions.checkNotNull(user);
		validateUser(user);
		user.setRegisterDate(DateTime.now());
		user.setPassword(Utils.passwordHashing(user.getPassword()));
		userRepository.save(user);
		result.include("message", this.localization.getMessage("message.user.register.success"));
		result.redirectTo(this).list();
	}	
	
	@Get("/users/{id}")
	public User view(Long id)
	{
		return this.userRepository.find(id);
	}
	
	@Put("/users/{id}")
	public User update(User user)
	{
		// TODO: Implementar UPDATE do usuário
		return null;
	}
	
	public void delete(User user)
	{
		// TODO: Implementar DELETE do usuário
	}
	
	private void validateUser(final User user) 
	{
		validator.checking(new Validations() 
		{
			{
				that(user.getName(), is(notNullValue()), "error", "message.user.name.empty");
				that(user.getPassword(), is(notNullValue()), "error", "message.user.password.empty");
				that(user.getBirthday(), is(notNullValue()), "error", "message.user.birthday.empty");
				that(user.getUserProfile(), is(notNullValue()), "error", "message.user.profile.empty");
				that(user.getPhones(), is(notNullValue()), "error", "message.user.phones.empty");
				if (that(Utils.isValidEmail(user.getEmail()), "error", "message.user.email.invalid")) 
				{
					that(user.getEmail(), not(equalToIgnoringCase(userRepository.findByEmail(user.getEmail()).getEmail())), 
							"error", "message.user.email.already.registered");
				}
			}
		});
		
		validator.onErrorUsePageOf(this).create();
		
		try 
		{
			Utils.extractAreaCodeFromPhones(user.getPhones());
		} 
		catch (IllegalArgumentException e) 
		{
			result.include("message", this.localization.getMessage("message.user.phone.invalid"));
			result.redirectTo(this).create();
		}
	}
}
