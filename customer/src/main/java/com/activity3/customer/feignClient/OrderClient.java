package com.activity3.customer.feignClient;

import com.activity3.customer.controller.DTO.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-ordenes")
public interface OrderClient {

    @GetMapping("/orders/orderbycustomer/{id}")
    OrderDTO getOrderById(@PathVariable("id") Long id);
}
