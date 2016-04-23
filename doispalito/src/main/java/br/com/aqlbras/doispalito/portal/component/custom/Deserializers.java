package br.com.aqlbras.doispalito.portal.component.custom;

import br.com.caelum.vraptor.deserialization.DefaultDeserializers;
import br.com.caelum.vraptor.deserialization.Deserializer;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.Container;

@Component
@ApplicationScoped
public class Deserializers extends DefaultDeserializers
{
	// http://www.guj.com.br/java/300619-resolvidovraptor-consumir-json-com-list
	@Override  
	public Deserializer deserializerFor(String contentType, Container container) {  
		if ("application/json".equals(contentType)) 
		{  
			return container.instanceFor(GsonDeserialize.class);  
		}  
		return super.deserializerFor(contentType, container);  
	}  

}  
