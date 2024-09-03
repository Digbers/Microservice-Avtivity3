package com.activity3.customer.controller;

import com.activity3.customer.controller.DTO.CustomerDTO;
import com.activity3.customer.controller.DTO.OrderDTO;
import com.activity3.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customer = customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok(customer);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        CustomerDTO customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long id) {
        Boolean deleted = customerService.deleteCustomer(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        return ResponseEntity.ok(customerDTOS);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO customer = customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getOrderDetailsForCustomer(@PathVariable Long id) {
        OrderDTO order = customerService.getOrderDetailsForCustomer(id);
        return ResponseEntity.ok(order);
    }
}
