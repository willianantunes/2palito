package br.com.aqlbras.doispalito.portal.component.custom;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;

// Tive que criar esse conversor pois o VRaptor, a princípio, não consegue converter para o DateTime do joda-time
@Convert(DateTime.class)
public class DateTimeConverter implements Converter<DateTime>
{
	
	@Override
	public DateTime convert(String value, Class<? extends DateTime> type, ResourceBundle bundle) {
		if(value == null || value.equals(""))
			return null;
		try
		{
			// Implementar para outros "patterns"
			DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
			return formatter.parseDateTime(value);
		}
		catch(Exception e)
		{
			throw new ConversionError(MessageFormat.format(bundle.getString("is_not_a_valid_datetime"), value));
		}
	}

}
