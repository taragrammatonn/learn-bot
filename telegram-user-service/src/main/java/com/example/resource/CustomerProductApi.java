package com.example.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customerProductClient", url = "${spring.cloud.openfeign.client.config.customerProductClient.base-url}")
public interface CustomerProductApi {

    @GetMapping("/customer/{customerId}")
    String getCustomerId(@PathVariable String customerId);
}
