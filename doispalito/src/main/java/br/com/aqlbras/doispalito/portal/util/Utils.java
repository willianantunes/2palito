package br.com.aqlbras.doispalito.portal.util;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.collect.Lists;

import br.com.aqlbras.doispalito.portal.model.Phone;

public class Utils
{	
	public static final String REGEX_EMAIL = "\\w+[\\w-\\.]*@\\w+[\\w-\\.]*\\.[a-zA-Z]{2,}";
	public static final String REGEX_PHONE = "\\((\\d{2})\\)\\s?(\\d{4,5}-\\d{4})";
	
	public static String decoderText(String text)
	{
		try
		{
			byte[] bytes = text.getBytes("ISO-8859-1");
			text = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			return text;
		}

		return text;
	}
	
	/**
	 * Esse método calcula, em cima do parâmetro, um hash SHA de 512 bits, e o 
	 * transforma em uma String de 128 bits (hexadecimal).
	 * 1 hexadecimal = 4 bits. 512:4 = 128 bits.
	 * @param password
	 * @return Hash de 512 bits em hexadecimal
	 */
	public static String passwordHashing(String password)
	{
		return DigestUtils.sha512Hex(password);
	}		

	public static String i18n(String text)
	{
		try
		{
			return ResourceBundle.getBundle("messages", Locale.getDefault()).getString(text);
		} catch (MissingResourceException e)
		{
			return "???" + text + "???";
		}
	}
	
	// Para JSTL personalizada
	// http://www.guj.com.br/java/44859-jstl-primeira-letra-maiuscula
	public static String capitalize(String palavra)
	{
		return palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
	}
	
	/**
	 * Verifica se um email é válido
	 */
	public static boolean isValidEmail(String email) 
	{
		Pattern pattern = Pattern.compile(REGEX_EMAIL);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * Altera a coleção de {@link Phone} extraindo o código de área do número
	 * caso ele esteja no padrão (11) 1234-5678 ou (11) 12345-6789. Caso o
	 * número não esteja nesse padrão, é lançada uma
	 * {@link IllegalArgumentException} e a coleção não será alterada.
	 * 
	 * @param phones
	 *            Coleção de telefones para extrair o código de área
	 */
	public static void extractAreaCodeFromPhones(Collection<Phone> phones) 
	{
		Pattern pattern = Pattern.compile(REGEX_PHONE);
		Matcher matcher;
		List<Phone> phonesList = Lists.newArrayList(phones);
		for (Phone phone : phonesList) 
		{
			matcher = pattern.matcher(phone.getNumber());
			if (matcher.matches()) 
			{
				phone.setAreaCode(matcher.group(1));
				phone.setNumber(matcher.group(2));
			} 
			else 
			{
				throw new IllegalArgumentException();
			}
		}
		phones.clear();
		phones.addAll(phonesList);
	}
}
