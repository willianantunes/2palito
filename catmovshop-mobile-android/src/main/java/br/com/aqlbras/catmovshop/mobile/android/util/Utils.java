package br.com.aqlbras.catmovshop.mobile.android.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import java.lang.reflect.Type;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Utils 
{
	
	static final DateTimeFormatter DATE_TIME_FORMATTER = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);

	/**
	 * Esse método calcula, em cima do parâmetro, um hash SHA de 512 bits, e o 
	 * transforma em uma String de 128 bits (hexadecimal).
	 * 1 hexadecimal = 4 bits. 512:4 = 128 bits.
	 * @param password
	 * @return Hash de 512 bits em hexadecimal
	 */
	public static String passwordHashing(String password)
	{
		return new String(Hex.encodeHex(DigestUtils.sha512(password)));
	}
	
	
    /**
     * Coverte uma data ISO 8601 em DateTime.
     * @return DateTime
     */
    public static DateTime jsonToDateTime(String strDt) {
        if (strDt == null)
            return null;
        return new DateTime(strDt);
    }
     
    /**
     * Serializer de DateTime.
     */
    private static class DateTimeSerializer implements JsonSerializer<DateTime> {
        public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
        	return new JsonPrimitive(src == null ? "" : DATE_TIME_FORMATTER.print(src));
        }
    }
    /**
     * Deserializer de DateTime.
     */
    private static class DateTimeDeserializer implements JsonDeserializer<DateTime> {
        public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        	return json.getAsString().length() == 0 ? null : DATE_TIME_FORMATTER.parseDateTime(json.getAsString());
        }
    }
     
    /**
     * Gera um objeto Gson com suporte a DateTime.
     * @return objeto Gson gerado.
     */
    public static Gson getGson() {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(DateTime.class, new DateTimeSerializer());
        gson.registerTypeAdapter(DateTime.class, new DateTimeDeserializer());
        return gson.create();
    }	
	
}
