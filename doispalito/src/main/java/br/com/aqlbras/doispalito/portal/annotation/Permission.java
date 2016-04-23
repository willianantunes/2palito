package br.com.aqlbras.doispalito.portal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.aqlbras.doispalito.portal.model.UserProfileType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Permission 
{
	public UserProfileType[] value();
}
