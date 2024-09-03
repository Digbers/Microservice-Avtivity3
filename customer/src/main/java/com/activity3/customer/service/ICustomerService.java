package com.activity3.customer.service;

import com.activity3.customer.controller.DTO.CustomerDTO;
import com.activity3.customer.controller.DTO.OrderDTO;

import java.util.List;

public interface ICustomerService {
    CustomerDTO saveCustomer(CustomerDTO orderDTO);
    CustomerDTO getCustomer(Long id);
    Boolean deleteCustomer(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(Long id, CustomerDTO orderDTO);

    // Nuevo método para obtener detalles del pedido
    OrderDTO getOrderDetailsForCustomer(Long customerId);
}
