package org.example.order.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient<T,U> {

    private final RestTemplate template;
    private final HttpHeaders headers;
    private final String urlApi;

    public RestClient(String urlApi) {
        this.urlApi = urlApi;
        this.template = new RestTemplate();
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    public T get(U id,Class<T> responseType){
        HttpEntity<String> requestEntity = new HttpEntity<>("",headers);
        ResponseEntity<T> response = template.exchange(urlApi+id, HttpMethod.GET,requestEntity,responseType);
        if(response.hasBody()){
            return response.getBody();
        }
        return null;
    }
}
