package com.multipolar.bootcamp.gatewayAccount.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multipolar.bootcamp.gatewayAccount.dto.AccountDTO;
import com.multipolar.bootcamp.gatewayAccount.dto.ErrorMessageDTO;
//import com.multipolar.bootcamp.gateway.dto.ProductDTO;
import com.multipolar.bootcamp.gatewayAccount.kafka.AccessLog;
import com.multipolar.bootcamp.gatewayAccount.service.AccessLogService;
import com.multipolar.bootcamp.gatewayAccount.util.RestTemplateUtil;
import org.apache.catalina.valves.Constants;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final String ACCOUNT_URL = "http://localhost:8081/bankAccount";
    private final RestTemplateUtil restTemplateUtil;
    private final ObjectMapper objectMapper;
    private final AccessLogService logService;

    @Autowired
    private HttpServletRequest request;

    @Autowired //utk pembuatan objek, otomatis dibuatin
    public ApiController(RestTemplateUtil restTemplateUtil, ObjectMapper objectMapper, AccessLogService logService) {
        this.restTemplateUtil = restTemplateUtil;
        this.objectMapper = objectMapper;
        this.logService = logService;
    }

    //http://localhost:8080/api/getCustomers
    @GetMapping("/getAccounts")
    public ResponseEntity<?> getAccounts() throws JsonProcessingException {
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        try{
            ResponseEntity<?> response = restTemplateUtil.getList(ACCOUNT_URL, new ParameterizedTypeReference<>() {
            });
            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL, response.getStatusCodeValue(), "successful", clientIP, userAgent, LocalDateTime.now()) {
            };
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(),List.class);
            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL, ex.getRawStatusCode(),"failed",clientIP,userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

    //http://localhost:8080/api/createCustomer
    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody AccountDTO accountDTO) throws JsonProcessingException {
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        try {
            ResponseEntity<?> response = restTemplateUtil.post(ACCOUNT_URL, accountDTO, AccountDTO.class);
            AccessLog accessLog = new AccessLog("POST", ACCOUNT_URL, response.getStatusCodeValue(), "successful", clientIP, userAgent, LocalDateTime.now()) {
            };
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("POST", ACCOUNT_URL, ex.getRawStatusCode(), "failed", clientIP, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
    @PutMapping("/updateAccounts/{id}")
    public ResponseEntity<?> createOrUpdateAccount(@PathVariable String id, @RequestBody AccountDTO accountDTO) throws JsonProcessingException {
        String urlWithId = ACCOUNT_URL + "/" + id;
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        try {
            ResponseEntity<?> response = restTemplateUtil.put(urlWithId, accountDTO, AccountDTO.class);
            AccessLog accessLog = new AccessLog("PUT", urlWithId, response.getStatusCodeValue(), "successful", clientIP, userAgent, LocalDateTime.now()) {
            };
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog = new AccessLog("PUT",urlWithId, ex.getRawStatusCode(), "failed", clientIP, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
    @DeleteMapping("/deleteAccounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id){
        String urlWithId = ACCOUNT_URL + "/" + id;
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        try{
            ResponseEntity<Void> response = restTemplateUtil.delete(urlWithId);
            AccessLog accessLog = new AccessLog("DELETE", urlWithId, response.getStatusCodeValue(), "successful", clientIP, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return response;
        }catch (HttpClientErrorException ex){
            AccessLog accessLog = new AccessLog("DELETE",urlWithId, ex.getRawStatusCode(), "failed", clientIP, userAgent, LocalDateTime.now());
            logService.logAccess(accessLog);
            return new ResponseEntity<>(ex.getStatusCode());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable String id) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.getList(ACCOUNT_URL+ "/" + id, new ParameterizedTypeReference<>() {});
            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL + "/" + id,
                    response.getStatusCodeValue(), "successful","", "", LocalDateTime.now());
            logService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            AccessLog accessLog = new AccessLog("GET", ACCOUNT_URL + "/" + id,
                    ex.getRawStatusCode(), "failed","", "", LocalDateTime.now());
            logService.logAccess(accessLog);
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

}
