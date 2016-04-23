package br.com.aqlbras.doispalito.portal.component.custom;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import br.com.caelum.vraptor.ioc.Component;

import com.thoughtworks.xstream.converters.SingleValueConverter;

// http://xstream.codehaus.org/alias-tutorial.html
// http://www.guj.com.br/java/295622-jodatime-serializa-com-ilocalmillis
// http://www.guj.com.br/java/248728-resolvidovraptor-serializar-em-json-objetos-do-joda-time
// http://www.guj.com.br/java/279169-vraptor-3-como-formatar-um-tipo-date-no-json-resolvido
@Component
public class DateTimeJodaConverter implements SingleValueConverter
{
	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class type) 
	{
		return DateTime.class.isAssignableFrom(type);
	}

	@Override
	public String toString(Object value) 
	{
		DateTime dateTime = new DateTime(value);		
		DateTimeFormatter formatter = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);
		// DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'H:mm:ss.SSSZ");
		//return dateTime.toString(DateTimeFormat.forPattern("dd/MM/yyyy"));
		//return StringConvert.INSTANCE.convertToString(dateTime);
		return dateTime.toString(formatter);
	}
	
	@Override
	public Object fromString(String value) 
	{
		// TODO Auto-generated method stub
		return null;
	}	

}
