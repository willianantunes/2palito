package br.com.aqlbras.catmovshop.mobile.android.business.common;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.util.Log;
import br.com.aqlbras.catmovshop.mobile.android.repository.common.GenericRepository;
import br.com.aqlbras.catmovshop.mobile.android.util.Utils;

import com.google.gson.Gson;

public class GenericBusiness<T> implements GenericRepository<T> {
	protected String baseURL;
	protected Class<T> classType;

	@SuppressWarnings("unchecked")
	protected GenericBusiness(String baseURL) {
		this.baseURL = baseURL;
		/**
		 * Através da classe atual, GenericBusiness, o tipo genérico é
		 * recuperado e convertido para o tipo parametrizado. Com isso o método
		 * getActualTypeArguments() recupera a lista dos argumentos e devolve
		 * apenas o primeiro por meio de seu índice [0], que é exatamente o tipo
		 * genérico. Por fim, esse tipo genérico é convertido em um Class para
		 * que possamos saber qual classe a nossa classe genérica irá manipular.
		 */
		this.classType = ((Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public void save(T t) throws Exception {
		String url = this.baseURL;

		// Set the Content-Type header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));
		HttpEntity<?> requestEntity = new HttpEntity<Object>(t, requestHeaders);

		// This is where we get the RestTemplate and add the message converters
		RestTemplate restTemplate = new RestTemplate();
		
		

		try {
			
			Gson gson = new Gson();
			gson.toJson( t );
			
			restTemplate.getMessageConverters().add(
					new GsonHttpMessageConverter(Utils.getGson()));
			ResponseEntity<T> responseEntity = restTemplate.exchange(url,
					HttpMethod.POST, requestEntity, this.classType);
			if (responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
				throw new IllegalStateException("Remote server error");
			Log.i(this.classType.toString(),
					String.format("Object was saved successfully"));
		} catch (Exception e) {
			Log.e(this.classType.toString(),
					String.format("Unable to use save() method: (%s)",
							e.getMessage()));
			throw e;
		}
	}

	public T find(T t) throws Exception {
		String url = this.baseURL + "/specific";

		// Set the Content-Type header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));
		HttpEntity<?> requestEntity = new HttpEntity<Object>(t, requestHeaders);

		// This is where we get the RestTemplate and add the message converters
		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.getMessageConverters().add(
					new GsonHttpMessageConverter(Utils.getGson()));
			ResponseEntity<T> responseEntity = restTemplate.exchange(url,
					HttpMethod.POST, requestEntity, this.classType);
			if (responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new IllegalStateException("Remote server error");
			} else if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
				return null;
			}
			return responseEntity.getBody();
		} catch (Exception e) {
			Log.e(this.classType.toString(),
					String.format("Unable to use find() method: (%s)",
							e.getMessage()));
			throw e;
		}
	}

	public T[] list() throws Exception {
		String url = this.baseURL;

		// This is where we get the RestTemplate and add the message converters
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new GsonHttpMessageConverter(false));
		try {

			@SuppressWarnings("unchecked")
			ResponseEntity<T[]> responseEntity = (ResponseEntity<T[]>) restTemplate
					.exchange(
							url,
							HttpMethod.GET,
							getRequestEntity(),
							TypeClass.valueOf(
									this.classType.getName().substring(
											this.classType.getName()
													.lastIndexOf(".") + 1))
									.getArrayType());

			if (responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new IllegalStateException("Remote server error");
			} else if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
				return null;
			}
			// ListAdapter la = responseEntity.getBody();
			// ArrayList<T> al = la.getList();
			// return al;
			return responseEntity.getBody();
		} catch (Exception e) {
			Log.e(this.classType.toString(),
					String.format("Unable to use list() method: (%s)",
							e.getMessage()));
			throw e;
		}
	}

	public T update(T t) throws Exception {
		String url = this.baseURL;

		// Set the Content-Type header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));
		HttpEntity<?> requestEntity = new HttpEntity<Object>(t, requestHeaders);

		// This is where we get the RestTemplate and add the message converters
		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.getMessageConverters().add(
					new GsonHttpMessageConverter(Utils.getGson()));
			ResponseEntity<T> responseEntity = restTemplate.exchange(url,
					HttpMethod.PUT, requestEntity, this.classType);
			if (responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
				throw new IllegalStateException("Remote server error");
			Log.i(this.classType.toString(),
					String.format("Object was updated successfully"));
			return responseEntity.getBody();
		} catch (Exception e) {
			Log.e(this.classType.toString(),
					String.format("Unable to use update() method: (%s)",
							e.getMessage()));
			throw e;
		}
	}

	public void remove(T t) throws Exception {
		String url = this.baseURL;

		// Set the Content-Type header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));
		HttpEntity<?> requestEntity = new HttpEntity<Object>(t, requestHeaders);

		// This is where we get the RestTemplate and add the message converters
		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.getMessageConverters().add(
					new GsonHttpMessageConverter(Utils.getGson()));
			ResponseEntity<T> responseEntity = restTemplate.exchange(url,
					HttpMethod.DELETE, requestEntity, this.classType);
			if (responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
				throw new IllegalStateException("Remote server error");
			Log.i(this.classType.toString(),
					String.format("Object was removed successfully"));
		} catch (Exception e) {
			Log.e(this.classType.toString(),
					String.format("Unable to use remove() method: (%s)",
							e.getMessage()));
			throw e;
		}
	}

	private HttpEntity<?> getRequestEntity() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(new MediaType(
				"application", "json")));
		return new HttpEntity<Object>(requestHeaders);
	}

	/**
	 * This method returns an array of some class. This is a temporary solution.
	 * 
	 * @author Antunes
	 * 
	 */
	public enum TypeClass {
		Fornecedor {
			@Override
			public Class<?> getArrayType() {
				return br.com.aqlbras.catmovshop.mobile.android.model.Fornecedor[].class;
			}
		},
		Usuario {
			@Override
			public Class<?> getArrayType() {
				return br.com.aqlbras.catmovshop.mobile.android.model.Usuario[].class;
			}
		},
		Produto {
			@Override
			public Class<?> getArrayType() {
				return br.com.aqlbras.catmovshop.mobile.android.model.Produto[].class;
			}
		};

		public abstract Class<?> getArrayType();
	}
}
