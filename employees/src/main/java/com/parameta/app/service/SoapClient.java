package com.parameta.app.service;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "soapservice", url ="http://localhost:8082")
public interface SoapClient {

    @PostMapping(value = "/ws/employees", consumes = "text/xml", produces = "text/xml")
    @Headers("Content-Type: text/xml")
    String saveEmployee(@RequestBody String soapRequest);
}
