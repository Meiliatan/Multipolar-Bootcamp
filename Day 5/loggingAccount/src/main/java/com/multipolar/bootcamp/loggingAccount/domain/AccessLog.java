package com.multipolar.bootcamp.loggingAccount.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "access_log_account")//nama collection

public class AccessLog implements Serializable {

    private String httpMethod;
    private String requestUri;
    private Integer responseStatusCode;
    private String content;
    private String clientIP; //HttpServletRequest getRemoteAddr()
    private String userAgent;
    private LocalDateTime timeStamp = LocalDateTime.now();

}
