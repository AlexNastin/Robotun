package by.robotun.webapp.quartz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;

@Component("httpClientSolrJ")
public class HttpClientSolrJ {

	@Autowired
	private PropertyManager propertyManagerCSKA;

	private String serverURL = "";
	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;

	@PostConstruct
	private void initSynchronzationCSAJob() {
		this.serverURL = propertyManagerCSKA.getValue(PropertyName.SOLR_URL_IMPORT);
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
	}

	private String get(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(serverURL + uri, HttpMethod.GET, requestEntity, String.class);
		this.setStatus(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}

	public String solrImport(String uri) {
		return get(uri.toString());
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
