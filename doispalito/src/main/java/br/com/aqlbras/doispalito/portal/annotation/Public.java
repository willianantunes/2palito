package br.com.aqlbras.doispalito.portal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Todo método que estiver anotado com @Public será liberado para uso geral, não 
 * havendo restrições. Uma classe com @Resource anotada com @Public permitirá acesso 
 * total a todos os seus métodos.
 * @author Antunes
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD})
public @interface Public {}
