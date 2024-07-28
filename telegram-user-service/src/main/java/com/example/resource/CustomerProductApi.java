package com.example.resource;

import com.example.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(value = "customerProductClient", url = "${spring.cloud.openfeign.client.config.customerProductClient.base-url}")
public interface CustomerProductApi {

    @PutMapping(value = "/customer/{customerId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    UserDto saveOrGet(@PathVariable String customerId, @RequestBody UserDto user);
}
