package br.com.aqlbras.doispalito.portal.component.custom;

import java.lang.reflect.Type;

import br.com.aqlbras.doispalito.portal.model.Product;
import br.com.caelum.vraptor.ioc.Component;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

@Component
public class ProductDeserializer implements JsonDeserializer<Product> 
{

	@Override
	public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException 	
	{
		JsonObject jsonObject = json.getAsJsonObject();
		String type = jsonObject.get("type").getAsString();
		JsonElement element = jsonObject.get("properties");

		try 
		{
			Gson gson = new Gson();			
			return (Product) gson.fromJson(element, Class.forName("br.com.aqlbras.doispalito.portal.model." + type));
		} 
		catch (ClassNotFoundException cnfe) 
		{
			throw new JsonParseException("Unknown element type: " + type, cnfe);
		}
	}

}
