package br.com.aqlbras.doispalito.portal.component.custom;

import com.thoughtworks.xstream.XStream;

import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.serialization.xstream.XStreamBuilderImpl;
import br.com.caelum.vraptor.serialization.xstream.XStreamConverters;

@Component
public class CustomXStreamBuilder extends XStreamBuilderImpl 
{

	public CustomXStreamBuilder(XStreamConverters converters,
			TypeNameExtractor extractor) 
	{
		super(converters, extractor);
	}
	
	// https://groups.google.com/forum/#!topic/caelum-vraptor/dnm8j4-YmVw
	public XStream configure(XStream xstream)
	{
		super.configure(xstream);
		xstream.aliasSystemAttribute(null, "class");
		xstream.aliasSystemAttribute(null, "resolves-to");
		return xstream;
	}

}
