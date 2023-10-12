package com.multipolar.bootcamp.gateway.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

//yang akan dikirimkan ke kafka
public class AccessLog implements Serializable {

    private String method;
    private String status;
    private String message;
}
