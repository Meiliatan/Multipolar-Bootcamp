package com.multipolar.bootcamp.gatewayBank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multipolar.bootcamp.gatewayBank.dto.ErrorMessageDTO;
import com.multipolar.bootcamp.gatewayBank.dto.ProductDTO;
import com.multipolar.bootcamp.gatewayBank.kafka.AccessLog;
import com.multipolar.bootcamp.gatewayBank.service.AccessLogService;
import com.multipolar.bootcamp.gatewayBank.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final String PRODUCT_URL = "http://localhost:8085/product";
    private final RestTemplateUtil restTemplateUtil;
    private final ObjectMapper objectMapper;
    private final AccessLogService logService;

    @Autowired
    public ApiController(RestTemplateUtil restTemplateUtil, ObjectMapper objectMapper, ObjectMapper objectMapper1, AccessLogService logService){
        this.restTemplateUtil = restTemplateUtil;
        this.objectMapper = objectMapper1;
        this.logService = logService;
    }

    //http://localhost:8080/api/getProduct
    @GetMapping("/getProduct")
    public ResponseEntity<?> getProduct() throws JsonProcessingException {
        //akses API customer dan dapatkan datanya
        try {
            ResponseEntity<?> response = restTemplateUtil.getList(PRODUCT_URL, new ParameterizedTypeReference<>() {});
            //kirim AccessLog
            AccessLog accessLog = new AccessLog("GET", PRODUCT_URL, response.getStatusCodeValue(), LocalDateTime.now(), "Successfull");
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("GET", PRODUCT_URL, ex.getRawStatusCode(), LocalDateTime.now(), "Failed");
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }


    //Buat http://localhost:8080/api/createCustomer
    @PostMapping("/createProduct")
    public ResponseEntity<?> postProduct(@RequestBody ProductDTO productDTO)
            throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.post(PRODUCT_URL, productDTO, ProductDTO.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
}
