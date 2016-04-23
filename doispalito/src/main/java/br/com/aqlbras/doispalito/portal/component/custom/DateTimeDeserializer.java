package br.com.aqlbras.doispalito.portal.component.custom;

import java.lang.reflect.Type;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import br.com.caelum.vraptor.ioc.Component;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@Component
public class DateTimeDeserializer implements JsonDeserializer<DateTime> 
{
	
	static final DateTimeFormatter DATE_TIME_FORMATTER = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);
	
	@Override
	public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException 
	{		
		return json.getAsString().length() == 0 ? null : DATE_TIME_FORMATTER.parseDateTime(json.getAsString());		
	}

}
