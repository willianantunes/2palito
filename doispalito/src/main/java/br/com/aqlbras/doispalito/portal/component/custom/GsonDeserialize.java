package br.com.aqlbras.doispalito.portal.component.custom;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonDeserializer;

import br.com.caelum.vraptor.deserialization.gson.GsonDeserialization;
import br.com.caelum.vraptor.deserialization.gson.JsonDeserializers;
import br.com.caelum.vraptor.http.ParameterNameProvider;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class GsonDeserialize extends GsonDeserialization
{
	// http://www.guj.com.br/java/300619-resolvidovraptor-consumir-json-com-list
	public GsonDeserialize(ParameterNameProvider paramNameProvider,
			@SuppressWarnings("rawtypes") List<JsonDeserializer> adapters,
			HttpServletRequest request) {
		super(paramNameProvider, (JsonDeserializers) adapters, request);
		//super(paramNameProvider, adapters, request);
	}
}  