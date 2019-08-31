package com.previred.client.periodos.swagger.codegen.api;

import com.previred.client.periodos.swagger.ApiClient;

import com.previred.client.periodos.swagger.codegen.model.Periodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@Component("com.previred.client.periodos.swagger.codegen.api.PeriodosApi")
public class PeriodosApi {
    private ApiClient apiClient;

    public PeriodosApi() {
        this(new ApiClient());
    }

    @Autowired
    public PeriodosApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Lista de periodos a procesar
     * 
     * <p><b>200</b> - Periodo y lista de fechas
     * @return Periodo
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Periodo periodos() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Periodo> returnType = new ParameterizedTypeReference<Periodo>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}